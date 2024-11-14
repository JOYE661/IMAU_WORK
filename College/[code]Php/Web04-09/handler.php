<?php
// 自定义错误处理的函数
function customError($errno, $errstr)
{
   echo "<b>Error:</b> [$errno] $errstr";
}
set_error_handler('customError');		// 调用自定义错误处理函数
echo $student;							// 输出未定义的变量，触发错误
