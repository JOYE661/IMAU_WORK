import java.util.Scanner;
public class Example6_10 {
  public static void main (String args[ ]) {
       System.out.println("�����������س�ȷ��");
       Scanner scan=new Scanner(System.in);
       double number=scan.nextDouble();
       assert number>0:"�������ܼ���ƽ����";
       System.out.println(number+"��ƽ������"+Math.sqrt(number));    
   }
}
