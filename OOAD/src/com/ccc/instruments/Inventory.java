package com.ccc.instruments;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
	private List<Instrument> inventory;
	
	public Inventory() {
		inventory = new LinkedList<Instrument>();
	}
	
	public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
		Instrument instrument = new Instrument(serialNumber, price, spec);
		inventory.add(instrument);
	}
	
	public Instrument getInstrument(String serialNumber) {
		for(Iterator<Instrument> i = inventory.iterator(); i.hasNext(); ) {
			Instrument instrument = i.next();
			
			if (instrument.getSerialNumber().equals(serialNumber)) {
				return instrument;
			}
		}
		
		return null;
	}
	
	/**
	 * The Inventory class delegates comparisons to the InstrumentSpec class.
	 * 
	 * <> Delegation is the act of one object forwarding an operation to another object, to be performed on behalf of the first object.
	 * <> Delegation is when an object (Inventory) needs to perform a certain task, and instead of doing that task directly, it asks
	 * another object (InstrumentSpec) to handle the task (or sometimes just a part of the task).
	 * <> Delegation makes your code more reusable. It also lets each object worry about its own functionality, rather than spreading the
	 * code that handles a single object�s behavior all throughout your application.
	 * <> Delegation lets each object worry about equality (or some other task) on its own. This means your objects are more independent
	 * of each other, or more loosely coupled. Loosely coupled objects can be taken from one app and easily reused in another, because
	 * they�re not tightly tied to other objects� code.
	 * 
	 * <> Loosely coupled is when the objects in your application each have a specific job to do, and they do only that job. So the
	 * functionality of your app is spread out over lots of well-defined objects, which each do a single task really well.
	 * <> Loosely coupled applications are usually more flexible, and easy to change. Since each object is pretty independent of the other
	 * objects, you can make a change to one object�s behavior without having to change all the rest of your objects. So adding new features
	 * or functionality becomes a lot easier.
	 * 
	 * @param searchSpec
	 * @return
	 */
	public List<Instrument> search(InstrumentSpec searchSpec) {
		List<Instrument> matchingInstruments = new LinkedList<Instrument>();
		
		for(Iterator<Instrument> i = inventory.iterator(); i.hasNext(); ) {
			Instrument instrument = i.next();
			
			/*
			 * Delegation:  delegate comparing the two InstrumentSpec objects to the InstrumentSpec class,
			 * instead of the Inventory class handling the comparison directly.
			 */
			if(instrument.getSpec().matches(searchSpec))
				matchingInstruments.add(instrument);
		}
		
		return matchingInstruments;
	}
}