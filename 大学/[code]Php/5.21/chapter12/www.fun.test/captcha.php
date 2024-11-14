<?php
require './common/init.php';
require './common/library/Captcha.php';
// 生成验证码
$code = Captcha::create();
// 将验证码保存到Session中
captcha_save($code);
// 输出验证码
Captcha::show($code);