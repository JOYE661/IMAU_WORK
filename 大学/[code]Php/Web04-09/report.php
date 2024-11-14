<?php
ini_set('display_errors', 1);         // 显示错误报告
error_reporting(E_ALL);               // 显示所有级别的错误报告
echo $info;
error_reporting(E_ALL & ~E_NOTICE);   // 显示除E_NOTICE之外的错误报告
echo $info;
