import java.util.Scanner;
public class Class3_13Main {

	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		// ����һ����λ����ÿλ����Ӻ�
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