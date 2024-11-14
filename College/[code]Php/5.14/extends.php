<?php
class Animal
{
    public $name;
    public function shout()
    {
        echo $this->name . '发出叫声！';
    }
}
class Cat extends Animal
{
    public function __construct($name)
    {
        $this->name = $name;
    }
}
$cat = new Cat('小猫');
$cat->shout();  			// 输出结果：小猫发出叫声！
