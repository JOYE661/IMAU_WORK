import java.util.Scanner;
public class Class3_30Main1 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		//input N then output N columns pyramid
		int N=input.nextInt();
		Print1(N);
		
	}
	public static void Print1(int x){
		
		for(int i=1;i<=x;i++) {
		
			for(int j=0;j<i;j++) {
				System.out.print("* ");
			}
			
			System.out.println();
		}
	}

}
