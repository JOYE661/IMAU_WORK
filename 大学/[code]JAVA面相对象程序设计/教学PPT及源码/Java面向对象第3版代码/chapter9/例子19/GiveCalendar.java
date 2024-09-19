import java.time.*;
public class GiveCalendar {
   public LocalDate [] getCalendar(LocalDate date) {
       date = date.withDayOfMonth(1);   //确保data日期的day是1，即day的值是1
       int days = date.lengthOfMonth(); //得到该月有几天
       LocalDate dataArrays[] = new LocalDate[days];
       for(int i = 0;i<days;i++){
           dataArrays[i] = date.plusDays(i);   
       }
       return dataArrays;
   }
}


