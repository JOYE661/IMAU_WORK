public class Student {
   String name;
   public Student() {
   } 
   public Student(String s) {
      name=s;
   }
   public String toString() {
      String oldStr=super.toString(); 
      return oldStr+"\nI am a student,my name is "+name;
   }
}
