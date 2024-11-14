<?php

// 连接数据库、设置字符集
$link = mysqli_connect('localhost', 'root', '123456', 'mydb');
mysqli_set_charset($link, 'utf8');
// 获取查询结果集
$result = mysqli_query($link, 'SELECT * FROM `student`');

// 一次查询所有记录
$data = mysqli_fetch_all($result, MYSQLI_ASSOC);
echo '<pre>';
// 输出查询结果
var_dump($data);
echo '</pre>';
