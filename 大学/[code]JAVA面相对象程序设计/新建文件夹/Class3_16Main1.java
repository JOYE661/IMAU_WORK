import java.util.Scanner;
public class Class3_16Main1 {

	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		//   µœ÷1£°+2£°+3£°+......+n!
		int n=input.nextInt();
		int sum=0;
		while(n!=0) {
			
			int s=1;
			for(int i=1;i<=n;i++) {
				
				s=s*i;
			}
			sum=sum+s;
			n--;
		}
		System.out.println(sum);
	}

}
