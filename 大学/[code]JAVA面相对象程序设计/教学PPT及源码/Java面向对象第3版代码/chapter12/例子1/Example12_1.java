import java.io.*;
public class Example12_1 {
   public static void main(String args[]) {
      File f1=new  File("C:\\chapter12","Example12_1.java");
      File f2=new File("c:\\chapter11");
      System.out.println(f1.getName()+"是可读的吗:"+f1.canRead());
      System.out.println(f1.getName()+"的长度:"+f1.length());
      System.out.println(f1.getName()+"的绝对路径:"+f1.getAbsolutePath());
      System.out.println(f2.getName()+"是目录吗？"+f2.isDirectory());
   }
}
