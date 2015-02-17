package com.ccc.playground.singlefile;

class HotChocolate {
	enum HotChocolateSize {
		/*
		 * It's not required that enum constants be in all caps, but borrowing from the Sun code
		 * convention that constants are named in caps, it's a good idea.
		 */
		BIG,
		HUGE,
		OVERWHELMING
	}
	
	/*
	 * The Java language designers made it optional to put a semicolon at the end of the enum declaration
	 * when no other declarations for this enum follow
	 */
	
	HotChocolateSize size;
}