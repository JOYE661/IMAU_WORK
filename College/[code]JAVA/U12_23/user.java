package U12_23;

public class user implements Runnable{
	private int num;
	public void run() {
		
			while (this.num!=0) {
				System.out.println("ҵ�����������У�ǰ��ȴ�"+num+"��");
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
