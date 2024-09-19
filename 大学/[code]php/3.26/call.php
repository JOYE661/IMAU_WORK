<?php
function sum($a, $b)
{
    return $a + $b;
}
echo call_user_func('sum', 4, 5);
echo '<br>';
echo call_user_func_array('sum', [10, 20]);
