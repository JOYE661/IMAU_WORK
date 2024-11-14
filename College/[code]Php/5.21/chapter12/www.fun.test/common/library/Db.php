<?php

class Db
{

    private static $instance;
    private static $mysqli;

    private function __construct()
    {
        $config = config('DB_CONNECT');
        self::$mysqli = new mysqli($config['host'], $config['user'], $config['pass'], $config['dbname'], $config['port']);
        if (self::$mysqli->connect_error) {
            exit('数据库连接失败：' . self::$mysqli->connect_error());
        }
        self::$mysqli->set_charset(config('DB_CHARSET'));
    }

    private function __clone() {}

    public static function getInstance()
    {
        return self::$instance ?: self::$instance = new self();
    }

    /**
     * 执行SQL语句
     * @param string $sql SQL语句，支持表名替换（pre_table -> __TABLE__）
     * @param string $type 参数绑定的数据类型（i、d、s、b）
     * @param array $data 参数绑定的数据（支持二维数组批量处理）
     * @return mysqli_stmt
     */
    public function query($sql, $type = '', array $data = [])
    {
        // 替换SQL语句中的表名
        $sql = preg_replace_callback('/__([A-Z0-9_-]+)__/sU', function($match) {
            return '`' . config('DB_PREFIX') . strtolower($match[1]) . '`';
        }, $sql);
        // 预处理、参数绑定、执行
        if (!$stmt = self::$mysqli->prepare($sql)) {
            exit("SQL[$sql]预处理失败：" . self::$mysqli->error);
        }
        if ($data) {
            $data = is_array(current($data)) ? $data : [$data];
            $params = array_shift($data);
            $args = [$type];
            foreach ($params as &$args[]) ;
            call_user_func_array([$stmt, 'bind_param'], $args);
        }
        if (!$stmt->execute()) {
            exit('数据库操作失败：' . $stmt->error);
        }
        foreach ($data as $row) {
            foreach ($row as $k => $v) {
                $params[$k] = $v;
            }
            if (!$stmt->execute()) {
                exit('数据库操作失败：' . $stmt->error);
            }
        }
        return $stmt;
    }

    public function execute($sql, $type = '', array $data = [])
    {
        $stmt = $this->query($sql, $type, $data);
        return (strtoupper(substr(trim($sql), 0, 6)) == 'INSERT') ? $stmt->insert_id : $stmt->affected_rows;
    }

    public function fetchAll($sql, $type = '', array $data = [])
    {
        return $this->query($sql, $type, $data)->get_result()->fetch_all(MYSQLI_ASSOC);
    }

    public function fetchRow($sql, $type = '', array $data = [])
    {
        return $this->query($sql, $type, $data)->get_result()->fetch_assoc();
    }

    public function select($table, $fields, $type = '', array $data = [], $method = 'fetchAll')
    {
        $fields = str_replace(',', '`,`', $fields);
        $where = implode(' AND ', self::buildFields(array_keys($data)));
        $limit = ($method == 'fetchRow') ? 'LIMIT 1' : '';
        return $this->$method("SELECT `$fields` FROM $table WHERE $where $limit", $type, $data);
    }

    public function find($table, $fields, $type = '', array $data = [])
    {
        return $this->select($table, $fields, $type, $data, 'fetchRow');
    }

    public function value($table, $field, $type = '', array $data = [])
    {
        return $this->find($table, $field, $type, $data, 'fetchRow')[$field];
    }

    public function insert($table, $type, array $data, $mode = 'INSERT')
    {
        $fields = self::arrayFields($data);
        $sql = "$mode INTO $table SET " . implode(',', self::buildFields($fields));
        return $this->execute($sql, $type, $data);
    }

    public function replace($table, $type, array $data)
    {
        return $this->insert($table, $type, $data, 'REPLACE');
    }

    public function update($table, $type, array $data, $where = 'id')
    {
        $where = explode(',', $where);
        $fields = array_diff(self::arrayFields($data), $where);
        return $this->execute("UPDATE $table SET " . implode(',', self::buildFields($fields)) . ' WHERE ' . implode(' AND ', self::buildFields($where)), $type, $data);
    }

    public function delete($table, $type, array $data)
    {
        $fields = implode(' AND ', self::buildFields(self::arrayFields($data)));
        return $this->execute("DELETE FROM $table WHERE $fields", $type, $data);
    }

    // 从一维或二维数组中获取字段
    private static function arrayFields(array $data)
    {
        $row = current($data);
        return array_keys(is_array($row) ? $row : $data);
    }

    // 将字段数组转换为SQL形式
    private static function buildFields(array $fields)
    {
        return array_map(function($v) { return "`$v`=?"; }, $fields);
    }
}
