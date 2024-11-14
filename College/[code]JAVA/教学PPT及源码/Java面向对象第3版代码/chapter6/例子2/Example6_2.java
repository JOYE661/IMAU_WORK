abstract class Speak {
   public abstract void speakHello();
}
class Student {
   void f(Speak sp) {
     sp.speakHello();   
   } 
}
public class Example6_2 {
   public static void main(String args[]) {
      Speak speak=new Speak() {  
                      public void  speakHello() { 
                         System.out.println("大家好，祝工作顺利！");
                      }
                  };
       speak.speakHello(); 
       Student st=new Student();
       st.f(new Speak() {         
                 public void  speakHello() { 
                    System.out.println("I am a student,how are you");
                 }
            });
   } 
}



