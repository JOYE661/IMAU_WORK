import java.util.Scanner;
enum Season {
   ����,�ļ�,�＾,����   
}
public class Example2_8{
   public static void main(String args[]){
        Season x = null ;
        Scanner reader=new Scanner(System.in);
        int n = reader.nextInt();
        if(n == 1)
          x = Season.����;
        else if(n == 2)
          x = Season.�ļ�;
        else if(n == 3)
          x = Season.�＾;
        else if(n == 4)
          x = Season.����;
        System.out.println("������"+x);
   }
}



