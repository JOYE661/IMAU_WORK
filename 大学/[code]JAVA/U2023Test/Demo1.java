package U2023Test;
//���߳̽����������ż��
public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1=new Demo1_t1();
		Thread t2=new Demo1_t2();
		t1.start();
		t2.start();
	}

}
