<?php
function test()
{
    $sum = 36; 				// 局部变量
    return $sum;
}
$sum = 0; 					// 全局变量
echo test();				// 输出结果：36
echo $sum;              	// 输出结果：0
