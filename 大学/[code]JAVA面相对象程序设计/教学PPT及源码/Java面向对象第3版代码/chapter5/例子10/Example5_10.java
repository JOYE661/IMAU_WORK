class  ���� {
   void cry() {
     
   }
}
class �� extends ���� {
   void cry() {
      System.out.println("���ǹ��Ľ���������...����"); 
   }  
}
class è extends ���� {
   void cry() {
      System.out.println("����è�Ľ���������...����..."); 
   }  
}
public class Example5_10 {
   public static void main(String args[]) { 
      ���� animal=new ��();   //animal�ǹ�����ת�Ͷ���
      animal.cry(); 
      animal=new è();        //animal�ǹ�����ת�Ͷ���
      animal.cry();
   }
}
