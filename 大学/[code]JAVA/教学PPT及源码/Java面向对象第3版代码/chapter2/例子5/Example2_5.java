import java.util.Arrays;
public class Example2_5 {
    public static void main(String args[]) {
      char [] a = {'a','b','c', 'd','e','f'},
              b = {'1','2','3','4','5','6'};
      int [] c ={1,2,3,4,5,6},
             d = {10,20,30,40,50,60};
      System.arraycopy(a, 0, b, 0, a.length);
      System.arraycopy(c, 2, d, 2, c.length-3); 
      System.out.println("���� a �ĸ���Ԫ���е�ֵ:");
      System.out.println(Arrays.toString(a));
      System.out.println("���� b �ĸ���Ԫ���е�ֵ:");
      System.out.println(Arrays.toString(b));
      System.out.println("���� c �ĸ���Ԫ���е�ֵ:");
      System.out.println(Arrays.toString(c));
      System.out.println("���� d �ĸ���Ԫ���е�ֵ:");
      System.out.println(Arrays.toString(d));
    }
}
