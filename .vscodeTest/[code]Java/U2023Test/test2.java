/*
ע�⣺
�����ļ����д���Test.java���ļ����ó����ǲ������ģ�����begin��end����д����ʵ��Ҫ��Ĺ��ܡ�
����ɾ��ע���л�Ķ��������ݣ�����ʱ���ø���ԭ���ļ�����
��Ŀ��������������������������±�����
��д������ڿ����ļ����±�����ԡ�
��ĿҪ�󣺱�д����ʹ��File���PrintWriter����"Test.txt"�ļ���д���ַ���"Hello"��
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