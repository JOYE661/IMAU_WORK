package U12_23;

public class Demo {

	public static void main(String[] args)throws InterruptedException {
		// TODO Auto-generated method stub
		vip vips=new vip();
		Thread t=new Thread(vips);
		t.start();
		for(int i=5;i>=0;i--) {
		
			if(i==4){	
					t.join();
			}
			System.out.println("业务正常办理中，前面等待"+i+"人");
		}
	}
}
