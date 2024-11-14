import java.time.*;
public class Target implements Runnable {
    public void run() {     
       while(true) {
           LocalTime time = LocalTime.now();
           System.out.printf("%d:%d:%d\n",
           time.getHour(),time.getMinute(),time.getSecond());
           try{ Thread.sleep(1000);
           }
           catch(InterruptedException e){}
       }
    }
}
