<?php
var_dump(is_bool('1'));				// 输出结果：bool(false)
var_dump(is_string('php'));			// 输出结果：bool(true)
var_dump(is_float('23'));			// 输出结果：bool(false)
var_dump(is_int('23.0'));			// 输出结果：bool(false)
var_dump(is_numeric('45.6'));		// 输出结果：bool(true)
