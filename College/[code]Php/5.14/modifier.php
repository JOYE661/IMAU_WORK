<?php
class User
{
    public $name = '张三';               	// 姓名
    protected $phone = '400-123456';	    // 电话
    private $money = '5000';            	// 存款
}
$user = new User();
echo $user->name;                        	// 输出结果：张三
echo $user->phone;					    	// $phone是受保护属性，在类外不能访问，程序报错
echo $user->money; 					    	// $money是私有属性，在类外不能访问，程序报错
