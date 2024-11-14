<?php
// ① 除法运算时，除数为0
echo 5 / 0;			// 错误信息“Warning: Division by zero...”
// ② 使用include包含不存在的文件
include '1234';		// 错误信息“Warning: include(): Failed opening...”
