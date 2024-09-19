public class Bank implements Runnable {
   private int number=0;
   public void setMoney(int m) {
      number=m;
   }
   public void run() {      //重写Runnable接口中的方法
      while(true) {
         String name=Thread.currentThread().getName();
         if(name.equals("One")) {
            if(number<=160) {
               System.out.println(name+"进入死亡状态");
               return;     // threadOne的run方法结束
            }    
            number=number+10;
            System.out.println("我是"+name+"现在number="+number);
         } 
         if(Thread.currentThread().getName().equals("Two")) {  
            if(number<=0) {
               System.out.println(name+"进入死亡状态");
               return;     // threadTwo的run方法结束  
            } 
            number=number-100;
            System.out.println("我是"+name+"现在number="+number);
         } 
         try{  Thread.sleep(800);
         }
         catch(InterruptedException e){}
      }
   }
}
