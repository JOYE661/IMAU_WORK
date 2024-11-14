import java.util.Scanner;
public class Main3 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		// TODO Auto-generated method stub
		int N=input.nextInt();
		Print1(N);
		
	}
	public static void Print1(int x){
		
		for(int i=1;i<=x/2+1;i++) {
			for(int z=x/2+1-i;z>0;z--) {
				System.out.print(" ");
			}
			for(int j=0;j<2*i-1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=x/2;i>=1;i--) {
			for(int z=x/2+1-i;z>0;z--) {
				System.out.print(" ");
			}
			for(int j=0;j<2*i-1;j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

}
