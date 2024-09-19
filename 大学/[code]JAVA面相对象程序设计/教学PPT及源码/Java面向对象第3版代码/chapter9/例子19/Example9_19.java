import java.time.*;
public class Example9_19 {
   public static void main(String args[]) {
        LocalDate date = LocalDate.now();
        GiveCalendar giveCalendar  = new GiveCalendar();
        LocalDate [] dataArrays = giveCalendar.getCalendar(date);
        printNameHead(date); //输出日历的头
        for(int i = 0;i<dataArrays.length;i++) {
           if( i == 0){
              printSpace(dataArrays[i].getDayOfWeek()); //根据1号是星期几，输出样式空格
              System.out.printf("%4d",dataArrays[i].getDayOfMonth());
           }
           else {
              System.out.printf("%4d",dataArrays[i].getDayOfMonth());
           }
           if(dataArrays[i].getDayOfWeek() == DayOfWeek.SATURDAY) //星期六为星期最后一天
              System.out.println(); //日历样式中的星期回行
        }
   }
   public static void printSpace(DayOfWeek x) { //输出空格
      switch(x) {
          case SUNDAY:printSpace(0);
                      break;
          case MONDAY:printSpace(1);;
                                    break;
          case TUESDAY:printSpace(2);
                                    break;
          case WEDNESDAY:printSpace(3);
                         break;
          case THURSDAY: printSpace(4);
                         break;
          case FRIDAY:   printSpace(5);
                         break;
          case SATURDAY: printSpace(6);
                         break;
      }
   }
   public static void printSpace(int n){
      for(int i = 0;i< n;i++)
        System.out.printf("%4s","");//输出4个空格
   }
   public static void printNameHead(LocalDate date){  //输出日历的头
      System.out.println(date.getYear()+"年"+date.getMonthValue()+"月日历:");
      String name[] = {"日","一","二","三","四","五","六"};
      for(int i = 0;i<name.length;i++)
        System.out.printf("%3s",name[i]);
      System.out.println();
   }
}