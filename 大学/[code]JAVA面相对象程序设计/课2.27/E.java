package jo1;
import java.util.Scanner;
public class E {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		System.out.println("请输入第一个数a");
		int a=input.nextInt();
		System.out.println("请输入第二个数b");
		int b=input.nextInt();
		if(a>b){
			System.out.println("a大于b");
		}
		else if(a<b) {
			System.out.println("a小于b");
		}
		else if(a==b) {
			System.out.println("a等于b");
		}
	}

}
