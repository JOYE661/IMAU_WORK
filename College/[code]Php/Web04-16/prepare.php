<?php
// 连接数据库、设置字符集、预处理SQL模板
$link = mysqli_connect('localhost', 'root', '123456', 'mydb');
mysqli_set_charset($link, 'utf8');
$stmt = mysqli_prepare($link, 'UPDATE `student` SET `name`=? WHERE `id`=?');
// 参数绑定，并为已经绑定的变量赋值
mysqli_stmt_bind_param($stmt, 'si', $name, $id);
$name = 'Ileana';
$id = 1;
// 执行预处理（第1次执行）
mysqli_stmt_execute($stmt);
// 为第2次执行重新赋值
$name = 'Dirk';
$id = 2;
//执行预处理（第2次执行）
mysqli_stmt_execute($stmt);

$data = [['name' => 'Ileana', 'id' => 3], ['name' => 'Dirk', 'id' => 4]];
foreach ($data as $v) {
    $name = $v['name'];
    $id = $v['id'];
    mysqli_stmt_execute($stmt);
}
