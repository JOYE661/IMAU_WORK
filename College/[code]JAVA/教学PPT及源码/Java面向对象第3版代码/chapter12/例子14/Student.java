import java.io.*;
public class Student implements Serializable { //ʵ��Serializable�ӿ�
   String name=null;
   double height; 
   public void setName(String name) {
      this.name=name;
   }
   public void setHeight (double height) {
     this.height=height;
   }
}
