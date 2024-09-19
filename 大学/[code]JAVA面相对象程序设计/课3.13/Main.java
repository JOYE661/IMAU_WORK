import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input;
		input=new Scanner(System.in);
		while(input.hasNext()) {
			int x=input.nextInt();
			int a=x%10;
			int b=(x/10)%10;
			int c=x/100;
			int sum=a+b+c;
			System.out.println(sum);
		}
	}

}
