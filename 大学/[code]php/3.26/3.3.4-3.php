<?php
function calculate($a, $b, $func)
{
    return $func($a, $b);
}
echo calculate(100, 200, function($a, $b) { 	// 输出结果：300
    return $a + $b;
});
echo calculate(100, 200, function($a, $b) { 	// 输出结果：20000
    return $a * $b;
});
