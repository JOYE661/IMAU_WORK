public class Example9_2  {
   public static void main(String args[]) {
      int number=0; 
      String s="student;entropy;engage,english,client";
      for(int k=0;k<s.length();k++) {
           if(s.regionMatches(k,"en",0,2)) {
                number++;
           }
      } 
      System.out.println("number="+number); //输出结果为number=5
    }
}
