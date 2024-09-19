public class ComputerSum implements Runnable {
   int i=1,sum=0;             //线程共享的数据
   public void run() {      
      Thread  thread=Thread.currentThread();
      System.out.println(thread.getName()+"开始计算");
      while(i<=10) {
        sum=sum+i;
        System.out.print(" "+sum);
        if(i==5) {
           System.out.println(thread.getName()+"完成任务了！i="+i);
           Thread threadTwo=new Thread(this);//threadTwo与 threadOne的目标对象相同
           threadTwo.setName("李四");
           threadTwo.start();  //启动threadTwo
           i++;      //死亡之前将i变成6
           return;   //threadOne死亡  
        }
        i++;
        try{  Thread.sleep(300);
        }
        catch(InterruptedException e){}
      }
   }
}
