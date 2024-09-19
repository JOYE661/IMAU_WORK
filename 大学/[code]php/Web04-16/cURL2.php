<?php
// 准备发送的数据
$data = [
    'name' => 'test',
    'password' => '123456'
];
$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, 'http://localhost/example2.php');
// curl_setopt($ch, CURLOPT_URL, 'http://localhost/chapter06/example2.php');
// 设定请求方式为POST
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
curl_exec($ch);
curl_close($ch);
