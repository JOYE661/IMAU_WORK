public class Example3_5 {
   public static void main(String args[]) {
      long sum = 0;   //������ĺ�
      int a = 8;      //��Źؼ�������
      long item = a;  //��������
      int n = 12;     //����������
      for(int i = 1;i<=n; i++) {
          sum=sum+item;    
          item = item*10 + a;           
      }
      System.out.println(sum);
   }
}




