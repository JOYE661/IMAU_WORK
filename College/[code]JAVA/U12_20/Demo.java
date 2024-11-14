package U12_20;

public class Demo {
	public static void main(String [] args) {
		SaleTicket mt = new SaleTicket(); 
		Thread t1 = new Thread(mt, "1ºÅ´°¿Ú"); 
		Thread t2 = new Thread(mt, "2ºÅ´°¿Ú"); 
		Thread t3 = new Thread(mt, "3ºÅ´°¿Ú"); 
		t1.start();
		t2.start();
		t3.start();
	}
}