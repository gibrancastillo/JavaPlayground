package com.ccc.instruments;

/**
 * An enumerated type that function sort of like constants or the Factory Design Pattern.
 * Each enum takes the place of one of the guitar properties that is standard across all guitars
 * 
 * The cool thing about enums is that methods or classes that use them are protected from any values not defined in the enum.
 * So you can’t misspell or mistype an enum without getting a compiler error. It’s a great way to get not only type safety,
 * but value safety; you can avoid getting bad data for anything that has a standard range or set of legal values.
 * 
 * @author gecasti
 *
 */
public enum Type {
	ACOUSTIC, ELECTRIC;
	
	public String toString() {
		switch(this) {
			case ACOUSTIC: return "acoustic";
			case ELECTRIC: return "electric";
			default:       return "unspecified";
		}
	}
}