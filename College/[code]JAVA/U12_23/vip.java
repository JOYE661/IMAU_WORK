package U12_23;

public class vip implements Runnable{
	@Override
	public void run() {
		synchronized (this) {
			System.out.println("VIP���룬VIP������..........");
			for(int i=10;i>0;i--) {
				System.out.println(i+"��");
			}
		}
		
	}
	
}
