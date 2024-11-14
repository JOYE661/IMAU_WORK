import java.util.Scanner;
public class Class4_03Main2 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		// 输出n内奇数和
		int n=input.nextInt();
		int sum=0;
		for(int i=0;i<=n;i++) {
			if(fun(i)) {
				sum=sum+i;
			}
		}
		System.out.println(sum);
	}
	public static boolean fun(int x) {
		if(x%2!=0)return true;
		else return false;
	}
}
