<?php
for ($i = 1; $i <= 5; $i++) {
    include_once './once.php';
}
echo 'include_once语句引入外部文件的次数：' . $sum;
echo '<br>';
for ($i = 1; $i <= 5; $i++) {
    include './once.php';
}
echo 'include语句引入外部文件的次数：' . $sum;
