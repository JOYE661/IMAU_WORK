public class Example3_5 {
   public static void main(String args[]) {
      long sum = 0;   //存放最后的和
      int a = 8;      //存放关键的数字
      long item = a;  //存放求和项
      int n = 12;     //存放求和项数
      for(int i = 1;i<=n; i++) {
          sum=sum+item;    
          item = item*10 + a;           
      }
      System.out.println(sum);
   }
}




