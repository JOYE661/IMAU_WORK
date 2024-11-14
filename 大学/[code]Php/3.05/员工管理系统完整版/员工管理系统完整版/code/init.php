<?php

// 设定字符集
header('Content-Type:text/html;charset=utf-8');

// 开启调试模式
define('DB_DEBUG', true);

// 加载数据库操作函数库
require './lib/db_function.php';

// 初始化数据库
db_init(array(
    'host' => '127.0.0.1',  // 主机名
    'user' => 'root',       // 用户名
    'password' => '123456', // 密码
    'dbname' => 'itcast',   // 数据库
    'charset' => 'utf8'     // 字符集
));

// 接收GET变量
function input_get($name) {
    return isset($_GET[$name]) ? $_GET[$name] : '';
}

// 接收POST变量
function input_post($name) {
    return isset($_POST[$name]) ? $_POST[$name] : '';
}

/**
 * 对字符串数据进行过滤
 * @param string $data 待转义字符串
 * @return string 转义后的字符串
 */
function filter($data, $func = array('trim', 'htmlspecialchars')) {
    foreach ($func as $v) {
        // 调用可变函数过滤数据
        $data = $v((string)$data);
    }
    return $data;
}

/**
 * JavaScript弹窗并返回
 */
function alert_back($msg) {
    echo "<script>alert('$msg');history.back();</script>";
    exit;
}
