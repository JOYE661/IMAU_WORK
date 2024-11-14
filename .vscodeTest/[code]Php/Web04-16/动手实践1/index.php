<?php
session_start();
if (isset($_SESSION['user'])) {
    echo '当前登录用户：' . $_SESSION['user'] . '。';  // 用户已登录，显示登录信息
    echo '<a href="logout.php">退出<a>';
} else {
    header('Location: login.html');				      // 用户未登录，显示登录页面
    exit;
}
