package U2023Test;
/*
ע�⣺
�����ļ����д���Account.java���ļ����ó����ǲ������ģ�����begin��end����д����ʵ��Ҫ��Ĺ��ܡ�
����ɾ��ע���л�Ķ��������ݣ�����ʱ���ø���ԭ���ļ�����
��Ŀ��������������������������±�����
��д������ڿ����ļ����±�����ԡ�
��ĿҪ�������һ���������������˻���������Ƴ�Ա���������췽�������ٰ�������ѯ����ȡ���Ϣ(�����Ϣ)����������
*/
public class Account{
	public static final double rate=0.015;/*������*/
	private double amount=0;/*���*/
	private String id;/*�ʺ�*/
	/****************begin***************/
public Account(String a){this.id=a;}
public void deposit(double a){this.amount+=a;}
public void withdraw(double a){this.amount-=a;}
public double getAmount(){return amount;}
public double interest(double y){return rate*amount*y+amount;}



	/****************end***************/
	/*����*/
	public static void main(String[] args){
		Account account=new Account("62270001");/*�����ʺ�*/
		account.deposit(3580.88);/*���*/
		account.withdraw(679.32);/*ȡ��*/
		System.out.println(account.getAmount());/*��ѯ���*/
		System.out.println(account.interest(2));/*����2�걾Ϣ�ϼ�*/
	}
}