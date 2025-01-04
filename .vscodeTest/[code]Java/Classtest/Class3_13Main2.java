import java.util.Scanner;
public class Class3_13Main2 {

	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		// input two numbers then print the sum of them
		while(input.hasNext()) {
			int a=input.nextInt();
			int b=input.nextInt();
			int sum=a+b;
			System.out.println(sum);
		}

	}

}
