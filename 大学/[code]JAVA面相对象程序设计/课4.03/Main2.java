import java.util.Scanner;
public class Main2 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		// TODO Auto-generated method stub
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
