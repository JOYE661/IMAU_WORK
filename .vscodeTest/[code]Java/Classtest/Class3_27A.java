
public class Class3_27A {

	public static int add(int x,int y) {
		//�����Ҵ�
		int s;
		s=x+y;
		return s;
	}
	public static int max(int x,int y) {
		//�����Ҵ�
		int m=x;
		if(m<y)m=y;
		return m;
	}
	public static boolean isPrime(int x) {
		//�ж�x�Ƿ�Ϊ����
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
		//�ж��Ƿ�Ϊ���겢�������
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
		//�����������Լ��
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