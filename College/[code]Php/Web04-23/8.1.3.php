<?php
$result = preg_match('/web/', 'phpwebphpweb', $matches);
print_r($matches);  // 输出结果: Array ( [0] => web )
echo '<br>';
var_dump($result);  // 输出结果: int (1)
echo '<br>';

$result = preg_match_all('/web/', 'phpwebphpweb', $matches);
print_r($matches);  // 输出结果: Array ( [0] => web [1] => web )
echo '<br>';
var_dump($result);  // 输出结果: int (2)
