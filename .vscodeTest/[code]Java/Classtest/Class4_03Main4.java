import java.util.Scanner;
public class Class4_03Main4 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		// �������������Լ��
		int a=input.nextInt();
		int b=input.nextInt();
		int c=input.nextInt();
		System.out.println(fun(a,b,c));
	}
	public static int fun(int a,int b,int c) {
		int min=a;
		int i;
		if(b<a) {
			min=b;
		}
		else if(c<a) {
			min=c;
		}
		for(i=min;i>=1;i--) {
			if(a%i==0&&b%i==0&&c%i==0)break;
			
		}
		return i;
	}

}