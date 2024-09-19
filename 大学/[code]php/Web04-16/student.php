<?php
/*
CREATE TABLE IF NOT EXISTS `student` (
  `id` INT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT '学号',
  `name` VARCHAR(32) NOT NULL COMMENT '姓名',
  `gender` ENUM('男', '女') DEFAULT '男' NOT NULL COMMENT '性别'
) DEFAULT CHARSET=utf8;

INSERT INTO `student` (`name`, `gender`) VALUES 
('Tom', '男'), ('Lucy', '女'), ('Jimmy', '男'), ('Amy', '女');
INSERT INTO `student` VALUES 
(NULL, 'Elma', '女'), (NULL, 'Ruth', '女');
*/

// 连接数据库、设置字符集
$link = mysqli_connect('localhost', 'root', '123456', 'mydb');
mysqli_set_charset($link, 'utf8');
// 获取查询结果集
$result = mysqli_query($link, 'SELECT * FROM `student`');

// 一次查询一行记录
echo '<table><tr><th>id</th><th>name</th><th>gender</th></tr>';
while ($row = mysqli_fetch_assoc($result)) {
    echo '<tr><td>' . $row['id'] . '</td>';
    echo '<td>' . $row['name'] . '</td>';
    echo '<td>' . $row['gender'] . '</td></tr>';
}
echo '</table>';
