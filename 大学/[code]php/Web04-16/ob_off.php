<?php
// output_buffering = Off

echo '第1段文本，';
echo '第2段文本';
// 关闭输出缓冲后，设置响应头会报错
header('Content-Type: text/plain; charset=UTF-8');
