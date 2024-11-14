package U12_23;

public class user implements Runnable{
	private int num;
	public void run() {
		
			while (this.num!=0) {
				System.out.println("业务正常办理中，前面等待"+num+"人");
				this.num--;
			}
	}
	public int getNum() {
		return num;
	}
	user(int num){
		this.num=num;
	}
}
