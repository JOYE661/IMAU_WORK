<?php
preg_match('/ab|cd/', 'abcd', $matches);
print_r($matches);	// 输出结果：Array ( [0] => Array ( [0] => ab ) )
echo '<br>';

preg_match_all('/ab|cd/', 'abcd', $matches);
print_r($matches);	// 输出结果：Array ( [0] => Array ( [0] => ab [1] => cd ) )
