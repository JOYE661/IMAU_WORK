import java.time.*;
public class Example9_17 {
   public static void main(String args[ ]) {
       LocalDate dateOne = LocalDate.now();
       System.out.println("��������:"+dateOne);
       LocalDate dateTwo = LocalDate.of(2019,1,22);
       System.out.println("�Զ�����:"+dateTwo);
       System.out.println(dateOne+"��"+dateTwo+"֮��:"+
                          dateOne.isAfter(dateTwo));
       System.out.println(dateOne+"��"+dateTwo+"֮ǰ:"+
                          dateOne.isBefore(dateTwo));
       System.out.println(dateOne+"��"+dateTwo+"��ͬ:"+
                          dateOne.isEqual(dateTwo));
       int year = 18,month = 23,day = 8976;
       LocalDate dateLater =  dateOne.plusYears(-year);
       System.out.println(dateOne+" "+ year+"��ǰ��:\n"+dateLater);
       System.out.println("��"+dateLater.getDayOfWeek());
       dateLater =  ((dateTwo.plusYears(year)).plusMonths(month)).plusDays(8976);
       System.out.println(dateTwo+"�ٹ�"+year+"��"+month+"����"+day+"��֮����:");
       System.out.println(dateLater);
       System.out.println("��"+dateLater.getDayOfWeek());
       int second = 897;
       LocalTime time = LocalTime.of(23,30,1);
       System.out.println(time+"�ٹ�"+second+"����:"+time.plusSeconds(second));
   }
}


