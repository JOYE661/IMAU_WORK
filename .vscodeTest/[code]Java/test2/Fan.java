package test2;

public class Fan{
	final int SLOW=1;
	final int MEDIUM=2;
	final int FAST=3;
	//属性
	private int speed=SLOW;
	private boolean on=false;
	private double radius=5;
	private String color="bule";
	//行为
	public String toString() {
		if(on==true) {
			return "风扇速度："+speed+"风扇颜色："+color+"风扇半径："+radius;
		}
		else {
			return "fan is off"+"风扇颜色："+color+"风扇半径："+radius;
		}
	}
	//构造
	public void setSpeed(int speed) {
		this.speed=speed;
	}
	public void setOn(boolean on) {
		this.on=on;
	}
	public void setRadius(double radius) {
		this.radius=radius;
	}
	public void setColor(String color) {
		this.color=color;
	}
	public int readSpeed() {
		return speed;
	}
	public boolean readOn() {
		return on;
	}
	public double readRadius() {
		return speed;
	}
	public String readColor() {
		return color;
	}
	public Fan() {}
}
