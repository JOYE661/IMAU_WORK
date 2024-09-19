package test5;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tiger t=new Tiger();
		f1(t);
		Sheep s=new Sheep();
		f2(s);
		Fruit f=new Apple();
		f3(f);

	}
	//动物发出声音
	public static void f1(Animal a) {
		a.sound();
	}
	//吃的东西
	public static void f2(Edible e) {
		e.eat();
	}
	//吃水果
	public static void f3(Fruit f) {
		f.eat();
	}
}
