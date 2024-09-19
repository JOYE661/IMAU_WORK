import java.util.Scanner;
public class Class4_03Main1 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		// 方法实现1!+2!+...+n!
		int n=input.nextInt();
		int sum=0;
		int s;
		for(int i=1;i<=n;i++) {
			s=fun(i);
			sum=sum+s;
		}
		System.out.println(sum);
	}
	public static int fun(int n) {
		int s=1;
		while(n!=0) {
			s=s*n;
			n--;
		}
		return s;
	}

}
