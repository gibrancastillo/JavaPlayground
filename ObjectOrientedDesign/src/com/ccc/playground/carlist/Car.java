package com.ccc.playground.carlist;

public class Car extends Vehicle {
	private int year;
	private String make;
	private String model;
	private String vin;
	private double speed = 0.0;
	
	public Car(double speed) {
		this.speed = speed;
	}
	
	public Car(int year, String make, String model) {
		this.year = year;
		this.make = make;
		this.model = model;
	}
	
	public Car(int year, String make, String model, double speed) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.speed = speed;
	}
	
	public Car(int year, String make, String model, String vin) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.vin = vin;
	}
	
	public double accelerate(double speed) {
		this.speed = speed + 5.0;
		
		System.out.println("Car Speed Accelerated " + this.speed);
		
		return this.speed;
	}
	
	public double decelerate(double speed) {
		this.speed = speed - 5.0;
		
		System.out.println("Car Speed Decelerated " + this.speed);
		
		return this.speed;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getVin() {
		return vin;
	}
	
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}	
}