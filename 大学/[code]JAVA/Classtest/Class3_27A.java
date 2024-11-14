
public class Class3_27A {

	public static int add(int x,int y) {
		//函数找错
		int s;
		s=x+y;
		return s;
	}
	public static int max(int x,int y) {
		//函数找错
		int m=x;
		if(m<y)m=y;
		return m;
	}
	public static boolean isPrime(int x) {
		//判断x是否为素数
		int i;
		for(i=2;i<x;i++) {
			if(x%i==0)break;
		}
		boolean f=false;
		if(i>=x)f=true;
		if(i<x)f=false;
		return f;
	}
	public static int isYear(int year) {
		//判断是否为闰年并输出天数
		int day=0;
		if(year%400==0||year%4==0&&year%100!=0) {
			day=366;
		}
		else {
			day=365;
		}
		return day;
	}
	public static int fun(int x,int y) {
		//两个数找最大公约数
		int n=0;
		int min=x;
		if(x>y)min=y;
		for(int i=min;i!=0;i--) {
			if(x%i==0&&y%i==0) {
				n=i;
				break;
			}
		}
		return n;
	}
}
