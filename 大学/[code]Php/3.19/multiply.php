<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Document</title>
</head>
<body>
  <table border="1">
    <?php
        // 使用for语句得到乘数
        for ($i = 1; $i < 10; $i++) {
            // 以表格形式输出算式
            echo '<tr>';
            // 嵌套循环语句得到被乘数
            for ($j = 1; $j <= $i; $j++) {
                // 计算并输出每个算式
                echo '<td>' . $j . '×' . $i . '=' . $j * $i . '</td>';
            }
            echo '</tr>';
        }
    ?>
  </table>
</body>
</html>