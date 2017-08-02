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
public enum Wood {
	INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;
	
	public String toSring() {
		switch(this) {
			case INDIAN_ROSEWOOD:    return "Indian Rosewood";
		    case BRAZILIAN_ROSEWOOD: return "Brazilian Rosewood";
		    case MAHOGANY:           return "Mahogany";
		    case MAPLE:              return "Maple";
		    case COCOBOLO:           return "Cocobolo";
		    case CEDAR:              return "Cedar";
		    case ADIRONDACK:         return "Adirondack";
		    case ALDER:              return "Alder";
		    case SITKA:              return "Sitka";
		    default:                 return "unspecified";
		}
	}
}