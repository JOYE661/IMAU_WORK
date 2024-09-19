<?php
// ① 使用未定义的变量
echo $var;				// 错误信息“Notice: Undefined variable...”
// ② 使用未定义的常量
echo PI;				// 错误信息“Notice: Use of undefined constant...”
// ③ 访问不存在的数组元素
$arr = array();
echo $arr['age'];		// 错误信息“Notice: Undefined index: age...”
