public class Example4_6 {
   public static void main(String args[]) {
      Computer computer=new Computer();
      double result=computer.getResult(1.0/3,10,20,30); //“参数代表”x代表了3个参数
      System.out.println("10,20,30 的平均数:"+result);
      result=computer.getResult(1.0/6,66,12,5,89,2,51,23,56,78); //“参数代表”x代表了6个参数
      System.out.println("66,12,5,89,2,51 的平均数:"+result);
   }
}
