<?php
echo time();						// 输出结果：1616747150
echo '<br>';
echo mktime(0, 0, 0, 3, 1, 2021);	// 输出结果：1614528000
echo '<br>';
echo strtotime('2021-3-1');			// 输出结果：1614528000
echo '<br>';
echo microtime();					// 输出结果：0.80917800 1616747411
echo '<br>';
echo microtime(true);				// 输出结果：1616747411.8092
echo '<br>';
echo date('Y-m-d H:i:s');			// 输出结果：2021-03-26 16:48:16
echo '<br>';
echo date('Y-m-d', 1616747140);		// 输出结果：2021-03-26
