<?php
$subject = "It's a nice day today";
// 匹配以“It”开头的字符串
preg_match('/^It/', $subject, $matches);
print_r($matches);  // 输出结果: Array ( [0] => It )
echo '<br>';

// 匹配以“today”结尾的字符串
preg_match('/today$/', $subject, $matches);
print_r($matches);  // 输出结果: Array ( [0] => today )
echo '<br>';

$subject = "It's today";
preg_match('/^It\'s today$/', $subject, $matches);
print_r($matches);  // 输出结果: Array ( [0] => It's today )
