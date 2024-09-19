public class Example15_6 {
   public static void main(String args[]) {
      Target target = new Target();
      Thread thread = new Thread(target); 
      thread.start();
      thread = new Thread(target);
      thread.start();
   }
}
