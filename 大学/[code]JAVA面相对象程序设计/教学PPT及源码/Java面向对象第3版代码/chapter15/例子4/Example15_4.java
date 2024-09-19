public class Example15_4 {
   public static void main(String args[]) {
      Move move=new Move();
      Thread zhangsan,lisi;
      zhangsan=new Thread(move); 
      zhangsan.setName("张三");
      lisi=new Thread(move);
      lisi.setName("李四");
      zhangsan.start();
      lisi.start(); 
   }
}
