package U2023Test;

public class Demo1_t2 extends Thread{
	@Override
	public void run(){
		for(int i=0;i<100;i++) {
			if(i%2!=0) {
				System.out.println(currentThread().getName()+"ÆæÊý"+i);
			}
		}
	}
}
