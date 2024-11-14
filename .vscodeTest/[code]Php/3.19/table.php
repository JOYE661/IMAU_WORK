<!DOCTYPE html>
<html>
<head>
  <title>表格生成器</title>
  <style>
    table { border: 2px solid #CFCFCF; width: 500px; border-collapse: collapse; }
    td, th { border: 2px solid #CFCFCF; width: 40px; height: 20px; }
    th { height: 20px; background-color: #7D8BA5; }
    .blue { background: blue; }
    .green { background: green; }
  </style>
</head>
<body>
  <?php
    $row = 8;
    $col = 20;
    echo '<table>';
    echo '<tr>';
    for ($i = 1; $i <= $col; ++$i) {
        echo '<th></th>';
    }
    echo '</tr>';
    for ($i = 1; $i <= $row; ++$i) {		  // 生成表格的行
        $color = ($i % 2 == 0) ? 'blue' : 'green';
        echo '<tr class="' . $color . '">';
        for ($j = 1; $j <= $col; ++$j) {	  // 生成表格的列
            echo '<td></td>';
        }
        echo '</tr>';
    }
    echo '</table>';
  ?>
</body>
</html>