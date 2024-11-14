/*
注意：
考生文件夹中存有Test.java的文件，该程序是不完整的，请在begin到end间填写代码实现要求的功能。
请勿删除注释行或改动已有内容，保存时不得更改原有文件名。
题目所需变量均已声明，请勿声明新变量。
编写完成请在考生文件夹下编译调试。
题目要求：设计类Test1期中包含成员方法order(),接收1个整型数组，实现该数组的升序排列，空返回值，使得可以在Test类中调用该方法。
请勿自行设计排序法。
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