<?php
function say($p, $con = 'say "Hello"')
{
    return "$p $con";
}
echo say('Tom');		// 输出结果：Tom say "Hello"
