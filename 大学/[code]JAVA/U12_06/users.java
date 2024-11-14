package U12_06;

public class users {
	private String username;
	private String psword;
	
	public users(String username, String psword) {
		this.username = username;
		this.psword = psword;
	}
	public String info() {
		return username+psword;
	}
}

