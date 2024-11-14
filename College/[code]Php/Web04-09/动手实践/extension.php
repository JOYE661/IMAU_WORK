<?php
if (function_exists('mb_strlen')) {
    echo 'mbstring扩展已经开启';
} else {
    echo 'mbstring扩展没有开启';
}

if (extension_loaded('mbstring')) {
    echo 'mbstring扩展已经开启';
} else {
    echo 'mbstring扩展没有开启';
}
