import java.time.*;
public class GiveCalendar {
   public LocalDate [] getCalendar(LocalDate date) {
       date = date.withDayOfMonth(1);   //ȷ��data���ڵ�day��1����day��ֵ��1
       int days = date.lengthOfMonth(); //�õ������м���
       LocalDate dataArrays[] = new LocalDate[days];
       for(int i = 0;i<days;i++){
           dataArrays[i] = date.plusDays(i);   
       }
       return dataArrays;
   }
}


