/*
ע�⣺
�����ļ����д���Test.java���ļ����ó����ǲ������ģ�����begin��end����д����ʵ��Ҫ��Ĺ��ܡ�
����ɾ��ע���л�Ķ��������ݣ�����ʱ���ø���ԭ���ļ�����
��Ŀ��������������������������±�����
��д������ڿ����ļ����±�����ԡ�
��ĿҪ������Ʋ�������ַ��ķ������÷����β�Ϊchar ch1,char ch2�����ظ÷�Χ������ַ���
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


