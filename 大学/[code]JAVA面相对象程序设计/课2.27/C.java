package jo1;
import java.util.Scanner;
public class C {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		
		System.out.println("Hello!");
		System.out.println("------------------");
		int arr[]= {1,0,3};
		int min=arr[0],max=arr[0];
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<min) {
				min=arr[i];
			}
			if(arr[i]>max) {
				max=arr[i];
			}
		}
		System.out.println("MAX="+max+"MIN="+min);
		System.out.println("------------------");
		
		
		double r,s,c;
		System.out.println("please enter R:");
		r=input.nextDouble();
		s=3.14*r*r;
		c=2*3.14*r;
		System.out.println("面积="+s);
		System.out.println("周长"+c);
		System.out.println("------------------");
		int a=3,b=4,sum;
		sum=a+b;
		System.out.println(sum);
	}
	void fun(double R){
		double s;
		s=3.14*R*R;
		System.out.println("面积="+s);
	}
}
