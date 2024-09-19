<?php
preg_match_all('/\d/', 'ab12', $matches);
print_r($matches);  // 输出结果: Array ( [0] => 1 [1] => 2 )
echo '<br>';

preg_match('/\\^/', '123^456', $matches);
print_r($matches);			// 输出结果：Array ( [0] => ^ )
echo '<br>';

preg_match('/\\*/', '123*456', $matches);
print_r($matches);			// 输出结果：Array ( [0] => * )
echo '<br>';

preg_match('/\\\\/', '123\\456', $matches);
print_r($matches);			// 输出结果：Array ( [0] => \ )
