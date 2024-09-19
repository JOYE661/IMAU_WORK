<?php
$a = 1;
$b = 0;

var_dump($a & $b);
var_dump($a | $b);
var_dump(~$a);
var_dump($a ^ $b);
var_dump($a << $b);
var_dump($a >> $b);

var_dump(6 & 11);
var_dump(6 | 11);
var_dump(~6);
var_dump(6 ^ 11);
var_dump(11 << 1);
var_dump(11 >> 1);

$file = 4 | 2 | 1;             	// 添加 读取、写入、执行 权限
var_dump(($file & 4) == 4);    	// 判断是否有 读取 权限
var_dump(($file & 2) == 2);    	// 判断是否有 写入 权限
var_dump(($file & 1) == 1);    	// 判断是否有 执行 权限
