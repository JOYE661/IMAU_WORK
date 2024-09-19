<?php
function sum($sub1, $sub2) 
{
    return $sub1 + $sub2;
}
function avg($sub1, $sub2) 
{
    $sum = sum($sub1, $sub2);
    return $sum / 2;
}
echo avg(78.9, 56);	
echo '<br>';
echo avg(92, 90);
