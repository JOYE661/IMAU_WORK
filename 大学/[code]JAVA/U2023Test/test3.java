/*
注意：
考生文件夹中存有Test.java的文件，该程序是不完整的，请在begin到end间填写代码实现要求的功能。
请勿删除注释行或改动已有内容，保存时不得更改原有文件名。
题目所需变量均已声明，请勿声明新变量。
编写完成请在考生文件夹下编译调试。
题目要求：编写程序，使用File类和Scanner类从"Test.txt"文件中读取第一行数据并输出。
*/
package U2023Test;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;
public class test3{
 	public static  void main(String[] args) throws IOException{
		/****************begin***************/
		Scanner input=new Scanner(new File("Test.txt"));
		System.out.println(input.nextLine());
		input.close();


		/****************end***************/
	}
}
