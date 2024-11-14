<?php
ob_start();
for ($i = 0; $i <= 5; ++$i) {
    echo $i . '.';
}
$str = ob_get_contents();
file_put_contents('./output.txt', $str);
ob_end_clean();
