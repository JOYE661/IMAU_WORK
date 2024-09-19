<?php
class Person
{
    public $name;
    public function __construct($name = 'XXX')
    {
        $this->name = $name;
    }
}
$object1 = new Person();
$object2 = new Person('Jim');
echo $object1->name; 			// 输出结果：XXX
echo $object2->name; 			// 输出结果：Jim
