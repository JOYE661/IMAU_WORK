package jiafei.data;
import tom.data.Circle;
import java.lang.reflect.Constructor;
public class Example6_9 {
   public static void main(String args[]) {
      try{ 
           Class<?> cs= Class.forName("tom.data.Circle"); //Ҳ���� Class<?> cs =Circle.class;��ȱ������ԣ���7.4��
           Constructor<?> gouzhao = cs.getDeclaredConstructor(); //���ز��������Ĺ��췽������װ��Constructor<?>������ 
           Circle circle =(Circle)gouzhao.newInstance(); 
           circle.setRadius(100);
           System.out.println("circle�����"+circle.getArea());
       }
       catch(Exception e) {
           System.out.println(e.getMessage());
       } 
   }  
}
