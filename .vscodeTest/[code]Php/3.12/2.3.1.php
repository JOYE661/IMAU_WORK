<?php
$flag1 = true;		// 将true赋值给变量$flag1
$flag2 = false;		// 将false赋值为变量$flag2

$oct = 073;			// 八进制数
$dec = 59;			// 十进制数
$hex = 0x3b;		// 十六进制数

$number1 = 2147483647;
var_dump($number1);	          		 // int(2147483647)
$number2 = 2147483648;
var_dump($number2);		           	 // float(2147483648)

$fnum1 = 1.759;
$fnum2 = -4.382;

$fnum3 = 1.234E-2; 		// 等同于0.01234
$fnum4 = 7.469E-4; 		// 等同于0.0007469

echo "嵌套\"双引号\"";		// 输出结果：嵌套"双引号"
echo '嵌套\'单引号\'';		// 输出结果：嵌套'单引号'

$ap = 'ma';
$apple = 'test';
echo "$apple";			// 不解析$ap变量，输出结果：test
echo "{$ap}ple";		// 解析$ap变量，输出结果：maple
