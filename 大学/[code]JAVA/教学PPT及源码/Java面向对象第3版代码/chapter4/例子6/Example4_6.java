public class Example4_6 {
   public static void main(String args[]) {
      Computer computer=new Computer();
      double result=computer.getResult(1.0/3,10,20,30); //����������x������3������
      System.out.println("10,20,30 ��ƽ����:"+result);
      result=computer.getResult(1.0/6,66,12,5,89,2,51,23,56,78); //����������x������6������
      System.out.println("66,12,5,89,2,51 ��ƽ����:"+result);
   }
}
