package U12_20;

public class Demo {
	public static void main(String [] args) {
		SaleTicket mt = new SaleTicket(); 
		Thread t1 = new Thread(mt, "1�Ŵ���"); 
		Thread t2 = new Thread(mt, "2�Ŵ���"); 
		Thread t3 = new Thread(mt, "3�Ŵ���"); 
		t1.start();
		t2.start();
		t3.start();
	}
}