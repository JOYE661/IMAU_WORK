<?php
class Person
{
    protected final function show()
    {
        // show()方法不能被子类重写
    }
}

final class Student extends Person
{
    // Student类不能被继承，只能被实例化
}
