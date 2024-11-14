public class Example15_5 {
   public static void main(String args[]) {
      ComputerSum computer=new ComputerSum();
      Thread threadOne;
      threadOne=new Thread(computer); 
      threadOne.setName("уехЩ");
      threadOne.start();
   }
}
