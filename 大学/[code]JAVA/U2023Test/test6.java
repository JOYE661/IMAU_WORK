/*
ע�⣺
�����ļ����д���Test.java���ļ����ó����ǲ������ģ�����begin��end����д����ʵ��Ҫ��Ĺ��ܡ�
����ɾ��ע���л�Ķ��������ݣ�����ʱ���ø���ԭ���ļ�����
��Ŀ��������������������������±�����
��д������ڿ����ļ����±�����ԡ�
��ĿҪ�������Test1���а�����Ա����order(),����1���������飬ʵ�ָ�������������У��շ���ֵ��ʹ�ÿ�����Test���е��ø÷�����
��������������򷨡�
*/
package U2023Test;
import java.util.Arrays;
public class test6{
	
   public static void main(String[] args){
       int[] a={9,5,1,4,7};
       test0.order(a);
       for(int i=0;i<a.length;i++)
	  System.out.println(a[i]);
   }
}
/****************begin***************/
class test0{
	public static void order(int[] a){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length-1;j++){
				if(a[j]>a[j+1]){
					int b=a[j];
					a[j]=a[j+1];
					a[j+1]=b;
				}
			}
		}
	}
}





/****************end***************/	