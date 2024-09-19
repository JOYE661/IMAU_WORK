<?php
function num()
{
    static $i = 1;
    echo $i;
    ++$i;
}
num();
num();
num();