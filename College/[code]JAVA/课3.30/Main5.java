import java.util.Scanner;
public class Main5 {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		// TODO Auto-generated method stub
		int N=input.nextInt();
		int[] arr;
		int[] b;
		arr=new int[10];
		b=new int[10];
		b=fun(N,arr);
		for(int i=0;i<b.length;i++) {
			System.out.println(i+" "+b[i]);
		}
	}
	public static int[] fun(int n,int arr[]) {
		Scanner in=new Scanner(System.in);
		int x;
		for(int i=0;i<n;i++) {
			x=in.nextInt();
			if(x>=0&&x<=9) {
				arr[x]++;
			}
		}
		
		return arr;
				
	}
}
