<?php
require './common/init.php';
// 接收参数
$action = input('get', 'action', 's');
// 退出登录
if ($action == 'logout') {
    unset($_SESSION['fun']['user']);
    setcookie('fun_auto_name', '', -1);
    setcookie('fun_auto_pass', '', -1);
    redirect('./');
}
// 检查是否已经记住密码
define('IS_AUTOLOGIN', isset($_COOKIE['fun_auto_name']));
// 处理表单
if (IS_POST) {
    if (IS_AUTOLOGIN) {
        // 通过Cookie登录
        $name = input('cookie', 'fun_auto_name', 's');
        $pass = input('cookie', 'fun_auto_pass', 's');
        if (!captcha_check(input('post', 'captcha', 's'))) {
            display('登录失败，验证码输入有误。', $name);
        }
        if (!input_check('user_name', $name, $error)) {
            display("登录失败，用户名格式有误，要求：$error", $name);
        }
        if (!login_cookie($name, $pass, $error)) {
            display("登录失败：$error", $name);
        }
    } else {
        // 通过表单登录
        $name = input('post', 'name', 's');
        $password = input('post', 'password', 's');
        if (!captcha_check(input('post', 'captcha', 's'))) {
            display('登录失败，验证码输入有误。', $name);
        }
        if (!input_check('user_name', $name, $error)) {
            display("登录失败，用户名格式有误，要求：$error", $name);
        }
        if (!input_check('user_password', $password, $error)) {
            display("登录失败，密码格式有误，要求：$error", $name);
        }
        if (!login_form($name, $password, $error)) {
            display("登录失败，$error");
        }
    }
}
// 显示页面
display();

// 通过表单登录
function login_form($name, $password, &$error = '')
{
    // 根据用户名取出密码
    $data = Db::getInstance()->find('__USER__', 'id,group,name,password,salt', 's', ['name' => $name]);
    // 判断密码是否正确
    if ($data && (password($password, $data['salt']) == $data['password'])) {
        // 保存自动登录
        if (input('post', 'auto', 's')) {
            $expires = time() + config('AUTOLOGIN_EXPIRES');
            setcookie('fun_auto_name', $data['name'], $expires);
            setcookie('fun_auto_pass', autologin_cookie($data['password']), $expires);
        }
        login_success($data['id'], $data['name'], $data['group']);
    }
    $error = '用户名或密码错误。';
}

// 通过Cookie登录
function login_cookie($name, $pass, &$error = '')
{
    $data = Db::getInstance()->find('__USER__', 'id,group,name,password', 's', ['name' => $name]);
    if ($data && autologin_check($pass, $data['password'])) {
        login_success($data['id'], $data['name'], $data['group']);
    }
    $error = '保存的登录信息无效，请重新登录。';
    setcookie('fun_auto_name', '', -1);
    setcookie('fun_auto_pass', '', -1);
}

// 登录成功
function login_success($id, $name, $group)
{
    // 记住登录状态
    $_SESSION['fun']['user'] = ['id' => $id, 'name' => $name, 'group' => $group];
    // 跳转首页
    redirect('index.php');
}

// 显示页面并退出
function display($tips = null, $name = '')
{
    require './view/login.html';
    exit;
}
