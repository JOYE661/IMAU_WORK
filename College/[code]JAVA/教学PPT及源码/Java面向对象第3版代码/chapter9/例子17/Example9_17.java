import java.time.*;
public class Example9_17 {
   public static void main(String args[ ]) {
       LocalDate dateOne = LocalDate.now();
       System.out.println("本地日期:"+dateOne);
       LocalDate dateTwo = LocalDate.of(2019,1,22);
       System.out.println("自定日期:"+dateTwo);
       System.out.println(dateOne+"在"+dateTwo+"之后:"+
                          dateOne.isAfter(dateTwo));
       System.out.println(dateOne+"在"+dateTwo+"之前:"+
                          dateOne.isBefore(dateTwo));
       System.out.println(dateOne+"和"+dateTwo+"相同:"+
                          dateOne.isEqual(dateTwo));
       int year = 18,month = 23,day = 8976;
       LocalDate dateLater =  dateOne.plusYears(-year);
       System.out.println(dateOne+" "+ year+"年前是:\n"+dateLater);
       System.out.println("是"+dateLater.getDayOfWeek());
       dateLater =  ((dateTwo.plusYears(year)).plusMonths(month)).plusDays(8976);
       System.out.println(dateTwo+"再过"+year+"年"+month+"个月"+day+"天之后是:");
       System.out.println(dateLater);
       System.out.println("是"+dateLater.getDayOfWeek());
       int second = 897;
       LocalTime time = LocalTime.of(23,30,1);
       System.out.println(time+"再过"+second+"秒是:"+time.plusSeconds(second));
   }
}


