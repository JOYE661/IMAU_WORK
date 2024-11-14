interface Cubic {
   double getCubic(double x);
}
class A {
   void f(Cubic cubic) {
       double result=cubic.getCubic(3); 
       System.out.println("result="+result);
   } 
}
public class Example6_4 {
   public static void main(String args[]) {
      Cubic cu=new Cubic() {         //和接口有关的匿名类
                   public double getCubic(double x) {
                      return x*x*x;                 
                   }
               };
     System.out.println(cu.getCubic(5));  
     cu= (double x)->{               //使用Lambada表达式简化代码
                       return x*x*x;                 
                     };
     System.out.println(cu.getCubic(2)); 
     A a=new A();
     a.f((double x)-> {               //使用Lambada表达式简化代码
                        return x*x*x;                 
                      });
   } 
}




