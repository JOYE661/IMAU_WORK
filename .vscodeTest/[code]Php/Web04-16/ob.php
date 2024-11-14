<?php
// output_buffering = 4096

echo '第1段文本，';
echo '第2段文本';
// 开启输出缓冲时，可以先输出内容后设置响应头
header('Content-Type: text/plain; charset=UTF-8');
