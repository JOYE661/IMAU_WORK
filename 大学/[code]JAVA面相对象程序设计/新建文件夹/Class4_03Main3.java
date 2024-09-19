import java.util.Scanner;
public class Class4_03Main3 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		// 求斐波那契数列数组法
		while(input.hasNext()) {
			int n=input.nextInt();
			long []arr;
			arr=new long[n];
			arr=fun(n,arr);
			for(long x:arr) {
				System.out.print(x+" ");
			}
			System.out.println();
			
		}
	}
	public static long[] fun(int n,long[]arr){
		if(n==1) {
			arr[0]=1;
			return arr;
		}
		arr[0]=arr[1]=1;
		for(int i=2;i<n;i++) {
			arr[i]=arr[i-1]+arr[i-2];
		}
		return arr;
	}
}
