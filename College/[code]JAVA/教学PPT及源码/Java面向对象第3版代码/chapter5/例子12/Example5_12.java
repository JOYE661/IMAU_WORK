abstract class ������ {
   abstract void ����();
   abstract void ����();
   abstract void ɲ��();
}
class �ֶ����γ� extends ������ {
   void ����() {
      System.out.println("̤�������������һ��");
      System.out.println("Ȼ������̧�������");
   }
   void ����() {
      System.out.println("������");
   }
   void ɲ��() {
      System.out.println("̤���������̤��ɲ����");
      System.out.println("Ȼ�󽫵�λ����һ��");
   }
}
class �Զ����γ� extends ������ { 
   void ����() {
      System.out.println("ʹ��ǰ����");
      System.out.println("Ȼ���������");
   }
   void ����() {
      System.out.println("������");
   }
   void ɲ��() {
      System.out.println("̤��ɲ����");
   }
}
public class Example5_12 {
   public static void main(String args[]) {
      ������ car=new �ֶ����γ�();
      System.out.println("�ֶ����γ��Ĳ�����");
      car.����();
      car.����();
      car.ɲ��();
      car=new �Զ����γ�();
      System.out.println("�Զ����γ��γ��Ĳ�����");
      car.����();
      car.����();
      car.ɲ��();
   }
}
