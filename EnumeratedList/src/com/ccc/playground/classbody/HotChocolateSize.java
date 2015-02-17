package com.ccc.playground.classbody;

/**
 * 
 * 
 * @author Gibran E. Castillo
 *
 */
enum HotChocolateSize {
	// 8, 10 & 16 are passed to the constructor for ounces
	BIG(8),
	HUGE(10),
	OVERWHELMING(16) {
		/*
		 * Start a code block that defines the "body" for this constant.  It's known as a
		 * 'constant specific class body' that looks like an anonymous inner class and you
		 * use it when you need a particular constant [in this case OVERWHELMING] to override
		 * a method defined in the enum.
		 */
		
		/**
		 * Return the Lid Code
		 * @return
		 */
		public String getLidCode() {
			return "A";
		}
	};
	
	/**
	 * Constructs a HotChocolateSize enum instance.
	 * <> You can NEVER invoke an enum constructor directly [explicitly].  The enum constructor
	 *    is invoked automatically, with the arguments you define after the constant value.
	 *    For example, BIG(8) invokes the HotChocolateSize constructor that takes an int, passing
	 *    the int literal 8 to the constructor.  Behind the scenes, of course, you can imagine that
	 *    the String 'BIG' and int index 0 is also passed to the constructor, but we don't have to 
	 *    know or worry about those details.
	 * 
	 * <> You can define more than one argument to the constructor, and you can overload the enum
	 *    constructor overload the enum constructors, just as you can overload a normal class constructor.
	 * 
	 * @param ounces
	 */
	HotChocolateSize(int ounces) {
		this.ounces = ounces;
	}
	
	private int ounces;  // an instance variable
	
	public int getOunces() {
		return ounces;
	}
	
	/**
	 * This method is overridden by the OVERWHELMING constant
	 * @return
	 */
	public String getLidCode() {
		// The default value we want to return for HotChocolateSize constants.
		return "B";
	}
}