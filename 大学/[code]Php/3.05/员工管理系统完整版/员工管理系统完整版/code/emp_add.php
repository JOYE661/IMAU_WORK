<?php

// 员工添加功能
require './init.php'; // 项目初始化文件

// 表单处理
if ($_POST) {
    // 定义允许的字段
    $fields = array('emp_name', 'emp_dept_id', 'emp_birth', 'emp_entry');
    $values = array();
    foreach ($fields as $k => $v) {
        $data = input_post($v);           // 接收$_POST数据
        $data = db_escape(filter($data)); // 数据过滤
        if ($data == '') {
            alert_back($v . '字段不能为空');
        }
        $fields[$k] = "`$v`";             // 把字段使用反引号包裹
        $values[] = "'$data'";            // 把值使用单引号包裹
    }
    $fields = implode(',', $fields);
    $values = implode(',', $values);
    $sql = "insert into pre_emp ($fields) values ($values)";
    // 执行SQL
    if ($res = db_query($sql)) {
        header('location: ./index.php');
        exit;
    } else {
        // 执行失败
        alert_back('员工添加失败！');
    }
}

// 获取部门信息
$sql = "select * from pre_dept";
$dept_info = db_fetch_all($sql);

// 加载视图页面，显示数据
require './view/emp_add.html';
