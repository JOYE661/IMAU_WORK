<?php
declare(strict_types = 1);
function returnIntValue(int $value): int
{
    return $value + 1.0;
}
echo returnIntValue(5);
