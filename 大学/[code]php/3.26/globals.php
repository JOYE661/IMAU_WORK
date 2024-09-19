<?php
function test()
{
    // 方式1：使用global关键字取得全局变量
    global $var;
    echo '全局变量$var：' . $var.'<br>';
    // 方式2：使用$GLOBALS['变量名']访问
    echo '全局变量$str：' . $GLOBALS['str'];
}
$var = 100;			// 定义变量$var
$str = 'php';		// 定义变量$str
test();
