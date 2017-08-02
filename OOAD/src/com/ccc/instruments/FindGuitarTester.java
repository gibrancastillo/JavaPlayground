package com.ccc.instruments;

import java.util.Iterator;
import java.util.List;

/**
 * Flexibility: Without me, you’ll never actually make the customer happy. No matter how well-designed
 *              your application is, I’m the thing that puts a smile on the customer’s face.
 * 
 * Encapsulation: I’m all about reuse and making sure you’re not trying to solve a problem that someone else has already figured out.
 * 
 * Functionality: You use me to keep the parts of your code that stay the same separate from the parts that change;
 *                then it’s really easy to make changes to your code without breaking everything.
 * 
 * Design Pattern: Use me so that your software can change and grow without constant rework. I keep your application from being fragile.
 * 
 * 
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
 * @author gecasti
 *
 */
public class FindGuitarTester {
	
	public static void main(String[] args) {
		// Set up Gibran's guitar inventory
		Inventory inventory = new Inventory();
		initializeInventory(inventory);
		
		GuitarSpec whatCustomerLikes = new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER);
		List<Guitar> matchingGuitars = inventory.search(whatCustomerLikes);
		
		if(!matchingGuitars.isEmpty()) {
			System.out.println("<Customer's name>, you might like these guitars: ");
			
			for(Iterator<Guitar> i = matchingGuitars.iterator(); i.hasNext();) {
				Guitar guitar = i.next();
				GuitarSpec guitarSpec = guitar.getGuitarSpec();
				
				System.out.println("We have a " + guitarSpec.getBuilder() + " " + guitarSpec.getModel() + " " +
						guitarSpec.getType() + " guitar:\n     " + 
						guitarSpec.getBackWood() + " back and sides,\n     " + 
						guitarSpec.getTopWood() + " top.\n  You can have it for only $" + 
						guitar.getPrice() + "!\n  ----");
			}
		} else {
			System.out.println("Sorry, <Customer's name>, we have nothing for you.");
		}
	}
	
	private static void initializeInventory(Inventory inventory) {
	    inventory.addGuitar("11277", 3999.95, new GuitarSpec(Builder.COLLINGS, "CJ", Type.ACOUSTIC, 6, Wood.INDIAN_ROSEWOOD, Wood.SITKA));
	    inventory.addGuitar("V95693", 1499.95, new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER));
	    inventory.addGuitar("V9512", 1549.95, new GuitarSpec(Builder.FENDER, "Stratocastor", Type.ELECTRIC, 6, Wood.ALDER, Wood.ALDER));
	    inventory.addGuitar("122784", 5495.95, new GuitarSpec(Builder.MARTIN, "D-18", Type.ACOUSTIC, 6, Wood.MAHOGANY, Wood.ADIRONDACK));
	    inventory.addGuitar("76531", 6295.95, new GuitarSpec(Builder.MARTIN, "OM-28", Type.ACOUSTIC, 6, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK));
	    inventory.addGuitar("70108276", 2295.95, new GuitarSpec(Builder.GIBSON, "Les Paul", Type.ELECTRIC, 6, Wood.MAHOGANY, Wood.MAHOGANY));
	    inventory.addGuitar("82765501", 1890.95, new GuitarSpec(Builder.GIBSON, "SG '61 Reissue", Type.ELECTRIC, 6, Wood.MAHOGANY, Wood.MAHOGANY));
	    inventory.addGuitar("77023", 6275.95, new GuitarSpec(Builder.MARTIN, "D-28", Type.ACOUSTIC, 6, Wood.BRAZILIAN_ROSEWOOD, Wood.ADIRONDACK));
	    inventory.addGuitar("1092", 12995.95, new GuitarSpec(Builder.OLSON, "SJ", Type.ACOUSTIC, 12, Wood.INDIAN_ROSEWOOD, Wood.CEDAR));
	    inventory.addGuitar("566-62", 8999.95, new GuitarSpec(Builder.RYAN, "Cathedral", Type.ACOUSTIC, 12, Wood.COCOBOLO, Wood.CEDAR));
	    inventory.addGuitar("6 29584", 2100.95, new GuitarSpec(Builder.PRS, "Dave Navarro Signature", Type.ELECTRIC, 6, Wood.MAHOGANY, Wood.MAPLE));
	}
}