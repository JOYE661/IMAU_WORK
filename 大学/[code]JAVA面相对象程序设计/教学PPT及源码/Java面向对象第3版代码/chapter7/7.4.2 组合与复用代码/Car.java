public class Car {
   Person person;    //��ϼ�ʻԱ
   public void setPerson(Person p) {
      person = p;
   }
   public void show() {
      if(person == null) {
         System.out.println("Ŀǰû�˼�ʻ����.");
      }
      else {
         System.out.println("Ŀǰ��ʻԱ��:"+person.getMess());
      }
   }
}
