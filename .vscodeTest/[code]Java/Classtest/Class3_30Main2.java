import java.util.Scanner;
//input N then output N columns temp pyramid 
public class Class3_30Main2 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
	
		int N=input.nextInt();
		Print1(N);
		
	}
	public static void Print1(int x){
		
		for(int i=x;i>=1;i--) {
			for(int z=0;z<x-i;z++) {
				System.out.print("  ");
			}
			for(int j=0;j<i;j++) {
				System.out.print("* ");
			}
			
			System.out.println();
		}
	}

}
