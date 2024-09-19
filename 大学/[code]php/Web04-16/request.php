<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Document</title>
</head>
<body>
<?php
    var_dump($_REQUEST);
?>
<form method="post" action="request.php?a=param1">
  <input type="text" name="b" value="param2">
  <input type="submit" value="提交">
</form>
</body>
</html>