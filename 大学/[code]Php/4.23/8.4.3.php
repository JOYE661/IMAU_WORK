<?php
$arr = preg_split('/[@\.]/', 'abc@163.com');
print_r($arr);  // 输出结果：Array ( [0] => abc [1] => 163 [2] => com )
echo '<br>';

$arr = preg_split('/a/', 'banana', 2);
print_r($arr);  // 输出结果: Array ( [0] => b [1] => nana )
echo '<br>';

// 设置前
$arr = preg_split('/2/', '12');
print_r($arr); // 输出结果：Array ( [0] => 1 [1] => )
echo '<br>';

// 设置后
$arr = preg_split('/2/', '12', -1, PREG_SPLIT_NO_EMPTY);
print_r($arr); // 输出结果：Array ( [0] => 1 )
echo '<br>';

// 设置前
$arr = preg_split('/(2)/', '12');
print_r($arr); // 输出结果：Array ( [0] => 1 [1] => )
echo '<br>';

// 设置后
$arr = preg_split('/(2)/', '12', -1, PREG_SPLIT_DELIM_CAPTURE);
print_r($arr); // 输出结果：Array ( [0] => 1 [1] => 2 [2] => )
echo '<br>';

$arr = preg_split('/2/', '123', -1, PREG_SPLIT_OFFSET_CAPTURE);
/* 输出结果：Array (
  [0] => Array ( [0] => 1 [1] => 0 )
  [1] => Array ( [0] => 3 [1] => 2 )
) */
print_r($arr);
