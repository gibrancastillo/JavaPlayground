package com.ccc.instruments;

/**
 * 
 * Encapsulation allows you to hide the inner workings of your application’s parts, but yet make it clear what each part does.
 * We encapsulated away the specifications of an Instrument class into an InstrumentSpec class but the Instrument class just has a variable
 * pointing to a new InstrumentSpec object that stores all its properties; therefore, using composition (has a) in the Instrument class.
 * 
 * @author gecasti
 *
 */
public class Instrument {
	// These two properties are still unique to each Instrument, so they stay.
	private String serialNumber;
	private double price;
	
	/*
	 * Encapsulation:  separate what changes from what stays the same.  Since the properties in each instrument type are
	 * what varies; therefore, encapsulate those properties away from Instrument class into the InstrumentSpec class.
	 * 
	 * Aggregation:  InstrumentSpec class is used as part of an Instrument class, but the InstrumentSpec class
	 * can also exist outside of an Instrument class (like when it's supplied by a customer for searching).  
	 * 
	 */
	private InstrumentSpec spec;
	
	public Instrument(String serialNumber, double price, InstrumentSpec spec) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.spec = spec;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(float newPrice) {
		this.price = newPrice;
	}
	
	public InstrumentSpec getSpec() {
		return spec;
	}  
}