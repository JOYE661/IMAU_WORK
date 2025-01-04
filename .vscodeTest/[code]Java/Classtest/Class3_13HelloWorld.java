import java.util.Scanner;
public class Class3_13HelloWorld {

	public static void main(String[] args) {
		// input 5 numbers from keyboard and sort them	
		Scanner input;
		input=new Scanner(System.in);
		int[] arr;
		arr=new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=input.nextInt();
		}
		for(int i=0;i<arr.length-1;i++) {
			int max=arr[i];
			int p=i;
			for(int j=i+1;j<arr.length;j++) {
				if(max<arr[j]) {
					max=arr[j];
					p=j;
				}
			}
			int temp=arr[i];arr[i]=arr[p];arr[p]=temp;
		}
		for(int x:arr) {
			System.out.print(x+" ");

		}
		System.out.println();
		System.out.println("--------------------");
		int[] brr;
		brr=new int[5];
		for(int i=0;i<brr.length;i++) {
			brr[i]=input.nextInt();
		}
		for(int i=0;i<brr.length-1;i++) {
			for(int j=brr.length-1;j>i;j--) {
				if(brr[j]>brr[j-1]) {
					int temp=brr[j];brr[j]=brr[j-1];brr[j-1]=temp;
				}
			}
		}
		for(int x:brr) {
			System.out.print(x+" ");
		}
	}

}
