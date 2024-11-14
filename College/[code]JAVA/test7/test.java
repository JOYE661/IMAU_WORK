package test7;

public class test {

	public static void main(String[] args) throws CloneNotSupportedException{
		// TODO Auto-generated method stub
		House s1=new House(1,1);
		House s2;
		s2=(House)(s1.clone());
		System.out.println(s2.compareTo(s1));
	}

}
