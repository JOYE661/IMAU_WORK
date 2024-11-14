package test2;

public class test1 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		
		Fan fan1=new Fan();
		
		fan1.setSpeed(fan1.FAST);
		fan1.setRadius(10);
		fan1.setColor("yellow");
		fan1.setOn(true);
		System.out.println(fan1.toString());
		
		Fan fan2=new Fan();
		
		fan2.setSpeed(fan2.MEDIUM);
		fan2.setRadius(5);
		fan1.setColor("bule");
		fan1.setOn(false);
		System.out.println(fan2.toString());
	}

}
