import java.time.*;
import java.time.temporal.ChronoUnit;
public class Example9_18 {
   public static void main(String args[ ]) {
       LocalDateTime dateStart = LocalDateTime.of(1931,9,18,0,0,0);
       LocalDateTime dateEnd = LocalDateTime.of(1945,8,15,0,0,0);
       long years = dateStart.until(dateEnd,ChronoUnit.YEARS);
       long months = dateStart.until(dateEnd,ChronoUnit.MONTHS);
       long days = dateStart.until(dateEnd,ChronoUnit.DAYS);
       long hours = dateStart.until(dateEnd,ChronoUnit.HOURS);
       long weeks = dateStart.until(dateEnd,ChronoUnit.WEEKS);
       System.out.println(dateStart+"和"+dateEnd+"相差\n(分别按年，月,日,时和星期)：");
       System.out.println(years+"年(不足一年的零头按0计算)");
       System.out.println(months+"个月(不足一个月的零头按0计算)");
       System.out.println(days+"天(不足一天的零头按0计算)");
       System.out.println(hours+"个小时(不足一小时的零头按0计算)");
       System.out.println(weeks+"个星期(不足一星期的零头按0计算)");
       dateStart = dateStart.plusYears(years);
       months = dateStart.until(dateEnd,ChronoUnit.MONTHS);
       dateStart = dateStart.plusMonths(months);
       days = dateStart.until(dateEnd,ChronoUnit.DAYS);
       System.out.println(dateStart+"和"+dateEnd+"相差：");
       System.out.println(years+"年、零"+months+"个月、零"+days+"天。");
   }
}


