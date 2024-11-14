<?php
// ① 连接数据库、选择数据库、设置字符集
$mysqli = new mysqli('localhost', 'root', '123456', 'mydb');
$mysqli->set_charset('utf8');
// ② 预处理SQL语句
$stmt = $mysqli->prepare('INSERT INTO `student`(`name`,`gender`) VALUES(?,?)');
// ③ 准备插入的数据
$data = [
    ['name' => 'Tom', 'gender' => '男'],
    ['name' => 'Lucy', 'gender' => '女'],
    ['name' => 'Jimmy', 'gender' => '男'],
    ['name' => 'Jack', 'gender' => '男']
];
// ④ 参数绑定
$stmt->bind_param('ss', $name, $gender);
// ⑤ 执行预处理的SQL语句
foreach ($data as $v) {
    $name = $v['name'];
    $gender = $v['gender'];
    $stmt->execute();
}
