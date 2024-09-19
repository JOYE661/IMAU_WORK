
public class Triangle extends Geo{
	private double s1=1.0;
	private double s2=1.0;
	private double s3=1.0;
	
	public Triangle() {
		
	}
	
	public Triangle(double s1,double s2,double s3) {
		this.s1=s1;
		this.s2=s2;
		this.s3=s3;
	}
	public double getS1() {
		return this.s1;
	}
	public double getS2() {
		return this.s2;
	}
	public double getS3() {
		return this.s3;
	}
	public double getA() {
		double s=(this.s1+this.s2+this.s3)/2;
		return Math.sqrt(s*(s-s1)*(s-s2)*(s-s3));
	}
	public double getP() {
		return this.s1+this.s2+this.s3;
	}
	public String toString() {
		return "s1="+s1+"s2="+s2+"s3="+s3;
	}
}
