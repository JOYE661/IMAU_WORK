package Account;

public class Account {
	private int id=0;
	private double blance=0;
	private double annuallnterestRate=0;
	
	public Account(){}
	public Account(int id,double blance) {
		this.id=id;
		this.blance=blance;
	}
	public void setone(int id,double blance,double annuallnterestRate) {
		this.id=id;
		this.blance=blance;
		this.annuallnterestRate=annuallnterestRate;
	}
	public int getid() {
		return this.id;
	}
	public double getblance() {
		return this.blance;
	}
	public double getannuallnterestRate() {
		return this.annuallnterestRate;
	}
	public double getMonthlyInterestRate() {
		return blance*(annuallnterestRate/12/100);
	}
	public void withDraw(double blance) {
		this.blance=this.blance-blance;
	}
	public void deposit(double blance) {
		this.blance=this.blance+blance;
	}
	public double getMonthlyInterest() {
		return annuallnterestRate/12/100;
	}
}
