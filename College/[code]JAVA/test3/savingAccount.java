package test3;

public class savingAccount extends Account{
	//行为
	public void withDraw(double balance) {
		if(super.getBalance()-balance>=0) {
			super.withDraw(balance);
		}
		else {
			System.out.println("已透支，不可取钱");
		}
	}
}
