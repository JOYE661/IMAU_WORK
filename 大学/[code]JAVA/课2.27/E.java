package jo1;
import java.util.Scanner;
public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("�������һ����a");
		int a=input.nextInt();
		System.out.println("������ڶ�����b");
		int b=input.nextInt();
		if(a>b){
			System.out.println("a����b");
		}
		else if(a<b) {
			System.out.println("aС��b");
		}
		else if(a==b) {
			System.out.println("a����b");
		}
	}

}
