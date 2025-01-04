import java.util.Scanner;
public class Class3_13Main3 {
	// input a number which is in pounds then print the number in kilograms
	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		while(input.hasNext()) {
			int p=input.nextInt();
			double k=p*0.454;
			System.out.println(k);
		}
	}

}
