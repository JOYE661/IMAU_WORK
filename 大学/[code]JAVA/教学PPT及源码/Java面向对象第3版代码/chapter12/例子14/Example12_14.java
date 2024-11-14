import java.io.*;
public class Example12_14 {
   public static void main(String args[]) {
      Student zhang=new Student();
      zhang.setName("����");
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
          li.setName("����");
          objectIn.close();
          li.setHeight(1.88); 
          System.out.println(zhang.name+" ����ǣ�"+zhang.height);
          System.out.println(li.name+" ����ǣ�"+li.height);
       }
       catch(ClassNotFoundException event) {
          System.out.println("���ܶ�������");
       }
       catch(IOException event) {
          System.out.println(event);
       }
   }
}
