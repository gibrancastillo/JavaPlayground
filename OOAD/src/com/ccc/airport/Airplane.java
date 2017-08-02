package com.ccc.airport;

/**
 * 
 * @author gecasti
 *
 */
public class Airplane {
	/*
	 * Encapsulation is when you hide the implementation of a class in such a way that it is easy to use and easy to change.
	 * It makes the class act as a black box that provides a service to its users, but does not open up the code so someone can
	 * change it or use it the wrong way. Encapsulation is a key technique in being able to follow the Open-Closed principle.
	 * 
	 * Encapsulation is when you protect information in your code from being used incorrectly.  With encapsulated data,
	 * any calculation or checks that the class does on the data are preserved, since the data can't be accessed directly.
	 * So encapsulation does more than just hide information, it makes sure the methods you write to work with your data
	 * are actually used!
	 * 
	 * Encapsulation separates your data from your app’s behavior.  Then you can control how each part is used by the rest of your application.
	 */
	private int speed;
	
	public Airplane() {
		
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
}