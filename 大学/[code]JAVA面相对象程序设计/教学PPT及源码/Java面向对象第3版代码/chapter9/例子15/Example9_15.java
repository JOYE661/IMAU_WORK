public class Example9_15 {
   public static void main(String args[]) {
      StringBuffer str=new StringBuffer();
      str.append("��Һ�");
      System.out.println("str:"+str);
      System.out.println("length:"+str.length());
      System.out.println("capacity:"+str.capacity()); 
      str.append("���Ǵ�Ҷ���Ը��ѧϰJava����");
      System.out.println("str:"+str);
      System.out.println("length:"+str.length());
      System.out.println("capacity:"+str.capacity()); 
      StringBuffer sb=new StringBuffer("Hello");
      System.out.println("length:"+sb.length());
      System.out.println("capacity:"+sb.capacity()); 
   }
}
