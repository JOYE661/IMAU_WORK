package test3;

public class savingAccount extends Account{
	//��Ϊ
	public void withDraw(double balance) {
		if(super.getBalance()-balance>=0) {
			super.withDraw(balance);
		}
		else {
			System.out.println("��͸֧������ȡǮ");
		}
	}
}
