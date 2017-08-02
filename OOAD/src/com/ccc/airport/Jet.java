package com.ccc.airport;

/**
 * Inheritance. That’s when one class inherits behavior from another class, and can then change that behavior if needed.
 * 
 * Jet is a subclass of Airplane
 * Airplane is a superclass for Jet
 * 
 * 
 * Polymorphism (many forms or shapes) is closely related to inheritance. When one class inherits from another, then polymorphism allows a subclass to stand in for the superclass.
 * Polymorphism is when a subclass “stands in” for its superclass.
 * Polymorphism allows your applications to be more flexible, and less resistant to change.
 * 
 * @author gecasti
 *
 */
public class Jet extends Airplane {
	private static final int MULTIPLIER = 2;
	
	public Jet() {
		/*
		 * super is a special keyword.  It refers to the class (Airplane) that this class (Jet)
		 * has inherited behavior from.  So here, this calls the constructor of Airplane, Jet's superclass.
		 */
		super();
	}
	
	/**
	 * This subclass method overrides the superclass's method 
	 */
	public void setSpeed(int speed) {
		/*
		 * The subclass can change the behavior of its superclass, as well as call the
		 * superclass' methods.  This is called overriding the superclass' behavior
		 */
		super.setSpeed(speed * MULTIPLIER);
	}
	
	/**
	 * A subclass (Jet) can add its own methods to the methods it inherits from its
	 * superclass (Airplane).  In this case, we added the accelerate() to the subclass (Jet).
	 */
	public void accelerate() {
		/*
		 * You can call super.getSpeed() from Airplane (superclass), but you can also just
		 * call getSpeed(), just as if getSpeed() were a normal method defined in Jet.
		 */
		super.setSpeed(getSpeed() * 2);
	}
	
	/*
	 * Jet (subclass) also inherits the getSpeed() method from Airplane (superclass).  But since
	 * Jet (subclass) uses the same version of that method as Airplane (superclass), we don't need
	 * write any code to change that method.  Even though you can't see getSpeed() in Jet (subclass),
	 * it's perfectly OK to call getSpeed() on Jet (subclass).
	 */
}