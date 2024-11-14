<?php
echo strlen('abc');				// 输出结果：3
echo strlen('P H P');			// 输出结果：5
echo strlen('字符串');			// 输出结果：9
$str = 'PHP基础案例教程';
echo strlen($str);				// 输出结果：21

$str = 'PHP基础案例教程';
echo mb_strlen($str, 'UTF-8');	// 输出结果：9
