class A {
  int x,y,z;
   static int getContinueSum(int start,int end) {
      int sum=0;
      for(int i=start;i<=end;i++) {
        sum=sum+i;
      }
      return sum;
   }
}
public class Example4_9 {
  public static void main(String args[]) {
      int result=A.getContinueSum(0,100);
      System.out.println(result);
   }
}
