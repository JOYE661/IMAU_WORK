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
      Cubic cu=new Cubic() {         //�ͽӿ��йص�������
                   public double getCubic(double x) {
                      return x*x*x;                 
                   }
               };
     System.out.println(cu.getCubic(5));  
     cu= (double x)->{               //ʹ��Lambada���ʽ�򻯴���
                       return x*x*x;                 
                     };
     System.out.println(cu.getCubic(2)); 
     A a=new A();
     a.f((double x)-> {               //ʹ��Lambada���ʽ�򻯴���
                        return x*x*x;                 
                      });
   } 
}




