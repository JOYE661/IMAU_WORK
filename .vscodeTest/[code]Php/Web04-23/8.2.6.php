<?php
preg_match('/a(b)/', 'abcd', $matches);
print_r($matches); 	// 输出结果：Array ( [0] => ab [1] => b )
echo '<br>';

preg_match_all('/a(b)/', 'abcd', $matches);
// 输出结果：Array ( [0] => Array ( [0] => ab ) [1] => Array ( [0] => b ) )
print_r($matches);
echo '<br>';

preg_match('/a(?:b)/', 'abcd', $matches);
print_r($matches); 	// 输出结果：Array ( [0] => ab )
echo '<br>';

preg_match('/a(b)(c)\1\2/', 'abcbc', $matches);
print_r($matches); 	// 输出结果：Array ( [0] => abcbc [1] => b [2] => c )
echo '<br>';

// 先行断言匹配成功
preg_match('/Countr(?=y)/', 'Country', $matches);
print_r($matches); 	// 输出结果：Array ( [0] => Countr )
echo '<br>';

// 先行断言匹配失败
preg_match('/Countr(?=y)/', 'Countries', $matches);
print_r($matches);	// 输出结果：Array ( )
