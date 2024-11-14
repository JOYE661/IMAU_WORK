package test6;

public class Circle extends Geo implements Comparable<Circle>,Cloneable{
	//Object--clone
	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}
	//comparaTo()---����0����
	@Override
	public int compareTo(Circle c) {
		if(this.r>c.r)return 1;
		else if(this.r<c.r)return -1;
		else return 0;
	}
	
	//˽������r
	private double r;
	//r�ķ��������޸���
	public double getR() {     return r;   }
	public void setR(double r) {   this.r = r;   }
	//��������ķ���
	public double getA() {   return 3.14*r*r;  }
	//���췽��
	public Circle() {   r=1;	 }
	public Circle(double r) {    this.r=r;   }


}
