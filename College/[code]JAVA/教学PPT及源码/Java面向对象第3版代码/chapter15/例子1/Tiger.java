public class Tiger extends Thread {
   public void run() {
      for(int i=1;i<=5;i++) {
         System.out.print("|ÀÏ»¢"+i);
         try {
            sleep(1000);
         }
         catch(Exception exp){}
      }  
   } 
}

