
public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		checkAccount a=new checkAccount();
		a.setBalance(10);
		a.setOverflaw(50);
		a.withDraw(50);
		System.out.println(a.getBalance());
		a.withDraw(50);
		
		savingAccount b=new savingAccount();
		b.setBalance(10);
		b.withDraw(50);
	}

}
