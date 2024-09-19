<?php
function divide($num1, $num2)
{
    if ($num2 == 0) {
        trigger_error('除数不能为0');
        return false;
    }
    return $num1 / $num2;
}
echo divide(100, 0);
