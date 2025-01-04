import java.util.Scanner;
public class Class3_20Main1 {
	//input n number from keyboat than count the times of 0-9 then output
	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		int n,x;
		int []arr;
		arr=new int[10];
		n=input.nextInt();
		for(int i=0;i<n;i++) {
			x=input.nextInt();
			if(x>=0&&x<=9) {
				arr[x]++;
			}
		}
		for(int i=0;i<arr.length;i++) {
			System.out.println(i+" "+arr[i]);
		}
		
	}

}
