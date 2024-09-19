import java.util.Scanner;
public class Main3 {

	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		// 输出n到m之间所有的素数
		int N;
		int m;
		int n;
		
		n=input.nextInt();
		N=input.nextInt();
		for(int i=n;i<N;i++) {
			if(i==2) {
				System.out.print(i+" ");
				
			}
			for(int j=2;j<i;j++) {
				if(i%j==0)break;
				m=j;
				if(m>=i-1) {
					System.out.print(i+" ");
				}
			}
		}
	}

}
