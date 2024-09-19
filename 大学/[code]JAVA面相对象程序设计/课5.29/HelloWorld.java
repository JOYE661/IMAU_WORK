import java.util.*;
public class HelloWorld {

	public static void main(String[] args) 
	{
		Random rand=new Random();
		Scanner input=new Scanner(System.in);
	//	int n=rand.nextInt(101);
		int n=(int)(rand.nextDouble()*100);
		double t=System.currentTimeMillis();
		while(true) {
			int a=input.nextInt();
			if(a==n) {
				System.out.println("GOOD");
				break;
			}
			else if(a>n) {
				System.out.println("猜大了");
			}
			else if(a<n) {
				System.out.println("猜小了");
			}
		}
		double st=System.currentTimeMillis();
		System.out.println("耗时"+(st-t)/1000+"秒");
		// TODO Auto-generated method stub
		
//		for(int i=0;i<10;i++) {
//			int r=rand.nextInt('Z'-'A'+1)+'A';
//			char s=(char)r;
//			System.out.println(s);
//		}
		
		
	}

}
