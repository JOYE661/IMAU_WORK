package GEO;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle[] c=new Circle[10];
		for(int i=0;i<c.length;i++)
		{
			c[i]=new Circle(10-i);
		}
		java.util.Arrays.sort(c);
		for(Circle x:c) {
			System.out.println(x.getR());
		}
	}
}
