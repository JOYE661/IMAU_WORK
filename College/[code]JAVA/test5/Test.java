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
	//���﷢������
	public static void f1(Animal a) {
		a.sound();
	}
	//�ԵĶ���
	public static void f2(Edible e) {
		e.eat();
	}
	//��ˮ��
	public static void f3(Fruit f) {
		f.eat();
	}
}
