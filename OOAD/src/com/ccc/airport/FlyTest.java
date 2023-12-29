package com.ccc.airport;

/**
 * Great Software in three way steps:
 * 1. Make sure your software does what the customer wants it to do.
 * =================================================================
 * This step focuses on the customer.  Make sure the application does what it's supposed to do FIRST.  So even if
 * the customers think of new ways to use the software, it doesn't break or give them unexpected results.
 * This is where getting good requirements and doing some analysis (an art of discovery) comes in.
 * 
 * 2. Apply basic OO principles to add flexibility.
 * ================================================
 * Once your software works, you can look for any duplicate code that might have slipped in, and make sure you are
 * using good OO programming techniques.  Great software is code that is Object-Oriented.  So there is not a bunch
 * of duplicate code, and each object pretty much controls its own behavior.  It's also easy to extend because your
 * design is really solid and flexible.
 * 
 * 3. Strive for a maintainable, reusable design.
 * ==============================================
 * Once you have a good object-oriented application that it does what the customer wants it to do (comply with steps 1 & 2)
 * then it's time to apply patterns (like MVC) and principles (like scalability) to make sure your software is ready to use
 * for years to come.
 * Great software is when you tried-and-true design patterns and principles.  You've kept your objects loosely coupled, and
 * your code open for extension (inheritance) but closed for modifications (encapsulation with immutable).  That also helps
 * make the code more reusable, so you don't have to rework everything to use parts of your application over and over again.
 * 
 * 
 * @author gecasti
 *
 */
public class FlyTest {
	public static void main(String[] args) {
		Airplane biplane = new Airplane();
		biplane.setSpeed(212);
		
		System.out.println("biplane speed: " + biplane.getSpeed());
		
		Jet boeing = new Jet();
		boeing.setSpeed(422);
		
		System.out.println("boeing speed: " + boeing.getSpeed());
		
		int x = 0;
		
		while(x < 4) {
			boeing.accelerate();
			System.out.println("boeing accelerated, new speed: " + boeing.getSpeed());
			
			if(boeing.getSpeed() > 5000)
				biplane.setSpeed(biplane.getSpeed() * 2);
			else
				boeing.accelerate();
			
			x++;
		}
		
		System.out.println("biplane speed: " + biplane.getSpeed());
		System.out.println("boeing speed: " + boeing.getSpeed());
	}
}