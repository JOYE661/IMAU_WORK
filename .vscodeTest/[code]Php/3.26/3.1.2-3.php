<?php
function extra(&$str)
{
    $str .= ' and some extra';
}
$var = 'food';
extra($var);
echo $var;			// 输出结果：food and some extra
