public class Bank implements Runnable {
   private int number=0;
   public void setMoney(int m) {
      number=m;
   }
   public void run() {      //��дRunnable�ӿ��еķ���
      while(true) {
         String name=Thread.currentThread().getName();
         if(name.equals("One")) {
            if(number<=160) {
               System.out.println(name+"��������״̬");
               return;     // threadOne��run��������
            }    
            number=number+10;
            System.out.println("����"+name+"����number="+number);
         } 
         if(Thread.currentThread().getName().equals("Two")) {  
            if(number<=0) {
               System.out.println(name+"��������״̬");
               return;     // threadTwo��run��������  
            } 
            number=number-100;
            System.out.println("����"+name+"����number="+number);
         } 
         try{  Thread.sleep(800);
         }
         catch(InterruptedException e){}
      }
   }
}
