import java.util.*;
public class Example9_12 {
   public static void main(String args[]) {
       String s="�л���:28.89Բ,��;����:128.87Բ,������:298Բ��";
       String delim = "[^0-9.]+"; //���������ж�ƥ��delim
       s = s.replaceAll(delim,"#");
       StringTokenizer fenxi=new StringTokenizer(s,"#");//��#�ַ���Ϊ�ָ���� 
       double totalMoney=0;
       while(fenxi.hasMoreTokens()) {
           double money=Double.parseDouble(fenxi.nextToken());
           System.out.println(money);
           totalMoney += money;
       }
       System.out.println("�ܷ��ã�"+totalMoney+"Բ");
    } 
}

