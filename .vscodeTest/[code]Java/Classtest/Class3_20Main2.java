import java.util.Scanner;
public class Class3_20Main2 {
	//input N then output all the prime number between 2 to N
	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		
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

