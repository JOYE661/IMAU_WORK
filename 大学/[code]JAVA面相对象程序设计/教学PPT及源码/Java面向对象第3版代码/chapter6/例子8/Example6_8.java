import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class Example6_8 {
   public static void main(String args[]) {
      Rect rect = new Rect();
      Class cs = rect.getClass();  //或 Class cs = Rect.class;
      System.out.println(cs == Rect.class);  //输出结果是true
      String className=cs.getName();
      Constructor[] con=cs.getDeclaredConstructors(); //返回类中的构造方法
      Field[] field=cs.getDeclaredFields() ;          //返回类中的成员变量
      Method[] method=cs.getDeclaredMethods();        //返回类中的方法
      System.out.println("类的名字:"+className);
      System.out.println("类中有如下的构造方法:");
      for(int i=0;i<con.length;i++) {
         System.out.println(con[i].toString());
      }
      System.out.println("类中有如下的成员变量:");
      for(int i=0;i<field.length;i++) {
         System.out.println(field[i].toString());
      }
      System.out.println("类中有如下的方法:");
      for(int i=0;i<method.length;i++) {
         System.out.println(method[i].toString());
      }
   }  
}
