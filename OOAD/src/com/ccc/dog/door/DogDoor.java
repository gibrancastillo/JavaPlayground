package com.ccc.dog.door;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class DogDoor {
	private boolean open;
	
	/*
	 * Composition and Association (see Remote class for description).
	 * 
	 * The DogDoor class has an attribute named allowedBarks, which stores Bark objects.
	 * Multiplicity:  a List of Bark objects that can store an with unlimited number of Bark objects.
	 */
	private List<Bark> allowedBarks;
	
	public DogDoor() {
		this.allowedBarks = new LinkedList<Bark>();
		open = false;
	}
	
	public void addAllowedBark(Bark bark) {
		allowedBarks.add(bark);
	}
	
	/**
	 * This method represents an entire dog:  all the barking sounds that the dog can make.
	 * 
	 * @return
	 */
	public List<Bark> getAllowedBarks() {
		return allowedBarks;
	}
	
	public void open() {
		System.out.println("The dog door opens.");
		open = true;
		
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				close();
				timer.cancel();
			}
		}, 5000);
	}
	
	public void close() {
		System.out.println("The dog door closes.");
		open = false;
	}
	
	public boolean isOpen() {
		return open;
	}
}