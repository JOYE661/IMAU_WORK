public class Account {
	//������---ʵ���;�̬---����
	private int id=0;
	private double balance=0;
	private static double annuallnterestRate=0;
	//����----ʵ��
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
	//����----��̬
	public static double getMonthlyInterestRate(){
		return (annuallnterestRate/100)/12;
	}
	//����----���췽��
	public Account(){ }
	public Account(int a,double b){
		id=a;
		balance=b;
    }

}
