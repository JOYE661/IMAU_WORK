package U12_06;

public class Fruit {
	private String idString;
	private String nameString;
	private String priceString;
	
	
	public Fruit(String idString, String nameString, String priceString) {
		super();
		this.idString = idString;
		this.nameString = nameString;
		this.priceString = priceString;
	}
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getPriceString() {
		return priceString;
	}
	public void setPriceString(String priceString) {
		this.priceString = priceString;
	}
	
	
	
	
	
}
