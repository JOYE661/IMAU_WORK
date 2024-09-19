
public class MyInteger {
	//属性
	private int value;
	//行为
	public boolean isP() {
		boolean f;
		if(value==1) {
			f=false;
		}
		else {
			int i;
			for(i=2;i<=value-1;i++) {
				if(value%i==0) {
					break;
				}
			}
			if(i>value-1) {
				f=true;
			}
			else return false;
		}
		return f;
	}
	public static boolean isP(int x) {
		boolean f;
		if(x==1) {
			f=false;
		}
		else {
			int i;
			for(i=2;i<=x-1;i++) {
				if(x%i==0) {
					break;
				}
			}
			if(i>x-1) {
				return true;
			}
			else return false;
		}
		return f;
	}
	public static boolean isP(MyInteger mi) {
		boolean f;
		if(mi.value==1) {
			f=false;
		}
		else {
			int i;
			for(i=2;i<=mi.value-1;i++) {
				if(mi.value%i==0) {
					break;
				}
			}
			if(i>mi.value-1) {
				return true;
			}
			else return false;
		}
		return f;
	}
	//构造
	public int get() {
		return value;
	}
	public MyInteger(int x) {
		value=x;
	}
}
