import java.text.DecimalFormat;
import java.text.Number;
public class Example9_5 {
  public static void main(String args[]) {
      double aver=0,sum=0,item=0;
      boolean computable=true; 
      for(String s:args) {
         try{ item=Double.parseDouble(s);
              sum=sum+item;
         }
         catch(NumberFormatException e) {
              System.out.println("�������˷������ַ�:"+e);
              computable=false;
         }
      }
      if(computable) {
          aver=sum/args.length;
      }
      for(String s:args) {
         System.out.print(s+" ");
      } 
      System.out.println("��ƽ����:"+aver);
      int number=8642;
      String binaryString=Long.toBinaryString(number);
      System.out.println(number+"�Ķ����Ʊ�ʾ:"+binaryString);
      System.out.println(number+"��ʮ�����Ʊ�ʾ:"+Long.toString(number,16));
      String currency = "9,019,578.8768��";
      String str = "###,###��";
      DecimalFormat df = new DecimalFormat(str);
      try {
           Number num = df.parse(currency);
           double d=num.doubleValue();
           System.out.printf("%s%f\n",currency+"ת����double:\n",d);
      }
      catch(Exception exp){}
      double pi = 3.1415926;
      String numberStr = ""+pi;
      int index = numberStr.indexOf(".");
      String zs = numberStr.substring(0,index);
      String xs = numberStr.substring(index+1); 
      System.out.println(pi+"��"+zs.length()+"λ����,"+xs.length()+"λС��.");
  }
}
