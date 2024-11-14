<?php
$username = 'user';
$pattern = '/^[a-zA-Z]{4,12}$/';
if (preg_match($pattern, $username)) {
    echo '用户名格式符合要求';
}

$password = '123456';
$pattern = '/^\w{6,20}$/';
if (preg_match($pattern, $password)) {
    echo '密码格式符合要求';
}

$qq = '123456';
$pattern = '/^[1-9][0-9]{4,}$/';
if (preg_match($pattern, $qq)) {
    echo 'QQ号格式符合要求';
}

$email = 'xiaoming@mail.test';
$pattern = '/^\w+@(([a-z0-9]+\-)*[a-z0-9]+\.){1,3}[a-z]{2,}$/i';
if (preg_match($pattern, $email)) {
    echo 'email地址格式符合要求';
}

$url = 'http://www.php.test:80/about.html';
$domain = '(([a-z0-9]+\-)*[a-z0-9]+\.){1,3}[a-z]{2,}';
$pattern = '/^https?:\/\/' . $domain . '(:\d+)?(\/\S*)*$/i';
if (preg_match($pattern, $url)) {
    echo 'URL格式符合要求';
}
