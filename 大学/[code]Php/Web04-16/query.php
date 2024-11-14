<?php
// 连接数据库
$link = mysqli_connect('localhost', 'root', '123456');
mysqli_set_charset($link, 'utf8');			// 设置字符集
mysqli_query($link, 'USE `mydb`');  		// 选择数据库
// 执行SQL语句，并获取结果集
$result = mysqli_query($link, 'SHOW TABLES');
if (!$result) {
    exit('错误信息：' . mysqli_error($link));
}
