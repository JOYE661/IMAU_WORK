import java.io.IOException;
import java.util.Scanner;
public class test1 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		int b=input.nextInt();
		// TODO Auto-generated method stub
		try {
			System.out.println(f(a,b));
		}catch(IOException e) {
			System.out.println("cuole");
		}
	}
	public static int f(int x,int y) throws IOException {
		
			if(y==0) {
				throw new IOException("³ýÊýÎª0");
			}
		return x/y;
	}
}
