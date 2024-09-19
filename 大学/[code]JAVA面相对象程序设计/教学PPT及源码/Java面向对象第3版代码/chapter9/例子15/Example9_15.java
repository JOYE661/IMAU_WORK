public class Example9_15 {
   public static void main(String args[]) {
      StringBuffer str=new StringBuffer();
      str.append("大家好");
      System.out.println("str:"+str);
      System.out.println("length:"+str.length());
      System.out.println("capacity:"+str.capacity()); 
      str.append("我们大家都很愿意学习Java语言");
      System.out.println("str:"+str);
      System.out.println("length:"+str.length());
      System.out.println("capacity:"+str.capacity()); 
      StringBuffer sb=new StringBuffer("Hello");
      System.out.println("length:"+sb.length());
      System.out.println("capacity:"+sb.capacity()); 
   }
}
