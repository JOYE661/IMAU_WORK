public class Example9_1 {
     public static void main(String args[]) {
         String s1,s2;
         s1=new String("we are students");
         s2=new String("we are students");
         System.out.println(s1.equals(s2));  //�������ǣ�true
         System.out.println(s1==s2);         //�������ǣ�false
         String s3,s4; 
         s3="how are you";
         s4="how are you"; 
         System.out.println(s3.equals(s4));  //�������ǣ�true
         System.out.println(s3==s4);         //�������ǣ�true     
    }
}
