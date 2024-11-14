package U10_25;

import java.io.*;

public class Student implements Serializable{
	private String name;
	private int num;
	private String career;
	
	public String getname() {
		return this.name;
	}
	public int num() {
		return this.num;
	}
	public String getcareer() {
		return this.career;
	}
	public void setname(String name) {
		this.name=name;
	}
	
	public void setnum(int num) {
		this.num=num;
	}
	public void setcareer(String career) {
		this.career=career;
	}
	
	public Student(String name,int num,String career){
		this.name=name;
		this.num=num;
		this.career=career;
	}
	public String toString() {
		return "student="+"name:"+name+"/"+"num:"+num+"/"+"career:"+career;
	}
}
