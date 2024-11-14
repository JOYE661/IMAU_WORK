<?php
session_start();
$_SESSION['user'] = [];				// 删除所有数据
session_destroy();					// 结束当前会话
header("Location:login.html");		// 用户未登录，跳转到登录页面
