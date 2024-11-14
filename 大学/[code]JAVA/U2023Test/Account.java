package U2023Test;
/*
注意：
考生文件夹中存有Account.java的文件，该程序是不完整的，请在begin到end间填写代码实现要求的功能。
请勿删除注释行或改动已有内容，保存时不得更改原有文件名。
题目所需变量均已声明，请勿声明新变量。
编写完成请在考生文件夹下编译调试。
题目要求：请设计一个类来描述银行账户，自行设计成员变量及构造方法，至少包含余额查询，存款、取款、计息(按年计息)三个方法。
*/
public class Account{
	public static final double rate=0.015;/*年利率*/
	private double amount=0;/*余额*/
	private String id;/*帐号*/
	/****************begin***************/
public Account(String a){this.id=a;}
public void deposit(double a){this.amount+=a;}
public void withdraw(double a){this.amount-=a;}
public double getAmount(){return amount;}
public double interest(double y){return rate*amount*y+amount;}



	/****************end***************/
	/*测试*/
	public static void main(String[] args){
		Account account=new Account("62270001");/*创建帐号*/
		account.deposit(3580.88);/*存款*/
		account.withdraw(679.32);/*取款*/
		System.out.println(account.getAmount());/*查询余额*/
		System.out.println(account.interest(2));/*余额存2年本息合计*/
	}
}