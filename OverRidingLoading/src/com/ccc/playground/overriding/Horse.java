package com.ccc.playground.overriding;

/**
 * Any time you have a class that inherits a method from a superclass, you have the opportunity to overriding.
 * 
 * @author Gibran E. Castillo
 *
 */
class Horse extends Animal {
	public void eat() {
		System.out.println("Horse eating hay, oats, and horse treats like carrots and apples.");
	}
}