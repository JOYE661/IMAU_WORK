package test3;

public class checkingAccount extends Account{
	private double overdraft;//��͸֧���
	//��Ϊ
	public void setOverdraft(double overdraft) {
		this.overdraft=overdraft;
	}//�Զ����͸֧���
	public void withDraw(double balance) {
		if(super.getBalance()-balance>=0-overdraft) {
			super.withDraw(balance);
		}
		else {
			System.out.println("����͸֧���");
		}
	}
}
