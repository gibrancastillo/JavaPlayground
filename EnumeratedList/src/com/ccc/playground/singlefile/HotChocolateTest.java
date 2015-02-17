package com.ccc.playground.singlefile;

class HotChocolateTest {
	public static void main(String[] args) {
		HotChocolate drink = new HotChocolate();
		
		// enum HotChocolateSize is outside the HotChocolate class.
		//drink.size = HotChocolateSize.BIG;
		
		/*
		 * enum HotChocolateSize is inside the HotChocolate class.
		 * Therefore, enclosing class name required.
		 */
		drink.size = HotChocolate.HotChocolateSize.BIG;
		
		System.out.println("[inside] drink.size: " + drink.size);
	}
}