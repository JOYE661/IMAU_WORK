
public class Rectangle {
	double width=1;
	double height=1;
	static int count=0;
	
	
	public double getA() {
		return width*height;
	}
	public double getP() {
		return (width+height)*2;
	}
	public static double getS(double a,double b) {
		return a*b;
	}
	
	public Rectangle() {
		count++;
	}
	public Rectangle(double x,double y) {
		width=x;
		height=y;
		count++;
	}
}
