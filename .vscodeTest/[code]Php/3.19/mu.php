<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Document</title>
</head>
<body>
  <table border="1">
  <?php
     $line = 1; //金字塔的初始行数
     while($line <= 5){		
	      $empty_pos = $star_pos = 1; //组成金字塔空格和星星的初始
          $empty = 5 - $line;        //金字塔每行输出的最多空格数
          $star = 2*$line-1;         //组成金字塔每行的最多星星数
	      while($empty_pos <= $empty){     //输出金字塔每行的空格
				echo '&nbsp;';
				++$empty_pos;
				}				
	      while($star_pos <= $star){         //输出金字塔每行的星星
			    echo '*';
				++$star_pos;
				}
	echo '<br>';
	$line++;
	}
?>

  </table>
</body>
</html>