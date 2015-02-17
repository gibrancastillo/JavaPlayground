package com.ccc.playground.classbody;

class HotChocolate {
	HotChocolateSize size;  // each instance of HotChocolate has an enum
	
	public static void main(String[] args) {
		HotChocolate drink1 = new HotChocolate();
		drink1.size = HotChocolateSize.BIG; // enum HotChocolateSize is outside the HotChocolate class.
		
		HotChocolate drink2 = new HotChocolate();
		drink2.size = HotChocolateSize.OVERWHELMING;  // enum HotChocolateSize is outside the HotChocolate class.
		
		System.out.println("drink1.size.getOunces: " + drink1.size.getOunces() + "\n\n");
		
		/*
		 * You can iterate through the values of an enum by invoking the static 'values()' method on any enum type.
		 * It returns an array of the enum's values in the order they're declared.
		 */
		for(HotChocolateSize hcs : HotChocolateSize.values()) {
			System.out.println("Drink is " + hcs + " of size " + hcs.getOunces() + " with lid code " + hcs.getLidCode());
		}
	}
}