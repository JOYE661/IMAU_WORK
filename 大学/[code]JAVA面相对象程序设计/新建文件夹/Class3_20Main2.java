import java.util.Scanner;
public class Class3_20Main2 {

	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		// 输出2到N之间所有的素数
		
		int N;
		int m;

		N=input.nextInt();
		for(int i=2;i<N;i++) {
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

