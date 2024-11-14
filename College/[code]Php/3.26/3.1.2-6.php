<?php
function num(...$num)
{
    foreach ($num as $v) {
        echo $v . ' ';
    }
}
num(1, 2, 3, 4, 5, 6, 7, 8, 9);		// 输出结果：1 2 3 4 5 6 7 8 9
num('a', 'b', 'c');					// 输出结果：a b c
