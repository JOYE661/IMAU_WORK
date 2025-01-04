import java.util.Scanner;
public class Class3_02ArrFindMaxDate {

	public static void main(String[] args) {
		//input 5 intger from keyboard find max and print
		Scanner input;
		input=new Scanner(System.in);
		
		int[] arr;
		arr=new int[5];
		for(int i=0;i<5;i++) {
			arr[i]=input.nextInt();
		}
		int max=arr[0];
		for(int j=0;j<arr.length;j++) {
			if(arr[j]>max) {
				max=arr[j];
			}
		}
		System.out.println("MAX="+max);
	}

}
