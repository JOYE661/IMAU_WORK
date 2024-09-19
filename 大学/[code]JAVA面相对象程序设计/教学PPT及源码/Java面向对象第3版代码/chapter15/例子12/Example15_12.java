public class Example15_12 {
   public static void main(String args[]) {
      Number number=new Number();
      number.giveNumberThread.start();
      number.guessNumberThread.start();

   }
}
