<?php

// 员工删除功能

require './init.php'; // 项目初始化文件

$id = (int)input_get('id');
$sql = "delete from pre_emp where emp_id=$id";
db_query($sql);

// 删除后返回员工列表
header('Location: index.php');
