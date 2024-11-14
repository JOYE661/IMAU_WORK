package test6;

public class Circle extends Geo implements Comparable<Circle>,Cloneable{
	//Object--clone
	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}
	//comparaTo()---正，0，负
	@Override
	public int compareTo(Circle c) {
		if(this.r>c.r)return 1;
		else if(this.r<c.r)return -1;
		else return 0;
	}
	
	//私有数据r
	private double r;
	//r的访问器和修改器
	public double getR() {     return r;   }
	public void setR(double r) {   this.r = r;   }
	//计算面积的方法
	public double getA() {   return 3.14*r*r;  }
	//构造方法
	public Circle() {   r=1;	 }
	public Circle(double r) {    this.r=r;   }


}
