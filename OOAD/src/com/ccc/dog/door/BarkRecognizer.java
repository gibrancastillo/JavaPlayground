package com.ccc.dog.door;

import java.util.Iterator;
import java.util.List;

public class BarkRecognizer {
	/*
	 * <> Composition is a "has-a". You do composition by having an instance of another class C
	 * (DogDoor) as a field of your class (BarkRecognizer), instead of extending class C (DogDoor).
	 * 
	 * <> Association is a relationship between two separate classes (BarkRecognizer and DogDoor) which
	 * can be of any type say one to one, one to may etc. It joins two entirely separate entities.
	 * 
	 * BarkRecognizer (source class) is associated to the DogDoor (target class) by reference to the door object.
	 * This means that the source class (BarkRecognizer), has an attribute called door, of type DogDoor, the target class.
	 * 
	 * Multiplicity:  door is not a List but a single DogDoor class; therefore, only one door object.
	 */
	private DogDoor door;
	
	public BarkRecognizer(DogDoor door) {
		this.door = door;
	}
	
	/**
	 * This method needs to see if the Bark object it receives matches one of the dog barks
	 * stored in the dog door (allowedBarks)
	 * @param bark
	 */
	public void recognize(Bark bark) {
		System.out.println("   BarkRecognizer: Heard a '" + bark.getSound() + "'");
		List<Bark> allowedBarks = door.getAllowedBarks(); // getting a whole list of Bark objects from the DogDoor object.
		
		for (Iterator<Bark> i = allowedBarks.iterator(); i.hasNext(); ) {
			Bark allowedBark = i.next();
			
			/*
			 * Delegation:  delegate comparing the two Bark objects to the Bark class,
			 * instead of the BarkRecognizer class handling the comparison directly.
			 */
			if(allowedBark.equals(bark)) {
				door.open();
				return;  // This makes sure we don't keep looping once we've found a match.
			}
		} 
		
		System.out.println("This dog is not allowed.");
	}
}