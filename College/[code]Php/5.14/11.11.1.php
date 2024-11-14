<?php
// ① 连接数据库，并选择mydb数据库
$mysqli = new mysqli('localhost', 'root', '123456', 'mydb');
// ② 设置字符集
$mysqli->set_charset('utf8');
// ③ 执行SQL语句
$result = $mysqli->query('SHOW TABLES');
// ④ 处理结果集
$data = $result->fetch_all(MYSQLI_ASSOC);
// ⑤ 输出关联数组结果
print_r($data);
