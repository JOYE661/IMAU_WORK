<?php
date_default_timezone_set('Asia/Shanghai');
session_set_cookie_params(0, null, null, null, true);
mb_internal_encoding('UTF-8');
require './common/function.php';
require './common/library/Db.php';
require './common/library/SessionDb.php';
new SessionDb(Db::getInstance());
session_start();
// 为项目创建Session，统一保存到fun中
if(!isset($_SESSION['fun'])){
	$_SESSION = ['fun' => []];
}
// 检查是否有表单提交
define('IS_POST', ($_POST || $_FILES));
// 检查用户登录
define('IS_LOGIN', isset($_SESSION['fun']['user']));
// 生成和验证CSRF令牌
define('TOKEN', token_get());
if((IS_POST || isset($_GET['action'])) && !token_check(input('get', 'token', 's'))) {
	exit('操作失败：非法令牌。');
}
// 如果用户已经登录，取出用户信息
IS_LOGIN && user(null, $_SESSION['fun']['user']);
// 当前用户是否为管理员
define('IS_ADMIN', IS_LOGIN && user('group') == 'admin');