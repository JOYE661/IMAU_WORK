package U12_20;

class SaleTicket implements Runnable {
	private int ticket = 10;  
	 public void run() {
	  while (ticket > 0) {
	   synchronized (this) { // 要对当前对象进行同步
	    if (ticket > 0) { // 还有票
	     try {
	       Thread.sleep(300); // 加入延迟
	     } catch (InterruptedException e) {
	       e.printStackTrace();
	     }
	     System.out.println(Thread.currentThread().getName() + "卖票：ticket = " + ticket--);
	     } else {
	        System.out.println("票卖完了");
	        return;
	     }
	   }
	  }
	 }
}
