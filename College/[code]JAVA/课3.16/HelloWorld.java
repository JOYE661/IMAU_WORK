import java.util.Scanner;
public class HelloWorld {

	public static void main(String[] args) 
	{
		Scanner input;
		input=new Scanner(System.in);
		// TODO Auto-generated method stub
		int[] arr;
		arr=new int[5];
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
		//开始查找
		System.out.println("Check:");
		int check=input.nextInt();
		int x=0;
		int y=arr.length-1;
		while(x<=y) {
			int mid=(x+y)/2;
			if(check<arr[mid]) {
				y=mid-1;
			}
			else if(check>arr[mid]) {
				x=mid+1;
			}
			else {
				System.out.println("下标为:"+mid);
				break;
			}
			
		}
		
	}

}
