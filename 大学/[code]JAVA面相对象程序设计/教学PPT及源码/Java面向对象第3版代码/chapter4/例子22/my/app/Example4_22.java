package my.app;
import data.one.Circle;
import data.two.Circular;
import sohu.com.TestOne;
public class Example4_22 {
   public static void main(String args[]) {
       Circle  circle=new Circle(10);           
       Circular circular=new Circular(circle,20);         
       System.out.println("Ô²×¶µÄÌå»ý:"+circular.getVolume());
       TestOne a = new TestOne();
       a.fTestOne();
   }
}

