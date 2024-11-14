<?php
class Person
{
    public function introduce()
    {
        echo __CLASS__;
    }
}

class Student extends Person
{
    public function introduce()
    {
        parent::introduce();
    }
}

$student = new Student();
$student->introduce();      			// 输出结果：Person
