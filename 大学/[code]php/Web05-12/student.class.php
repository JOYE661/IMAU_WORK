<?php
//定义student类
class student{
	//声明成员属性$name,用来保存学生的姓名
	public $name;
	//声明成员属性$student_id，用来保存学生的年龄
	public $student_id;
	//声明成员属性$age,用来保存学生的年龄
	public $age;

	//声明成员方法introduce()，调用该方法让学生进行自我介绍
	public function introduce(){
		echo "大家好，我是{$this->name},今年{$this->age}岁。<br/>我的学号是{$this->student_id},很高兴认识大家。";
	}
}

$student = new student;

//为对象属性 name 赋值
$student->name = '小明';

//为对象属性 student_id 赋值
$student->student_id = '201502110178';

//为对象属性 age 赋值
$student->age = 18;

$student->introduce();

//实例化 student 对象并赋值给$student2，为属性赋值
$student2 = new student;
$student2->name = '小红';
$student2->student_id = '201802110153';
$student2->age = 17;
echo "<br/>";
$student2->introduce();
