package test7;

public class House implements Comparable<House>,Cloneable{
	private int id;
	private double s;
	public int getId() {
		return id;
	}
	public double getS() {
		return s;
	}
	public House(int id,double s) {
		this.id=id;
		this.s=s;
	}
	@Override
	public int compareTo(House h) {
		if(h.s>this.s) {
			System.out.println("大于");
			return 1;
		}
		else if(h.s<this.s) {
			System.out.println("大于");
			return -1;
		}
		else{
			System.out.println("等于");
			return 0;
		}
	}
	@Override
	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}
}
