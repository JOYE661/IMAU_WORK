/*
ע�⣺
�����ļ����д���Test.java���ļ����ó����ǲ������ģ�����begin��end����д����ʵ��Ҫ��Ĺ��ܡ�
����ɾ��ע���л�Ķ��������ݣ�����ʱ���ø���ԭ���ļ�����
��Ŀ��������������������������±�����
��д������ڿ����ļ����±�����ԡ�
��ĿҪ�󣺱�д����ʹ��File���Scanner���"Test.txt"�ļ��ж�ȡ��һ�����ݲ������
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
