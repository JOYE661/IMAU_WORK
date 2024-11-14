<?php
define('NUM', 1);
echo NUM;			// 输出：1
define('NUM', 2);	// 未生效并报错：Notice: Constant NUM already defined...
echo NUM;			// 输出：1
