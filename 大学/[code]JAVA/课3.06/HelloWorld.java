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
		
		int count=0;
		int temp=0;
		int max=0;
		for(int j=0;j<arr.length-1;j++) {
			max=arr[j];
			count=j;
			for(int i=j+1;i<arr.length;i++) {
				if(arr[i]>max) {
					max=arr[i];
					count=i;
				}
			}
			temp=arr[j];arr[j]=arr[count];arr[count]=temp;
		}
		
		System.out.println("max="+max);
		System.out.println("max count:"+count);

		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
    
	}

}
