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
       System.out.println(dateStart+"��"+dateEnd+"���\n(�ֱ��꣬��,��,ʱ������)��");
       System.out.println(years+"��(����һ�����ͷ��0����)");
       System.out.println(months+"����(����һ���µ���ͷ��0����)");
       System.out.println(days+"��(����һ�����ͷ��0����)");
       System.out.println(hours+"��Сʱ(����һСʱ����ͷ��0����)");
       System.out.println(weeks+"������(����һ���ڵ���ͷ��0����)");
       dateStart = dateStart.plusYears(years);
       months = dateStart.until(dateEnd,ChronoUnit.MONTHS);
       dateStart = dateStart.plusMonths(months);
       days = dateStart.until(dateEnd,ChronoUnit.DAYS);
       System.out.println(dateStart+"��"+dateEnd+"��");
       System.out.println(years+"�ꡢ��"+months+"���¡���"+days+"�졣");
   }
}


