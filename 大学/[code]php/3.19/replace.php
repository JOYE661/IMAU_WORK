<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Document</title>
</head>
<body>
  <ul>
    <?php for ($i = 1; $i <= 10; ++$i): ?>
        <?php if ($i % 2 == 0): ?>
            <li><?php echo $i; ?></li>
        <?php endif; ?>
    <?php endfor; ?>
  </ul>
</body>
</html>