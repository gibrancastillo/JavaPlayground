package com.ccc.dog.door;

public class Remote {
	/*
	 * Association is a class relationship between two separate classes (Remote and DogDoor) which
	 * can be of any type say one to one, one to may etc. It joins two entirely separate entities.
	 * Association Types:
	 * <> Dependencies are weak class associations.  Class Remote uses class DogDoor; therefore, if
	 * you change the definition of DogDoor then class Remote needs to be aware of those changes.
	 * Therefore, class Remote has a dependency to class DogDoor.
	 * 
	 * <> Aggregations are strong shared associations.  A stronger version of class dependency, part-of
	 * relationship, meaning DogDoor is part of the Remote.  Both classes can exist on their own.
	 * Class Remote has class DogDoor as an attribute.  So class Remote actually has an instance variable
	 * or collection of class DogDoor.
	 * 
	 * <> Compositions are strong not-shared associations.  A stronger version of class aggregation; there
	 * is not also a part-of relationship but also a life cycle dependency between them, where one class
	 * cannot exist without the other, if class Remote dies then does class DogDoor.  Containing object (Remote)
	 * is responsible for the creation and life cycle of the contained object (DogDoor).  Class Remote owns
	 * class DogDoor as an attribute.
	 * 
	 * is a "has-a". You do composition by having an instance of another class C
	 * (DogDoor) as a field of your class (Remote), instead of extending class C (DogDoor).
	 * 
	 * <> Generalizations/Inheritance (is-a)
	 * Inheritance:  child class(es) inherit functionality from the parent class.
	 * Generalization:  same like inheritance with the addition that it generalizes how multiple classes can
	 * be generalize into one generic class; for instance, Child1/Child2 inherit and generalize into the Parent class. 
	 * 
	 * <> Self association like Linked List Node.  Don't allowed between abstract classes/interfaces to avoid looping
	 * because you can't instantiate them
	 * 
	 * Remote (source class) is associated to the DogDoor (target class) by reference to the door object.
	 * This means that the source class (Remote), has an attribute called door, of type DogDoor, the target class.
	 * 
	 * 
	 * <> Realizations are specialized relationships that show classes that inherit from abstract classes and/or 
	 * interface objects
	 * 
	 * Multiplicity:  door is not a List but a single DogDoor class; therefore, only one door object.
	 */
	private DogDoor door;
	
	public Remote(DogDoor door) {
		this.door = door;
	}
	
	public void pressButton() {
		System.out.println("Pressing the remote control button...");
		if (door.isOpen()) {
			door.close();
		} else {
			door.open();
		}
	}
}