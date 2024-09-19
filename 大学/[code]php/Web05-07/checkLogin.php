<?php
header("Content-Type:text/html;charset=utf-8");

//开启session
session_start();

//判断是否有表单提交
if(empty($_POST)){
	die('没有表单提交，程序退出');
}

//获取用户输入的验证码字符串
$code = isset($_POST['captcha']) ? trim($_POST['captcha']) : '';

//判断SESSION中是否存在验证码
if(empty($_SESSION['code'])){
	die('验证码已过期，请重新登录。');
}

//将字符串都转成小写然后再进行比较
if (strtolower($code) == strtolower($_SESSION['code'])){
	 echo '验证码正确';	 
} else{
                 echo '验证码输入错误';
}
unset($_SESSION['code']); //清除SESSION数据

header('refresh:2;url=./login.html'); //跳转到登录页面
die; //终止脚本