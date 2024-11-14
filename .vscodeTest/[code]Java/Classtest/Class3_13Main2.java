import java.util.Scanner;
public class Class3_13Main2 {

	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		// 求两数相加和
		while(input.hasNext()) {
			int a=input.nextInt();
			int b=input.nextInt();
			int sum=a+b;
			System.out.println(sum);
		}

	}

}
