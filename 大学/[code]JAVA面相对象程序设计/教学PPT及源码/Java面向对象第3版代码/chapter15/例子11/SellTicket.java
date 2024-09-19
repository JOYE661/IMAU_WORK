public class SellTicket {
   int 五元钱的个数=2,十元钱的个数=0,二十元钱的个数=0; 
   String s=null;
   public synchronized void  售票规则(int money) {
      String name=Thread.currentThread().getName();
      if(money==5) {  //如果使用该方法的线程传递的参数是5,就不用等待
        五元钱的个数=五元钱的个数+1; 
         s= "给"+name+"入场卷,"+name+"的钱正好";
         WindowTicket.text.append("\n"+s);
      }
      else if(money==20) {           
         while(五元钱的个数<3) {
            try { WindowTicket.text.append("\n"+name+"靠边等...");
                  wait();    //如果使用该方法的线程传递的参数是20须等待
            }
            catch(InterruptedException e){}
         }
         五元钱的个数=五元钱的个数-3;
         二十元钱的个数=二十元钱的个数+1;
         s="给"+name+"入场卷,"+name+"给20，找赎15元";
         WindowTicket.text.append("\n"+s);
      }
      notifyAll();
   }
}
