public class Example15_4 {
   public static void main(String args[]) {
      Move move=new Move();
      Thread zhangsan,lisi;
      zhangsan=new Thread(move); 
      zhangsan.setName("����");
      lisi=new Thread(move);
      lisi.setName("����");
      zhangsan.start();
      lisi.start(); 
   }
}
