public class Account {
	//数据域---实例和静态---定义
	private int id=0;
	private double balance=0;
	private static double annuallnterestRate=0;
	//方法----实例
	public int getId() {return id;	}
	public void setId(int id){this.id=id;}
	public double getBalance() {return balance;	}
	public void setBalance(double balance){
		this.balance=balance;
	}
	public static double getAnnuallnterestRate() {
		return annuallnterestRate;	}
	public static void setAnnuallnterestRate(double annuallnterestRate){
		annuallnterestRate=annuallnterestRate;
	}
	public void withDraw(double a){
		balance=balance-a;
	}
	public void deposit(double a){
		balance=balance+a;
	}
	public double getMonthlylnterest(){
		return balance*getMonthlyInterestRate();
	}
	//方法----静态
	public static double getMonthlyInterestRate(){
		return (annuallnterestRate/100)/12;
	}
	//方法----构造方法
	public Account(){ }
	public Account(int a,double b){
		id=a;
		balance=b;
    }

}
