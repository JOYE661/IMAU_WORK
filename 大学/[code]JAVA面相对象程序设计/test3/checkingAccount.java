package test3;

public class checkingAccount extends Account{
	private double overdraft;//可透支额度
	//行为
	public void setOverdraft(double overdraft) {
		this.overdraft=overdraft;
	}//自定义可透支额度
	public void withDraw(double balance) {
		if(super.getBalance()-balance>=0-overdraft) {
			super.withDraw(balance);
		}
		else {
			System.out.println("超出透支额度");
		}
	}
}
