import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;
public class Example9_14 {
   public static void main(String args[ ]) {
      Pattern pattern;          //模式对象
      Matcher matcher;         //匹配对象
      String regex="-?[0-9][0-9]*[.]?[0-9]*" ;//匹配数字,整数或浮点数的正则表达式
      pattern = Pattern.compile(regex);  //初试化模式对象
      String input = "市话：76.89元，长途67.38元，短信12.68元。";   
      matcher = pattern.matcher(input);  //初始化匹配对象,用于检索input
      double sum = 0;
      while(matcher.find()) {
         String str = matcher.group(); 
         sum += Double.parseDouble(str);
         System.out.print("从"+matcher.start()+"到"+matcher.end()+"匹配的子序列:");
         System.out.println(str);
      } 
      System.out.println("通信总费用:"+sum+"元");
      String [] weatherForecast = {"北京:-9度至7度","广州:10度至21度","阿尔滨:-29度至-7度"};
      double averTemperture[] = new double[weatherForecast.length];//存放三地的平均气温
      for(int i = 0;i<weatherForecast.length;i++ ){
           matcher = pattern.matcher(weatherForecast[i]);
           sum = 0;
           int count = 0;
           while(matcher.find()) {
              count++;
              sum = sum + Double.parseDouble(matcher.group());
           }
           averTemperture[i] = sum/count;  //计算出平均气温，并存放到数组的单元中
      }
      System.out.println("三地的平均气温:"+Arrays.toString(averTemperture));
      Arrays.sort(averTemperture);
      System.out.println("三地的平均气温(升序):"+Arrays.toString(averTemperture));
   }
}


