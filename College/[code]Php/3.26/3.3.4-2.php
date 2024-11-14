<?php
$c = 100;
$sum = function($a, $b) use($c) {
    return $a + $b + $c;
};
echo $sum(100, 200);  		// 输出结果：400
