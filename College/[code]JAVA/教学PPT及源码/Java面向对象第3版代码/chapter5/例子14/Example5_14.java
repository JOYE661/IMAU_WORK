public class Example5_14 {
   public static void main(String args[]) {
      AAA a = new AAA();
      System.out.println("�ӿ��еĳ���"+AAA.MAX);
      System.out.println("����on����(��д��):");
      a.on();
      System.out.println("����sum����(��д��):"+a.sum(12,18));
      System.out.println("���ýӿ��ṩ��default����"+a.max(12,78));
      Printable.f();  
   }
}   

