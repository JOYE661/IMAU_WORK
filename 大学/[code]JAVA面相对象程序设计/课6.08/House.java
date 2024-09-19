
public class House implements Cloneable{
	private int id;
	private double s;
	public House(int id,double s) {
		this.id=id;
		this.s=s;
	}
	public int getid() {
		return this.id;
	}
	@Override
	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}
}
