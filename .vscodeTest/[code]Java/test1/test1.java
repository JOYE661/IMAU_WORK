package test1;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyInteger mi=new MyInteger(2);
		
		if(MyInteger.isEven(2)) {
			System.out.println("yes");
		}
		if(mi.isPrime()) {
			System.out.println("yes");
		}
		if(mi.equals(2)) {
			System.out.println("yes");
		}
	}

}
