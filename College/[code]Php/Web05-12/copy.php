<?php
class Test
{
    public $flag = 1;
}
$object1 = new Test();
$object2 = $object1;			// 对象浅复制
$object1->flag = 5;
var_dump($object1->flag);  		// 输出结果：int(5)
var_dump($object2->flag);  		// 输出结果：int(5)
