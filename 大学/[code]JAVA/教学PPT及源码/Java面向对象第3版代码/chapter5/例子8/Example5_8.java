class A {
//final double PI;  �Ƿ�����Ϊû�и�����ָ��ֵ
  final double PI=3.1415926;// PI�ǳ���
  public double getArea(final double r) {
     // r=89; �Ƿ�����Ϊ�������ٸı�r��ֵ
     return PI*r*r;
  }
  public final void speak() {
     System.out.println("���ã�How's everything here ?");
  } 
}
class B extends A {
/* �Ƿ���������дspeak����
  public void speak() {
      System.out.println("���");
  } 
  */
}
public class Example5_8 {
  public static void main(String args[]) {
      B b=new B();
      System.out.println("�����"+b.getArea(100));
      b.speak();       //���ü̳еķ���
   }
}
