<?php
$start = microtime(true); 				// 记录开始时间
for ($i = 0; $i < 3000000; ++$i) { }	// 执行运算
$end = microtime(true); 				// 记录结束时间
echo $end - $start;						// 参考输出结果：0.43202495574951
