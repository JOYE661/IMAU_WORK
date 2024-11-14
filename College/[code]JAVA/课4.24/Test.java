
public class Test {

	public static void main(String[] args) {
		MyPoint p1=new MyPoint();
		MyPoint p2=new MyPoint(10,30.5);
		// TODO Auto-generated method stub
		System.out.println(p1.getDistance(p2));
		System.out.println(p1.getDistance(10,30.5));
		
		MyInteger mi=new MyInteger(5);
		System.out.println(mi.get());
		if(MyInteger.isP(mi)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
	}

}
