<?php

// 默认关闭调试模式
if (!defined('DB_DEBUG')) {
    defined('DB_DEBUG', false);
}

/**
 * 初始化数据库连接
 * @param array $config 数据库连接信息
 */
function db_init($config = array()) {
    static $link;
    if ($link) {
        return $link;
    }
    // 数据库默认连接信息
    $def_config = array(
        'host' => '127.0.0.1',
        'user' => 'root',
        'password' => '',
        'charset' => 'utf8',
        'dbname' => '',
        'port' => 3306
    );
    // 如果传参，则覆盖默认设置
    $config = array_merge($def_config, $config);
    // 连接数据库
    $link = @mysqli_connect($config['host'], $config['user'], $config['password'], $config['dbname'], $config['port']);
    // 判断数据库连接是否成功，如果不成功则显示错误信息并终止脚本继续执行
    if (!$link) {
        if (DB_DEBUG) {
            exit('连接数据库失败！' . mysqli_connect_error());
        } else {
            exit('连接数据库失败！');
        }
    }
    // 设置字符集
    mysqli_set_charset($link, $config['charset']);
    return $link;
}

/**
 * 执行SQL的方法
 * @param string $sql 待执行的SQL
 * @return mixed 失败返回false，成功，如果是查询语句返回结果集，如果非查询类返回true
 */
function db_query($sql) {
    // 执行SQL语句
    if ($result = mysqli_query(db_init(), $sql)) {
        return $result;
    } else if (DB_DEBUG) {
        echo 'SQL执行失败:<br>';
        echo '错误的SQL为:', $sql, '<br>';
        echo '错误的代码为:', mysqli_errno($link), '<br>';
        echo '错误的信息为:', mysqli_error($link), '<br>';
        exit;
    } else {
        exit('SQL语句执行失败。');
    }
}

/**
 * 处理结果集中有多行数据的方法
 * @param string $sql 待执行的SQL
 * @return array 返回遍历结果集后的二维数组
 */
function db_fetch_all($sql) {
    // 执行query()函数
    if ($result = db_query($sql)) {
        // 执行成功
        // 遍历结果集
        $rows = array();
        while ($row = mysqli_fetch_array($result, MYSQLI_ASSOC)) {
            $rows[] = $row;
        }
        // 释放结果集资源
        mysqli_free_result($result);
        return $rows;
    } else {
        // 执行失败
        return false;
    }
}

/**
 * 处理结果集中只有一行数据的方法
 * @param string $sql 待执行的SQL语句
 * @return array 返回结果集处理后的一维数组
 */
function db_fetch_row($sql) {
    // 执行query()函数
    if ($result = db_query($sql)) {
        // 从结果集取得一次数据即可
        $row = mysqli_fetch_array($result, MYSQLI_ASSOC);
        return $row;
    } else {
        return false;
    }
}

/**
 * 处理结果集只有一个数据的方法
 */
function db_fetch_column($sql) {
    if ($result = db_query($sql)) {
        $row = mysqli_fetch_row($result);
        return $row[0];
    } else {
        return false;
    }
}

/**
 * 对数据进行SQL转义
 * @param string $data 待转义字符串
 * @return string 转义后的字符串
 */
function db_escape($data) {
    // 转义字符串中的特殊字符
    return mysqli_real_escape_string(db_init(), $data);
}
