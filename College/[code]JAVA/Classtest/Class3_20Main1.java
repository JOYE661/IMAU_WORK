import java.util.Scanner;
public class Class3_20Main1 {

	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		//统计数字，输入n个数，统计0-9出现的数字个数
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
