package U2023Test;

/*
注意：
考生文件夹中存有Test.java的文件，该程序是不完整的，请在begin到end间填写代码实现要求的功能。
请勿删除注释行或改动已有内容，保存时不得更改原有文件名。
题目所需变量均已声明，请勿声明新变量。
编写完成请在考生文件夹下编译调试。
题目要求：定义课程类，包括成员变量课程名String name、选课名单 String[] students，
选课人数int numOfStudents；设计成员方法实现用课程名构造课程对象，
在选课名单中添加学生，删 除学生和打印选课名单，使得测试类Test中的代码可以正常运行。
*/

public class test1{
	public static void main(String[] args){
		Course c=new Course("Java");
		c.addStudent("zhangsan");
		c.addStudent("lisi");
		c.addStudent("wang");
		c.dropStudent("lisi");
		c.print();
	}	
}

	/****************begin***************/
class Course{
	private String name;
	private String[] students=new String[10];
	private int numOfStudents;
	public Course(String name){this.name=name;}
	public void addStudent(String s){students[numOfStudents]=s;numOfStudents++;}
	public void dropStudent(String s){
		int i=0;
		while(i<numOfStudents){
			if(s.equals(students[i])){break;}
			i++;
		}
		while(i<numOfStudents){
			students[i]=students[i+1];
			i++;
		}
		numOfStudents--;
	}
	public void print(){
		for(int i=0;i<numOfStudents;i++){
			System.out.println(students[i]);
		}
	}
}	



	/****************end***************/

