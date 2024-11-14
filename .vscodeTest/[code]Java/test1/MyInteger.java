package test1;

public class MyInteger {
	//ÊôÐÔ
	int value;
	//ÐÐÎª
	public boolean isEven() {
		boolean f;
		if(value%2==0) {
			f=true;
		}
		else {
			f=false;
		}
		return f;
	}
	public static boolean isEven(int x) {
		boolean f;
		if(x%2==0) {
			f=true;
		}
		else {
			f=false;
		}
		return f;
	}
	public boolean isOdd() {
		boolean f;
		if(value%2!=0) {
			f=true;
		}
		else {
			f=false;
		}
		return f;
	}
	public static boolean isOdd(int x) {
		boolean f;
		if(x%2!=0) {
			f=true;
		}
		else {
			f=false;
		}
		return f;
	}
	public boolean isPrime() {
		boolean f;
		int i=2;
		while(i<value-1) {
			if(value%i==0) {
				break;
			}
			i++;
		}
		if(i>value-1) {
			f=true;
		}
		else {
			f=false;
		}
		return f;
	}
	public static boolean isPrime(int x) {
		boolean f;
		int i=2;
		while(i<x-1) {
			if(x%i==0) {
				break;
			}
			i++;
		}
		if(i>x-1) {
			f=true;
		}
		else {
			f=false;
		}
		return f;
	}
	public boolean equals(int x) {
		boolean f;
		if(value==x) {
			f=true;
		}
		else {
			f=false;
		}
		return f;
	}
	
	public MyInteger(int x) {
		value=x;
	}
}
