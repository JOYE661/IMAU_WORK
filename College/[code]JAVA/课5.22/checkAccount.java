
public class checkAccount extends Account{
	private double Overflaw=0;
	
	public void setOverflaw(double Overflaw) {
		this.Overflaw=Overflaw;
	}
	public final void withDraw(double a){
		if(super.getBalance()-a>=0-Overflaw) {
			super.withDraw(a);
		}
		else {
			System.out.println("超出透支额度，取款失败");
		}
	}
}
