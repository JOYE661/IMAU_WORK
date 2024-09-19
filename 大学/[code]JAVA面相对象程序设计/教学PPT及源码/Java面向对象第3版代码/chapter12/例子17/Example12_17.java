import java.io.*;
import java.util.*;
public class Example12_17 {
   public static void main(String args[]) {
      File file = new File("student.txt");
      Scanner sc=null;
      int count=0;
      double sum=0;
      try { int score=0;
            sc = new Scanner(file);
            while(sc.hasNext()){
               try{
                    score=sc.nextInt();
                    count++;
                    sum=sum+score;
                    System.out.println(score); 
               } 
               catch(InputMismatchException exp){
                    String t=sc.next();
               }   
            }
            double aver=sum/count;
            System.out.println("Æ½¾ù³É¼¨:"+aver);
      }
      catch(FileNotFoundException exp){
         System.out.println(exp); 
      }
       
   }
}
