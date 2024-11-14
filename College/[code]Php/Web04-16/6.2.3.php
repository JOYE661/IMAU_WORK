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
<form method="post">
  <input type="checkbox" name="hobby[]" value="basketball">篮球
  <input type="checkbox" name="hobby[]" value="football">足球
  <input type="checkbox" name="hobby[]" value="vollyball">排球
  <input type="submit" value="提交">
</form>
</body>
</html>