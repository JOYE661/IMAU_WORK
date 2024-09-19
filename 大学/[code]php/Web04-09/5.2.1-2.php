<?php
$visitor = 'man';
// ① 仅退出脚本
if (!isset($visitor)) {
    exit;
}
// ② 输出信息并退出脚本
if ($visitor !== 'woman') {
    exit('仅限女士');
}
// ③ 与逻辑运算符配合使用
$result = is_string($visitor) or exit('变量$visitor不合法！');
