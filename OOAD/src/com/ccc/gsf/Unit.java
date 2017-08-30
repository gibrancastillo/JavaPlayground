package com.ccc.gsf;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Unit {
	private String type;
	private int id;
	private String name;
	private List<Weapon> weapons;
	private Map<String, Object> properties;
	
	public Unit(int id) {
		this.id = id;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Weapon> getWeapons() {
		return weapons;
	}
	
	public void addWeapon(Weapon weapon) {
		if(weapon == null) {
			weapons = new LinkedList<Weapon>();
		}
		
		weapons.add(weapon);
	}
	
	public void setProperty(String property, Object value)
	{
		if(properties == null) {
			properties = new HashMap<String, Object>();
		}
		
		properties.put(property, value);
	}
	
	public Object getProperty(String property) {
		if(properties == null) {
			return null;
		}
		
		return properties.get(property);
	}
	
	/*public Object getProperty(String property) {
		if(properties == null) {
			throw new RuntimeException("No properties for this Unit.");
		}
		
		Object value = properties.get(property);
		
		if(value == null) {
			throw new RuntimeException("Request for non-existent property.");
		} else {
			return value;
		}
	}*/
}