public class Example15_2 {
   public  static void main(String args[]) {
      People personOne,personTwo;
      StringBuffer str=new StringBuffer();
      personOne=new People("����",str); 
      personTwo =new People("����",str); 
      personOne.start();  
      personTwo.start();
   }
}

