<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Document</title>
</head>
<body>
<?php
    var_dump($_POST);
?>
<form method="POST">
  用户名：<input type="text" name="username">
  密码：<input type="password" name="password">
  <input type="submit" value="登录">
</form>
</body>
</html>