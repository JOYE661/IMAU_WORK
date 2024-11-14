/*
注意：
考生文件夹中存有Test.java的文件，该程序是不完整的，请在begin到end间填写代码实现要求的功能。
请勿删除注释行或改动已有内容，保存时不得更改原有文件名。
题目所需变量均已声明，请勿声明新变量。
编写完成请在考生文件夹下编译调试。
题目要求：编写程序，使用File类和PrintWriter类向"Test.txt"文件中写入字符串"Hello"。
*/
package U2023Test;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class test2 {
	public static  void main(String[] args) throws IOException{
		/****************begin***************/
		PrintWriter writer=new PrintWriter(new File("Test.txt"));
		writer.write("Hello");
		writer.close();
		/****************end***************/
	}
}