package com.ccc.playground.jukebox;

/**
 * 
 * 
 * @author Gibran E. Castillo
 *
 */
public class User {
	private long ID;
	private String name;
	
	public User(String name, long id) {
		this.name = name;
		ID = id;
	}
	
	public User getUser() {
		return this;
	}
	
	public static User addUser(String name, long id) {
		// pending
		
		return new User("Gibran", 1);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public long getID() {
		return ID;
	}
	
	public void setID(long id) {
		ID = id;
	}
}