import java.util.Scanner;
public class HelloWorld {

	public static void main(String[] args) 
	{
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		int b=input.nextInt();
		// TODO Auto-generated method stub
		try {
			
			System.out.println(f(a,b));
		}
		catch(ArithmeticException e) {
			System.out.println("除数为0，错误");
		}
		
	}
	public static int f(int x,int y) {
		if(y==0) {
			throw new ArithmeticException("除数为0");
		}
		return x/y;
	}

}
