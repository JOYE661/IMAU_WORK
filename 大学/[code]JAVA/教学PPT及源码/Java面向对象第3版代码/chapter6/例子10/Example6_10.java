import java.util.Scanner;
public class Example6_10 {
  public static void main (String args[ ]) {
       System.out.println("请输入正数回车确认");
       Scanner scan=new Scanner(System.in);
       double number=scan.nextDouble();
       assert number>0:"负数不能计算平方根";
       System.out.println(number+"的平方根："+Math.sqrt(number));    
   }
}
