<?php
// CREATE DATABASE `mydb`;

// 连接数据库
$link = mysqli_connect('localhost', 'root', '123456', 'mydb', '3306');
// 查看连接数据库是否正确
echo $link ? '连接数据库成功' : '连接数据库失败';

$link = @mysqli_connect('localhost', 'root', '123456', 'mydb', '3306');
if (!$link) {
    exit(mysqli_connect_error());
}

// 连接数据库
$link = mysqli_connect('localhost', 'root', '123456');
if (!$link) {
    exit(mysqli_connect_error());
}
// 设置字符集
if (!mysqli_set_charset($link, 'utf8')) {
    exit(mysqli_error($link));
}

// 关闭数据库连接
mysqli_close($link);
