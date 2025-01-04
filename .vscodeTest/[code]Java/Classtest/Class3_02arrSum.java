import java.util.Scanner;
public class Class3_02arrSum {

	public static void main(String[] args) {
		//sum 5 numbers
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
