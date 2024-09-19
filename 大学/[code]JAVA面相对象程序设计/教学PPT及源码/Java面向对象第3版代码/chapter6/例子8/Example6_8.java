import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class Example6_8 {
   public static void main(String args[]) {
      Rect rect = new Rect();
      Class cs = rect.getClass();  //�� Class cs = Rect.class;
      System.out.println(cs == Rect.class);  //��������true
      String className=cs.getName();
      Constructor[] con=cs.getDeclaredConstructors(); //�������еĹ��췽��
      Field[] field=cs.getDeclaredFields() ;          //�������еĳ�Ա����
      Method[] method=cs.getDeclaredMethods();        //�������еķ���
      System.out.println("�������:"+className);
      System.out.println("���������µĹ��췽��:");
      for(int i=0;i<con.length;i++) {
         System.out.println(con[i].toString());
      }
      System.out.println("���������µĳ�Ա����:");
      for(int i=0;i<field.length;i++) {
         System.out.println(field[i].toString());
      }
      System.out.println("���������µķ���:");
      for(int i=0;i<method.length;i++) {
         System.out.println(method[i].toString());
      }
   }  
}
