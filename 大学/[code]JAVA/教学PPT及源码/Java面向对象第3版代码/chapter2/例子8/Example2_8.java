import java.util.Scanner;
enum Season {
   ´º¼¾,ÏÄ¼¾,Çï¼¾,¶¬¼¾   
}
public class Example2_8{
   public static void main(String args[]){
        Season x = null ;
        Scanner reader=new Scanner(System.in);
        int n = reader.nextInt();
        if(n == 1)
          x = Season.´º¼¾;
        else if(n == 2)
          x = Season.ÏÄ¼¾;
        else if(n == 3)
          x = Season.Çï¼¾;
        else if(n == 4)
          x = Season.¶¬¼¾;
        System.out.println("ÏÖÔÚÊÇ"+x);
   }
}



