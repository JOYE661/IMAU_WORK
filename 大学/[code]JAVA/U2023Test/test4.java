/*
注意：
考生文件夹中存有Test.java的文件，该程序是不完整的，请在begin到end间填写代码实现要求的功能。
请勿删除注释行或改动已有内容，保存时不得更改原有文件名。
题目所需变量均已声明，请勿声明新变量。
编写完成请在考生文件夹下编译调试。
题目要求：请设计产生随机字符的方法，该方法形参为char ch1,char ch2，返回该范围内随机字符。
*/
package U2023Test;
import java.util.Scanner;
public class test4{
   public static void main(String[] args){
	System.out.println(getRandomChar('b','y'));		
   }
/****************begin***************/
	static char getRandomChar(char ch1,char ch2){
		int a=ch2-ch1+1;
		char re=(char)(ch1+(int)(Math.random()*a));
		return re;
	}




/****************end***************/
}


