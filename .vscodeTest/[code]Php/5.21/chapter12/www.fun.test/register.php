<?php
require './common/init.php';
// 处理表单
if (IS_POST) {
    $name = input('post', 'name', 's');
    $password = input('post', 'password', 's');
    $email = input('post', 'email', 's');
    // 判断验证码
    if (!captcha_check(input('post', 'captcha', 's'))) {
        display('注册失败，验证码输入有误。');
    }
    // 验证用户名、密码、邮箱格式
    if (!input_check('user_name', $name, $error)) {
        display("注册失败，用户名格式有误，要求：$error");
    }
    if (!input_check('user_password', $password, $error)) {
        display("注册失败，密码格式有误，要求：$error");
    }
    if (!input_check('user_email', $email)) {
        display('注册失败，邮箱格式有误。');
    }
    if (!register($name, $password, $email, $error)) {
        display("注册失败，$error", $name, $email);
    }
}
// 显示页面
display();

// 注册新用户
function register($name, $password, $email, &$error = '')
{
    // 判断用户名是否已经存在
    $db = Db::getInstance();
    if ($db->value('__USER__', 'id', 's', ['name' => $name])) {
        $error = '用户名已经存在。';
        return false;
    }
    $salt = substr(uniqid(), -6);
    $data = ['group' => 'user', 'name' => $name, 'password' => password($password, $salt), 'salt' => $salt, 'email' => $email, 'time' => time()];
    if (!$id = $db->insert('__USER__', 'sssssi', $data)) {
        $error = '数据库保存失败。';
        return false;
    }
    register_success($id, $name, 'user');
}

// 注册成功
function register_success($id, $name, $group)
{
    // 记住登录状态
    $_SESSION['fun']['user'] = ['id' => $id, 'name' => $name, 'group' => $group];
    // 跳转首页
    redirect('index.php');
}

// 显示页面并退出
function display($tips = null, $name = '', $email = '')
{
    require './view/register.html';
    exit;
}
