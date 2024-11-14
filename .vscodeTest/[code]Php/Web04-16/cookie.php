<?php
setcookie('name', 'value');		    // 设置一个名称为name,值为value的Cookie

// ① 获取指定的Cookie
echo $_COOKIE['name'];
// ② 获取所有的Cookie
var_dump($_COOKIE);

setcookie('name', '', time() - 1);  // 立即过期（相当于删除Cookie）

setcookie('name', 'value', time() + 1800);          // 30分钟后过期
setcookie('name', 'value', time() + 60 * 60 *24);   // 一天后过期

setcookie('history[one]', 1);
setcookie('history[two]', 2);
// 输出结果：array{["history"]=>array{["one"]=>1["two"]=>2}}
var_dump($_COOKIE);
