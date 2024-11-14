<?php
function telVerify($tel)
{
    return (bool) preg_match('/^1[34578]\d{9}$/', $tel);
}
var_dump(telVerify('400-618-4000'));    // 输出结果：bool(false)
var_dump(telVerify('17799881234'));     // 输出结果：bool(true)
var_dump(telVerify('12088384157'));     // 输出结果：bool(false)
