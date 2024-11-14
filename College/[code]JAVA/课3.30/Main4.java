import java.util.Scanner;
public class Main4 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		// TODO Auto-generated method stub
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
