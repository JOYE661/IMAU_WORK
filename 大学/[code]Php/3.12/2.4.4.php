<?php
$age = 20;
echo $age >= 18 ? '已成年' : '未成年';		// 输出结果：已成年

$age = 5;
echo $age ? $age : '未出生';		        // 正常形式，输出结果：5
echo $age ? : '未出生';			            // 简写形式，输出结果：5
