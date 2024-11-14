
public class HelloWorld {

	public class Fan{
		int speed;
		boolean on;
		double r;
		String color;
		public String Print() {
			String s;
			if(on==true) {
				s=speed+""+r+""+color;
			}
			else {
				s="Fan is off"+""+r+""+color;
			}
			return s;
		}
		public Fan() {}
	}
	
}
