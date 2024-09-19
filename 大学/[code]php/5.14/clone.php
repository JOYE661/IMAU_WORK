<?php
class Test
{
    public $flag = 1;
    public function __clone()
    {
        $this->flag = 100;  		// 克隆对象时，重新为属性赋值
    }
}
$object1 = new Test();
$object2 = clone $object1;
var_dump($object1->flag);  		    // 输出结果：int(1)
var_dump($object2->flag);  		    // 输出结果：int(100)
