import java.util.*;
public class Example2_6 {
   public static void main(String args[]){
      int [] a ={10,20,30,40,50,60},b,c,d;
      b=Arrays.copyOf(a,10);
      System.out.println("���� a �ĸ���Ԫ���е�ֵ:");
      System.out.println(Arrays.toString(a));
      System.out.println("���� b �ĸ���Ԫ���е�ֵ:");
      System.out.println(Arrays.toString(b));
      c=Arrays.copyOfRange(a,3,5);
      System.out.println("���� c �ĸ���Ԫ���е�ֵ:");
      System.out.println(Arrays.toString(c));
      d=Arrays.copyOfRange(a,3,9);
      System.out.println("���� d �ĸ���Ԫ���е�ֵ:");
      System.out.println(Arrays.toString(d));
   }
}

