
public class MI {
	int value;
	
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
	
	public MI(int x) {
		value=x;
	}
}
