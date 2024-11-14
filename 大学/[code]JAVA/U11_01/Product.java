package U11_01;

import java.io.*;
import java.util.Objects;

public class Product implements Serializable{
	private String nameString;
	private double price;
	private String sort;
	private String effect;

	public Product() {
		nameString=null;
		price=9999;
	}
	public Product(String nameString,double price,String sort,String effect) {
		this.nameString=nameString;
		this.price=price;
		this.sort=sort;
		this.effect=effect;
		
	}
	@Override
	public String toString() {
		return nameString+"售价（kg）:"+price+"类别"+sort+"功效"+effect;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		//Product pro=(Product)obj;
		//return pro.nameString.equals(this.nameString)&&pro.price==this.price&&pro.equals(this.sort)&&pro.equals(this.effect);
		Product product;
		if(obj instanceof Product) {
			product=(Product)obj;
			return product.nameString.equals(this.nameString)&&product.price==this.price&&product.effect.equals(this.effect)&&product.sort.equals(this.sort);
			//product.nameString==this.nameString
		}else {
			return false;
		}
	}
	@Override
	public int hashCode() {
		return Objects.hash(nameString,price,effect,sort);
	}
	
	public void setNameString(String nameString){
		this.nameString = nameString;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	
}
