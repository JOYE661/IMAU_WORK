public class Example15_2 {
   public  static void main(String args[]) {
      People personOne,personTwo;
      StringBuffer str=new StringBuffer();
      personOne=new People("张三",str); 
      personTwo =new People("李四",str); 
      personOne.start();  
      personTwo.start();
   }
}

