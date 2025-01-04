import java.util.Scanner;
public class Class3_13Main4 {
// input a number then print Yes if it is a multiple of 5, print No otherwise
	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		
		while(input.hasNext()) {
			int x=input.nextInt();
			if(x%5==0) {
				System.out.println("Yes");
			}
			else {
				System.out.println("No");
			}
		}
	}

}
