package com.ccc.playground.separate;

/**
 * This Enum cannot be private or protected.  An enum that isn't enclosed in a class can be
 * declared only the public or default modifier, just like a non-inner class (outer class).
 * 
 * Enums can be declared as their own class, because an enum really is a special kind of class,
 * you can do more than just list the enumerated constant values.  You can add constructors, instance
 * variables, methods, and something really strange known as a 'constant specific class body' [like
 * an anonymous inner class].
 * 
 * @author Gibran E. Castillo
 *
 */
enum HotChocolateSize {
	/*
	 * It's not required that enum constants be in all caps, but borrowing from the Sun code
	 * convention that constants are named in caps, it's a good idea.
	 */
	BIG,
	HUGE,
	OVERWHELMING
}

/**
enums are not Strings or ints!  Each of the enumerated HotChocolateSize types are actually instances of HotChocolateSize.
In other words, BIG is of type HotChocolateSize.

The following is a conceptual example of how you can think about enums
class HotChocolateSize {
	private String enumName;
	private int enumIndex;
	public static final HotChocolateSize BIG = new HotChocolateSize("BIG", 0);
	public static final HotChocolateSize HUGE = new HotChocolateSize("HUGE", 1);
	public static final HotChocolateSize OVERWHELMING = new HotChocolateSize("OVERWHELMING", 2);
	
	// Constructs a HotChocolateSize instance
	public HotChocolateSize(String enumName, int enumIndex) {
		this.enumName = enumName;
		this.enumIndex = enumIndex;
	}
	
	public static void main(String[] args) {
		System.out.println(HotChocolateSize.BIG);  // this would display 'BIG'
	}
}

They're represented as static and final, which in the Java world, is thought of as a constant.  Also notice that each enum
value knows its index or position... in other words, the order in which enum values are declared matters.  You can think of
the HotChocolateSize enums as existing in an array of type HotChocolateSize.  You can iterate through the values of an enum
by invoking the 'values()' method on any enum type.
*/