import java.util.Scanner;
public class Class3_16Main2 {
	//find the greatest common divisor from three numbers
	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		int a=input.nextInt();
		int b=input.nextInt();
		int c=input.nextInt();
		int min=a;
		if(min>b) {
			min=b;
		}
		if(b>c) {
			min=c;
		}
		for(int i=min;i!=0;i--) {
			if((a%i==0&&b%i==0)&&c%i==0) {
				System.out.println(i);
				break;
			}
		}
	}

}
