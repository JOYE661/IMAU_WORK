<?php
// 初始化cURL会话
$ch = curl_init();
// 设置请求服务器的地址
curl_setopt($ch, CURLOPT_URL, 'http://localhost/example.php');
// curl_setopt($ch, CURLOPT_URL, 'http://localhost/chapter06/example.php');
// 自定义请求头Referer
curl_setopt($ch, CURLOPT_REFERER, 'http://www.baidu.com/');
// 执行cURL会话
curl_exec($ch);
// 关闭cURL会话
curl_close($ch);
