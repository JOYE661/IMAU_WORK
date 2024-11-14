<?php
session_start();
if ($_POST) {
    // 接收用户登录表单信息
    $user = isset($_POST['user']) ? trim($_POST['user']) : '';
    $pwd = isset($_POST['pwd']) ? trim($_POST['pwd']) : '';
    // 保存正确的用户名和密码信息
    $data = ['user' => 'Tom', 'pwd' => 123456];
    // 判断用户信息是否正确
    if (($user == $data['user']) && ($pwd == $data['pwd'])) {
        // 保存登录信息到Session，并跳转到首页
        $_SESSION['user'] = $data['user'];
        header('Location: index.php');
        exit;
    } else {
        echo '用户名或密码输入不正确，登录失败。';
    }
}
require './login.html';
