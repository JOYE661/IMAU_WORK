<?php
session_start();					// 开启Session
$_SESSION['username'] = 'Tom';		// 向Session添加数据（字符串）
$_SESSION['id'] = [1, 2, 3];		// 向Session添加数据（数组）
if (isset($_SESSION['test'])) {		// 判断Session中是否存在test
    $test = $_SESSION['test'];		// 读取Session中的test
}
unset($_SESSION['username']);		// 删除单个数据
$_SESSION = [];						// 删除所有数据
session_destroy();					// 结束当前会话
