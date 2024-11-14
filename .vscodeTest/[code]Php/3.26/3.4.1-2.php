<?php
$tel = '18810881888';
$len = 4;                                        // 需要替换的手机号长度
$replace = str_repeat('*', $len);              	 // 生成覆盖的字符串
echo substr_replace($tel, $replace, 3, $len);	 // 输出结果：188****1888
