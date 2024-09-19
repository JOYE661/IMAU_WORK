package GEO;

public class Test {
	public static void main(String[] args){
		Circle c1=new Circle(1);
		Circle c2=new Circle(2);
		if(c2.compareTo(c1)>0)
			System.out.println("c2>c1");
		else if(c2.compareTo(c1)==0) {
			System.out.println("c2==c1");
		}
		else
			System.out.println("c2<c1");
	}
}
