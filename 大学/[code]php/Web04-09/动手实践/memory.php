<?php
$a = ['a', 'b', 'c'];
echo memory_get_usage();		// 输出结果：354880
echo '<br>';

$e = $d = $c = $b = $a;
echo memory_get_usage();		// 输出结果：354880
echo '<br>';

$e[] = 'e';
echo memory_get_usage();		// 输出结果：355152
echo '<br>';

unset($e);
echo memory_get_usage();		// 输出结果：354880
echo '<br>';

echo memory_get_peak_usage();	// 输出结果：388200（内存峰值）
