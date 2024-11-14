public class Car {
   Person person;    //组合驾驶员
   public void setPerson(Person p) {
      person = p;
   }
   public void show() {
      if(person == null) {
         System.out.println("目前没人驾驶汽车.");
      }
      else {
         System.out.println("目前驾驶员是:"+person.getMess());
      }
   }
}
