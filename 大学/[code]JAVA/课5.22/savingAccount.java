
public class savingAccount extends Account{
	public final void withDraw(double a){
		if(super.getBalance()-a>=0) {
			super.withDraw(a);
		}
		else {
			System.out.println("���㣬ȡ��ʧ��");
		}
	}
}
