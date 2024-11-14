import java.io.*;
public class Example12_14 {
   public static void main(String args[]) {
      Student zhang=new Student();
      zhang.setName("张三");
      zhang.setHeight(1.77); 
      File file=new File("people.txt");
      try{ 
          FileOutputStream fileOut=new FileOutputStream(file);
          ObjectOutputStream objectOut=new ObjectOutputStream(fileOut);
          objectOut.writeObject(zhang); 
          objectOut.close(); 
          FileInputStream fileIn=new FileInputStream(file);
          ObjectInputStream objectIn=new ObjectInputStream(fileIn);
          Student li=(Student)objectIn.readObject(); 
          li.setName("李四");
          objectIn.close();
          li.setHeight(1.88); 
          System.out.println(zhang.name+" 身高是："+zhang.height);
          System.out.println(li.name+" 身高是："+li.height);
       }
       catch(ClassNotFoundException event) {
          System.out.println("不能读出对象");
       }
       catch(IOException event) {
          System.out.println(event);
       }
   }
}
