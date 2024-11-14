package test3;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		checkingAccount c=new checkingAccount();//ø…Õ∏÷ß
		c.setBalance(50);
		c.setOverdraft(100);
		c.withDraw(60);
		System.out.println(c.getBalance());
		c.withDraw(100);
		
		savingAccount s=new savingAccount();
		s.setBalance(50);
		s.withDraw(30);
		System.out.println(s.getBalance());
		s.withDraw(30);
	}

}
