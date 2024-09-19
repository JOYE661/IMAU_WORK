package jiafei.data;
import tom.data.Circle;
import java.lang.reflect.Constructor;
public class Example6_9 {
   public static void main(String args[]) {
      try{ 
           Class<?> cs= Class.forName("tom.data.Circle"); //也可以 Class<?> cs =Circle.class;但缺乏灵活性（见7.4）
           Constructor<?> gouzhao = cs.getDeclaredConstructor(); //返回不带参数的构造方法，封装在Constructor<?>对象中 
           Circle circle =(Circle)gouzhao.newInstance(); 
           circle.setRadius(100);
           System.out.println("circle的面积"+circle.getArea());
       }
       catch(Exception e) {
           System.out.println(e.getMessage());
       } 
   }  
}
