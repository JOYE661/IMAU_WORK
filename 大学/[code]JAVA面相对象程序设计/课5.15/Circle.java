
public class Circle extends Geo{
	private double r;
	public void setR(double r) {
		this.r=r;
	}
	public double getR(double r) {
		return r;
	}
	public double getA() {
		return 3.14*r*r;
	}
	public Circle() {
		//super("bule");
		this.r=1;
		setColor("bule");
		
	}
	public Circle(double r,String color) {
		//super(color);
		this.r=r;
		setColor(color);
	}
	
}
