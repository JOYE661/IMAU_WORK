<?php
var_dump(0 == false);			// bool(true)
var_dump(0.0 == false);			// bool(true)
var_dump('' == false);			// bool(true)
var_dump('0' == false);			// bool(true)

var_dump(true + 1);				// int(2)
var_dump(false + 1);			// int(1)

var_dump('1PHP' + 1);			// int(2)
var_dump('PHP1' + 1);			// int(1)

echo 'true被转换成字符串：' . true;			// true被转换成字符串：1
echo 'false被转换成字符串：' . false;		// false被转换成空字符串

var_dump(1 . 'PHP');			// string(4) "1PHP"
var_dump(3.14 . 'PHP');			// string(7) "3.14PHP"
