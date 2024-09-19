<?php
class Student
{
    public function __destruct()
    {
        echo '正在执行析构方法……';
    }
}
$student = new Student();
unset($student);  				// 输出结果：正在执行析构方法……

function test()
{
    $student1 = new Student();
}
test();  						// 执行后输出结果：正在执行析构方法……
