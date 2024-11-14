package java23;

class MyPoint{
	double x;
	double y;
	public double getD(double a,double b) {
		double d;
		d=Math.sqrt((a-x)*(a-x)+(b-y)*(b-y));
		return d;
	}
	public MyPoint(){}
}

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
