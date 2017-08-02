package com.ccc.guitars;

/**
 * 
 * Encapsulation allows you to hide the inner workings of your application’s parts, but yet make it clear what each part does.
 * We encapsulated away the specifications of a Guitar class into a GuitarSpec class but the Guitar class just has a variable
 * pointing to a new GuitarSpec object that stores all its properties; therefore, using composition (has a) in the Guitar class.
 * 
 * @author gecasti
 *
 */
public class Guitar {
	// These two properties are still unique to each Guitar, so they stay.
	private String serialNum;
	private double price;
	
	// All the common properties were move to this class, thus using encapsulation and composition.
	GuitarSpec guitarSpec;
	
	public Guitar(String serialNum, double price, GuitarSpec guitarSpec) {
		this.serialNum = serialNum;
		this.price = price;
		this.guitarSpec = guitarSpec;
	}
	
	public String getSerialNum() {
		return this.serialNum;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(float newPrice) {
		this.price = newPrice;
	}
	
	public GuitarSpec getGuitarSpec() {
		return this.guitarSpec;
	}
}