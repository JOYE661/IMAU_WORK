package test4;

public class employee extends Person{
	@Override
	public String toString() {
		return "employee"+super.getname();
	}
}