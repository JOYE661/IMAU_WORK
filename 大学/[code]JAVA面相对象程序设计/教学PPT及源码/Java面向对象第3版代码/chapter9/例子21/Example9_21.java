import java.math.*;
public class Example9_21 {
   public static void main(String args[]) {
      double a=5.0;
      double st=Math.sqrt(a);
      System.out.println(a+"��ƽ����:"+st);
      String number="20";   
      BigInteger sum=new BigInteger("0"),
                 ONE=new BigInteger("1"),
                 i=ONE,
                 item=ONE,
                 m=new BigInteger(number);
       while(i.compareTo(m)<=0) {
           sum=sum.add(item);
           i=i.add(ONE);
           item=item.multiply(i);
       }
       System.out.println("1+2!+��ǰ"+number+"��֮��:"+sum);    
   }
}
