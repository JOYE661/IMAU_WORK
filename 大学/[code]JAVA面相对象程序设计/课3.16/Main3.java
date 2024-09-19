import java.util.Scanner;
public class Main3 {

	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		//  冒泡排序十个数并输出
		int[] arr;
		arr=new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=input.nextInt();
		}
		for(int i=0;i<arr.length-1;i++) {
			for(int j=arr.length-1;j>i;j--) {
				if(arr[j]<arr[j-1]) {
					int temp=arr[j];arr[j]=arr[j-1];arr[j-1]=temp;
				}
			}
		}
		for(int x:arr) {
			System.out.print(x+" ");
		}
	}

}
