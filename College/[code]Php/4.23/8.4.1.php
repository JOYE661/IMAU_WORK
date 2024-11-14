<?php
$arr = ['A', 'B', 'C', 'D'];
$matches = preg_grep('/A|C/', $arr);
print_r($matches);     // 输出结果: Array( [0] => A [2] => C )
echo '<br>';

$arr = ['A', 'B', 'C', 'D'];
$matches = preg_grep('/A|C/', $arr, PREG_GREP_INVERT);
print_r($matches);     // 输出结果: Array( [1] => B [3] => D )
