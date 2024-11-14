<?php
class Student
{
    public static $msg;
    public static function show()
    {
        echo self::$msg;				// 类内访问静态属性
    }
    public static function test()
    {
        self::show();				    // 类内调用静态方法
    }
}
Student::$msg = '信息';    			    // 类外访问静态属性
Student::test();                    	// 类外调用静态方法
