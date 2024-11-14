import java.util.Scanner;
public class Main3_1 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		// TODO Auto-generated method stub
		int n=input.nextInt();
		int a=0,b=0,c=0,i;
		a=b=1;
		System.out.print(a+" "+b);
		for(i=3;i<=n;i++) {
			c=a+b;
			System.out.print(" "+c);
			a=b;
			b=c;
		}
	}

}
