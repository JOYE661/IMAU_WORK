
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r1=new Rectangle();
		r1.width=4;
		r1.height=40;
		Rectangle r2=new Rectangle(3.5,35.9);
		System.out.println(r1.width+" "+r1.height+" "+r1.getA()+" "+r1.getP());
		System.out.println(r2.width+" "+r2.height+" "+r2.getA()+" "+r2.getP());
		System.out.println(Rectangle.getS(2, 1));
		System.out.println(Rectangle.count);
	}

}
