import java.io.*;
import java.util.*;
public class Example12_18 {
   public static void main(String args[]) {
      File file = new File("goods.txt");
      Scanner sc=null;
      int count=0;
      double sum=0;
      try { double price=0;
            sc = new Scanner(file);
            sc.useDelimiter("[^0123456789.]+"); 
            while(sc.hasNextDouble()){
                price=sc.nextDouble();
                count++;
                sum=sum+price;
                System.out.println(price); 
            }
            double aver=sum/count;
            System.out.println("平均价格:"+aver);
      }
      catch(FileNotFoundException exp){
         System.out.println(exp); 
      }
   }
}
