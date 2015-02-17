package com.ccc.playground.separate;

class HotChocolateTest {
	public static void main(String[] args) {
		HotChocolate drink = new HotChocolate();
		
		// enum HotChocolateSize is outside the HotChocolate class.
		drink.size = HotChocolateSize.BIG;
		
		System.out.println("[outside] drink.size: " + drink.size);
	}
}