<?php
$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, 'http://www.baidu.com');
// 设置返回信息中包含响应消息
curl_setopt($ch, CURLOPT_HEADER, 1);
// 设置执行curl_exec()函数后将响应结果返回，而不是直接输出
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
$html = curl_exec($ch);
curl_close($ch);
echo $html;
