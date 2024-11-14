<?php
preg_match_all('/[^a-z]/', 'AbCd', $matches);
print_r($matches);  // 输出结果: Array ( [0] => A [1] => C )
