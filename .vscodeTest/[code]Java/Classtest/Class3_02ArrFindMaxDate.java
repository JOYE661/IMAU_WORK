import java.util.Scanner;
public class Class3_02ArrFindMaxDate {

	public static void main(String[] args) {
		Scanner input;
		input=new Scanner(System.in);
		//�Ӽ�������5������ �ҳ����ֵ�����
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