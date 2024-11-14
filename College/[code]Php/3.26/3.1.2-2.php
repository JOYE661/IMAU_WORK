<?php
function add($a, $b)
{
    $a = $a + $b;
    return $a;
}
echo add(5, 7);		// 输出结果：12
echo '<br>';
$x = 5;
$y = 7;
echo add($x, $y);	// 输出结果：12
