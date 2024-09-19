<?php
$path = 'C:\web\apache2.4\htdocs\cat.jpg';
$pos = strrpos($path, '\\');
// 截取文件名称，输出结果：cat.jpg
echo substr($path, $pos + 1);
// 截取文件所在的路径，输出结果：C:\web\apache2.4\htdocs
echo substr($path, 0, $pos);
