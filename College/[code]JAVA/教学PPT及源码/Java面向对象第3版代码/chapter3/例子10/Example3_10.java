enum Fruit {
   ƻ��,��,�㽶,����,â��
}
public class Example3_10 {
   public static void main(String args[]) {
      double price=0;
      boolean show=false;
      for(Fruit fruit:Fruit.values()) {
          switch(fruit) {
            case ƻ��: price=1.5;
                       show=true; 
                       break;
            case â��: price=6.8;
                       show=true;
                       break;
            case �㽶: price=2.8;
                       show=true;
                       break; 
            default:   show=false; 
          }
         if(show) {
           System.out.println(fruit+"500�˵ļ۸�"+price+"Ԫ");  
         }
      }
   }
}
 

