class A {
    double f(float x,float y) {
       return x+y;
    }
    public int g(int x,int y) {
       return x+y;
    }
}
class B extends A {
    double f(float x,float y) {
       return x*y;
    }  
}
public class Example5_4 {
    public static void main(String args[]) {
      B b=new B();
      double result=b.f(5,6);        //b������д�ķ���
      System.out.println("������д�����õ��Ľ��:"+result);   
      int m=b.g(3,5);        //b���ü̳еķ���
      System.out.println("���ü̳з����õ��Ľ��:"+m);  
    } 
}  
