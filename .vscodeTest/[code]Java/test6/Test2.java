package test6;

public class Test2 {

	public static void main(String[] args)throws CloneNotSupportedException{
		// TODO Auto-generated method stub
		Circle c1=new Circle(2);
		Circle c2;
		c2=(Circle)(c1.clone());
		System.out.println(c1.getR());
		System.out.println(c2.getR());
	}

}
