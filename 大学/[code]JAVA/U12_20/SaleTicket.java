package U12_20;

class SaleTicket implements Runnable {
	private int ticket = 10;  
	 public void run() {
	  while (ticket > 0) {
	   synchronized (this) { // Ҫ�Ե�ǰ�������ͬ��
	    if (ticket > 0) { // ����Ʊ
	     try {
	       Thread.sleep(300); // �����ӳ�
	     } catch (InterruptedException e) {
	       e.printStackTrace();
	     }
	     System.out.println(Thread.currentThread().getName() + "��Ʊ��ticket = " + ticket--);
	     } else {
	        System.out.println("Ʊ������");
	        return;
	     }
	   }
	  }
	 }
}
