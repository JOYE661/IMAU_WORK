<?php
$str = 'abc';
$result = preg_replace('/b/', 'd', $str);
echo $result;            // 输出结果：adc
echo '<br>';

$str = 'abc';
$result = preg_replace('/(b)/', '[\1 $1 ${1}]', $str);
echo $result;            // 输出结果：a[b b b]c
echo '<br>';

$result = preg_replace('/a(b)/', '[\0]', $str);
echo $result;            // 输出结果：[ab]c
echo '<br>';

$arr = ['a', 'b', 'c'];
$result = preg_replace('/b|c/', 'd', $arr);
print_r($result);      // 输出结果：Array ( [0] => a [1] => d [2] => d )
echo '<br>';

$str = '1234';
$result = preg_replace(['/1/', '/2/'], ['a', 'b'], $str);
echo $result;           // 输出结果：ab34
echo '<br>';

$str = 'abbc';
$result = preg_replace('/b/', 'd', $str);
echo $result;           // 输出结果：addc
echo '<br>';

$result = preg_replace('/b/', 'd', $str, 1);
echo $result;           // 输出结果：adbc
echo '<br>';

$str = 'abbc';
preg_replace('/b/', 'd', $str, -1, $count);
echo $count;            // 输出结果：2
