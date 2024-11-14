
public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal s=new Sheep();
		Animal t=new Tiger();
		if(s instanceof Sheep) {
			((Sheep)s).eat();
			s.sound();
		}
		
		Fruit a=new Apple();
		Fruit o=new Orange();
		eat(o);
		eat(a);
	}
	public static void eat(Fruit f){
		f.eat();
	}

}
