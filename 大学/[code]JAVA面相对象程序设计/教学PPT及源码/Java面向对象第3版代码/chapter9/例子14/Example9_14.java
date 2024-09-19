import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;
public class Example9_14 {
   public static void main(String args[ ]) {
      Pattern pattern;          //ģʽ����
      Matcher matcher;         //ƥ�����
      String regex="-?[0-9][0-9]*[.]?[0-9]*" ;//ƥ������,�����򸡵�����������ʽ
      pattern = Pattern.compile(regex);  //���Ի�ģʽ����
      String input = "�л���76.89Ԫ����;67.38Ԫ������12.68Ԫ��";   
      matcher = pattern.matcher(input);  //��ʼ��ƥ�����,���ڼ���input
      double sum = 0;
      while(matcher.find()) {
         String str = matcher.group(); 
         sum += Double.parseDouble(str);
         System.out.print("��"+matcher.start()+"��"+matcher.end()+"ƥ���������:");
         System.out.println(str);
      } 
      System.out.println("ͨ���ܷ���:"+sum+"Ԫ");
      String [] weatherForecast = {"����:-9����7��","����:10����21��","������:-29����-7��"};
      double averTemperture[] = new double[weatherForecast.length];//������ص�ƽ������
      for(int i = 0;i<weatherForecast.length;i++ ){
           matcher = pattern.matcher(weatherForecast[i]);
           sum = 0;
           int count = 0;
           while(matcher.find()) {
              count++;
              sum = sum + Double.parseDouble(matcher.group());
           }
           averTemperture[i] = sum/count;  //�����ƽ�����£�����ŵ�����ĵ�Ԫ��
      }
      System.out.println("���ص�ƽ������:"+Arrays.toString(averTemperture));
      Arrays.sort(averTemperture);
      System.out.println("���ص�ƽ������(����):"+Arrays.toString(averTemperture));
   }
}


