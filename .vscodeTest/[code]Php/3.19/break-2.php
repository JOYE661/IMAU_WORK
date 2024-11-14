<?php
for ($i = 0; $i < 3; $i++) {
    echo '外层循环' . $i . '开始：';
    for ($j = 0; $j < 2; $j++) {
        if ($i == 1) {
            break 2; 			// 使用break 2直接跳出双层循环
        }
        echo '内层循环' . $i . '-' . $j . ',';
    }
    echo '外层循环' . $i . '结束<br>';
}
