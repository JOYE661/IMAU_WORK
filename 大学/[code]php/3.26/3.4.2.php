<?php
echo abs(-4.2);					// 输出结果：4.2
echo '<br>';
echo ceil(5.2);	   				// 输出结果：6
echo '<br>';
echo floor(7.8);	   			// 输出结果：7 
echo '<br>';
echo fmod(3.75, 1.5);			// 输出结果：0.75
echo '<br>';
var_dump(is_nan(12)); 			// 输出结果：bool(false)
echo '<br>';
echo max(1, 3, 5, 7, 9); 		// 输出结果：9
echo '<br>';
echo min(1, 3, 5, 7, 9); 		// 输出结果：1
echo '<br>';
echo pi();						// 输出结果：3.1415926535898
echo '<br>';
echo pow(2, 2);					// 输出结果：4
echo '<br>';
echo sqrt(9); 					// 输出结果：3
echo '<br>';
echo round(8.4);				// 输出结果：8
echo '<br>';
echo rand(1, 20);	   			// 随机输出1到20间的整数, 输出结果：16
