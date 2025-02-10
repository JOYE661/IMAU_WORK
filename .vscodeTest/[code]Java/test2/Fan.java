//package Classtest;

public class Fan{
	final int SLOW=1;
	final int MEDIUM=2;
	final int FAST=3;
	
	//variable
	private int speed=SLOW;
	private boolean on=false;
	private double radius=5;
	private String color="bule";
	//action
	public String toString() {
		if(on==true) {
			return "FunSpeed:"+speed+""+color+"FunRadius:"+radius;
		}
		else {
			return "fan is off"+"Funcolor:"+color+"FunRadius:"+radius;
		}
	}
	
	//getter setter
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