import java.util.*;
public class Example9_12 {
   public static void main(String args[]) {
       String s="市话费:28.89圆,长途话费:128.87圆,上网费:298圆。";
       String delim = "[^0-9.]+"; //非数字序列都匹配delim
       s = s.replaceAll(delim,"#");
       StringTokenizer fenxi=new StringTokenizer(s,"#");//用#字符作为分隔标记 
       double totalMoney=0;
       while(fenxi.hasMoreTokens()) {
           double money=Double.parseDouble(fenxi.nextToken());
           System.out.println(money);
           totalMoney += money;
       }
       System.out.println("总费用："+totalMoney+"圆");
    } 
}

