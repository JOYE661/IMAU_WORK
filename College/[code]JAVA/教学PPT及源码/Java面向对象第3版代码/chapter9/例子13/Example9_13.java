import java.util.*;
public class Example9_13 {
   public static void main(String args[]) {
      String cost = "话费清单：市话费76.89元，长途花费167.38元，短信费12.68元。";
      Scanner scanner = new Scanner(cost);
      scanner.useDelimiter("[^0123456789.]+"); //scanner设置分隔标记
      double sum=0;
      while(scanner.hasNext()){
         try{  double price = scanner.nextDouble();
              sum = sum+price;
              System.out.println(price);
         } 
         catch(InputMismatchException exp){
              String t = scanner.next();
         }   
      }
      System.out.println("总费用:"+sum+"圆");
   }
}


