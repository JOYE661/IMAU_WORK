package test3;

public class Account {
	//属性
	private int id=0;
	private double balance=0;
	private double annuallnterestRate=0;
	//构造
	public Account(){}
	public Account(int id,double balance) {
		this.id=id;
		this.balance=balance;
	}
	//行为
	public double getMonthlyInterestRate() {
		return balance*(annuallnterestRate/12/100);
	}
	public void withDraw(double balance) {
		this.balance=this.balance-balance;
	}
	public void deposit(double balance) {
		this.balance=this.balance+balance;
	}
	public double getMonthlyInterest() {
		return annuallnterestRate/12/100;
	}
	public void setId(int id) {
		this.id=id;
	}
	public void setBalance(double balance) {
		this.balance=balance;
	}
	public void setAnnuallnterestRate(double annuallnterestRate) {
		this.annuallnterestRate=annuallnterestRate;
	}
	public int getId() {
		return this.id;
	}
	public double getBalance() {
		return this.balance;
	}
	public double getAnnuallnterestRate() {
		return this.annuallnterestRate;
	}
}
