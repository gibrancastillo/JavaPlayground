package com.ccc.instruments;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * These are the common properties that can be use for both search request and instrument details.
 * Anytime you see duplicate code, look for a place to encapsulate!
 * 
 * The idea behind encapsulation is to protect information in one part of your application from the other parts of your application.
 * In its simplest form, you can protect the data in your class from the rest of your app by making that data private.
 * But sometimes the information might be an entire set of properties—like the details about an instrument—or even behavior—like
 * how a particular type of duck flies.When you break that behavior out from a class, you can change the behavior without the
 * class having to change as well. So, if you changed how properties were stored, you wouldn’t have to change your Instrument class at all,
 * because the properties are encapsulated away from Instrument.  That’s the power of encapsulation: by breaking up the different parts of
 * your app, you can change one part without having to change all the other parts. In general, you should encapsulate the parts of your
 * app that might vary away from the parts that will stay the same.
 * 
 * Once you’ve gotten your software to work like it’s supposed to, flexibility becomes a big deal. What if the customer wants to add
 * new properties or features to the app? If you’ve got tons of duplicate code or confusing inheritance structures in your app, making
 * changes is going to be a pain.  By introducing principles like encapsulation and good class design into your code, it’s easier to make
 * these changes, and your application becomes a lot more flexible.
 * 
 * @author gecasti
 *
 */
public class InstrumentSpec {
	/*
	 * Encapsulation:  separate what changes from what stays the same
	 * Since the properties in each instrument type are what varies; therefore, encapsulate those properties away
	 * from the InstrumentSpec class into the Map data structure class to store all properties.
	 * Besides, the behavior of each instrument (like guitar or mandolin) doesn't vary; therefore, you don't need subclasses for each instrument.
	 */
	private Map<String, Object> properties;
	
	public InstrumentSpec(Map<String, Object> properties) {
		if (properties == null) {
			this.properties = new HashMap<String, Object>();
		} else {
			this.properties = new HashMap<String, Object>(properties);
		}
	}
	
	public Object getProperty(String propertyName) {
		return properties.get(propertyName);
	}
	
	public Map<String, Object> getProperties() {
		return properties;
	}
	
	public boolean matches(InstrumentSpec otherSpec) {
		for (Iterator<String> i = otherSpec.getProperties().keySet().iterator(); i.hasNext(); ) {
			String propertyName = i.next();
			
			if(!properties.get(propertyName).equals(otherSpec.getProperty(propertyName))) {
				return false;
			}
		}
		
		return true;
	}
}