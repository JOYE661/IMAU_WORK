import java.util.Scanner;
public class Class3_02arrSum {
//从键盘输入5个整数 求和
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input;
		input=new Scanner(System.in);
		
		int[] arr;
		arr=new int[5];
		int sum=0;
		for(int i=0;i<=4;i++) {
			arr[i]=input.nextInt();
			sum=sum+arr[i];
		}
		System.out.println(sum);
	}

}
