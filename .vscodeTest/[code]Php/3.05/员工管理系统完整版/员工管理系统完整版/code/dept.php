<?php

// 部门管理功能

require './init.php';          // 项目初始化文件
$action = input_get('action'); // 获取操作参数

// 部门名称修改
if ($action == 'rename') {
    $id = (int)input_get('id');
    if ($_POST) {
        $rename_new = input_post('dept_name');        // 接收新名称
        $rename_new = db_escape(filter($rename_new)); // 数据过滤
        // 判断名称是否重复
        $sql = "select dept_id from pre_dept where dept_name='$rename_new'";
        $rename_id = db_fetch_column($sql);
        if ($rename_id && $rename_id != $id) {
            alert_back('该部门名称已经存在！');
        }
        $sql = "update pre_dept set dept_name='$rename_new' where dept_id=$id";
        db_query($sql);
        header('Location:dept.php'); // 执行后清除参数
        exit;
    }
    $sql = "select dept_name from pre_dept where dept_id=$id";
    $rename = db_fetch_column($sql);
    // 添加部门
} elseif ($action == 'add') {
    if ($_POST) {
        $add_new = input_post('dept_name');     // 接收新名称
        $add_new = db_escape(filter($add_new)); // 数据过滤
        // 判断名称是否重复
        $sql = "select dept_id from pre_dept where dept_name='$add_new'";
        $add_id = db_fetch_column($sql);
        if ($add_id) {
            alert_back('该部门名称已经存在！');
        }
        $sql = "insert into pre_dept (dept_id,dept_name) values (null,'$add_new')";
        db_query($sql);
        header('Location: dept.php'); // 执行后清除参数
        exit;
    }
    // 删除部门
} elseif ($action == 'del') {
    $id = (int)input_get('id');
    $sql = "delete from pre_dept where dept_id=$id";
    db_query($sql);
    header('Location: dept.php');
    exit;
}
// 查询部门列表
$sql = "select * from pre_dept";
$dept_info = db_fetch_all($sql);
// 加载视图页面，显示数据
require './view/dept.html';
