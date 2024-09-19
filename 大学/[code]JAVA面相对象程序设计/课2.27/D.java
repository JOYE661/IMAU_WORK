package jo1;
import java.util.Scanner;
public class D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("请输入一个数");
		int a=input.nextInt();
		if(a>0) {
			System.out.println("正数");
		}
		else {
			System.out.println("负数");
		}
	}

}
