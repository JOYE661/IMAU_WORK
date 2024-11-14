import java.util.Scanner;
public class Main4 {

	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		// TODO Auto-generated method stub
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
