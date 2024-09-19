import java.time.*;
import java.util.Locale;
public class Example9_20 {
   public static void main(String args[]) {
      LocalDateTime nowTime = LocalDateTime.now();
      String pattern = "%tY-%<tm-%<td(%<tA)%<tT";
      String s = String.format(pattern,nowTime);
      System.out.println(s);
      s = String.format(Locale.US,"%ta %<tb %<td %<tY %<tp %<tT",nowTime);
      System.out.println(s);
      s = String.format(Locale.JAPAN,"%tYÄê%<tB%<tdÈÕ,%<tA%<tT",nowTime);
      System.out.println(s);
    }
}