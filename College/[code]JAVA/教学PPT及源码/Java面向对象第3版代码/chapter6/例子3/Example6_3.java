interface Cubic {
   double getCubic(double x);
}
class A {
   void f(Cubic cubic) {
       double result=cubic.getCubic(3); 
       System.out.println("result="+result);
   } 
}
public class Example6_3 {
   public static void main(String args[]) {
      Cubic cu=new Cubic() {   
                   public double getCubic(double x) {
                      return x*x*x;                 
                   }
               };
     double m=cu.getCubic(5);  //接口回调
     System.out.println("m="+m);
      A a=new A();
      a.f(new Cubic()  {        
              public double getCubic(double x) {
                return x*x*x;
              }
          });
   } 
}




