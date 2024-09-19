
public class MyPoint {
	//属性
	private double x;
	private double y;
	//行为
	public double getDistance(double a,double b) {
		double d;
		d=Math.sqrt((a-x)*(a-x)+(b-y)*(b-y));
		return d;
	}
	public double getDistance(MyPoint p) {
		double d;
		d=Math.sqrt((p.x-this.x)*(p.x-this.x)+(p.y-this.y)*(p.y-this.y));
		return d;
	}
	//构造
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	public MyPoint(double x,double y) {
		this.x=x;
		this.y=y;
	}
	public MyPoint(){
		this.x=0;
		this.y=0;
	}
}
