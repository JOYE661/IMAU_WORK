public class MainClass {
   public static void main(String arg[]) {
      Car car =new Car();
      int i=1;
      while(true) {
         try{
           car.show();
           Thread.sleep(2000);  //ÿ��2000���������ʻԱ
           Class<?> cs=Class.forName("Driver"+i); //�й�Class��֪ʶ���6.5
           Person p=(Person)cs.getDeclaredConstructor().newInstance();
           //���û�е�i����ʻԱ�ʹ����쳣������catch,�����˼�ʻ��ǰ��ʻԱ������ʻ:
           car.setPerson(p);      //������ʻԱ
           i++; 
         }
         catch(Exception exp){
           i++;
         }
         if(i>10) i=1;          //���10����ʻԱ�ֻ�����
      }
   }
}
