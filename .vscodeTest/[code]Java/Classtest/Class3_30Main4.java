import java.util.Scanner;
public class Class3_30Main4 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		//output the prime number between n and m
		int m=input.nextInt();
		int n=input.nextInt();
		Prime(m,n);
	}
	public static void Prime(int x,int y) {
		int m;
		for(int i=x;i<=y;i++) {
			if(i==2) {
				System.out.print(i+" ");
			}
			for(int j=2;j<i;j++) {
				if(i%j==0) {
					break;
				}
				m=j;
				if(m>=i-1) {
					System.out.print(i+" ");
				}
			}
			
		}
	}

}
