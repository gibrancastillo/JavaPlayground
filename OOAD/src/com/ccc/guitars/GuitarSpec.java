package com.ccc.guitars;

/**
 * These are the common properties that can be use for both search request and guitar details.
 * Anytime you see duplicate code, look for a place to encapsulate!
 * 
 * The idea behind encapsulation is to protect information in one part of your application from the other parts of your application.
 * In its simplest form, you can protect the data in your class from the rest of your app by making that data private.
 * But sometimes the information might be an entire set of properties—like the details about a guitar—or even behavior—like
 * how a particular type of duck flies.When you break that behavior out from a class, you can change the behavior without the
 * class having to change as well. So if you changed how properties were stored, you wouldn’t have to change your Guitar class at all,
 * because the properties are encapsulated away from Guitar.That’s the power of encapsulation: by breaking up the different parts of
 * your app, you can change one part without having to change all the other parts. In general, you should encapsulate the parts of your
 * app that might vary away from the parts that will stay the same.
 * 
 * Once you’ve gotten your software to work like it’s supposed to, flexibility becomes a big deal. What if the customer wants to add
 * new properties or features to the app? If you’ve got tons of duplicate code or confusing inheritance structures in your app, making
 * changes is going to be a pain.By introducing principles like encapsulation and good class design into your code, it’s easier to make
 * these changes, and your application becomes a lot more flexible.
 * 
 * @author gecasti
 *
 */
public class GuitarSpec {
	private Builder builder;
	private String model;
	private Type type;
	private int numStrings;
	private Wood backWood;
	private Wood topWood;
	
	public GuitarSpec(Builder builder, String model, Type type, int numStrings, Wood backWood, Wood topWood) {
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.numStrings = numStrings;
		this.backWood = backWood;
		this.topWood = topWood;
	}
	
	public Builder getBuilder() {
		return this.builder;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public Type getType() {
		return this.type;
	}
	
	public int getNumStrings() {
		return this.numStrings;
	}
	
	public Wood getBackWood() {
		return this.backWood;
	}
	
	public Wood getTopWood() {
		return this.topWood;
	}
	
	public boolean matches(GuitarSpec otherSpec) {
		if(builder != otherSpec.builder)
			return false;
		
		if(model != null && (!model.equals("")) && (!model.toLowerCase().equals(otherSpec.model.toLowerCase())))
			return false;
		
		if(type != otherSpec.type)
			return false;
		
		if(numStrings != otherSpec.numStrings)
			return false;
		
		if(backWood != otherSpec.backWood)
			return false;
		
		if(topWood != otherSpec.topWood)
			return false;
		
		return true;
	}
}