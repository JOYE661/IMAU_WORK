import java.util.Scanner;
public class Main3 {

	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		// ���n��m֮�����е�����
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
