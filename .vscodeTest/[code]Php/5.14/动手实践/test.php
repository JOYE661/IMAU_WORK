<?php
require './SessionDB.php';
new SessionDB();		// 配置Session入库
session_start();   		// 启动Session
$_SESSION['test'] = 'content';
