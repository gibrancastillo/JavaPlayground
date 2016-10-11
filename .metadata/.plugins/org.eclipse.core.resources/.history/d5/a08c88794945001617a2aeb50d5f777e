package com.ccc.playground.carlist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * You have an inventory list of Cars. --> Data Structure:  HashMap?
 * Each has a year, make and model. --> Object Oriented Design:  Inheritance, Encapsulation and Polymorphism.
 * From the list, generate a count of each unique year/make/model combination. --> Algorithm
 * 
 * @author Gibran E. Castillo
 *
 */
public class CarInventory {
	public Map<String, Car> getMapCarList(List<Car> carList) {
		Map<String, Car> mapCarList = new HashMap<String, Car>();
		//Map<String, List<Car>> mapCarList = new HashMap<String, List<Car>>();
		
		/*System.out.println("\nThe following is the list of cars:");
		System.out.println("Year  Make    Model");*/
		
		System.out.println("carList= " + carList);
		
		for(int i = 0; i < carList.size(); i++) {
			Car c = carList.get(i);
			//System.out.println(c.getYear() + "  " + c.getMake() + "   " + c.getModel());
			String uniqueCar = c.getYear() + "" + c.getMake() + "" + c.getModel();
			System.out.println("unique car [key]: " + uniqueCar);
			
			mapCarList.put(uniqueCar, c);
		}
		
		return mapCarList;
	}
	
	public static void main(String[] args) {
		int year;
		String make, model, vin;
		boolean more = true;
		double speed = 0.0;
		Scanner keyboard = new Scanner(System.in);
		ArrayList<Car> carList = new ArrayList<Car>();
		
		//while(!keyboard.nextLine().equalsIgnoreCase("done")) {
		while(more) {
			System.out.print("Enter the car's made year: ");
			year = keyboard.nextInt();
			keyboard.nextLine();
			
			System.out.print("Enter the car's make company: ");
			make = keyboard.nextLine();
			
			System.out.print("Enter the car's model: ");
			model = keyboard.nextLine();
			
			System.out.print("Enter the car's vehicle identification number: ");
			vin = keyboard.nextLine();
			
			/*System.out.print("Enter the car's speed: ");
			speed = keyboard.nextDouble();*/
			
			carList.add(new Car(year, make, model, vin));
			
			System.out.print("Would you like to add another car to the list of cars (true/false)? ");
			more = keyboard.nextBoolean();
			System.out.println();
		}
		
		/*System.out.println("\nThe following is the list of cars:");
		System.out.println("Year  Make    Model");
		
		for(int i = 0; i < carList.size(); i++) {
			Car c = carList.get(i);
			year = c.getYear();
			make = c.getMake();
			model = c.getModel();
			
			System.out.println(year + "  " + make + "    " + model);
		}*/
		
		CarInventory carIntentory = new CarInventory();
		Map<String, Car> mapCarList = carIntentory.getMapCarList(carList);
		
		System.out.println("mapCarList= " + mapCarList);
		System.out.println("mapCarList.get(\"2001SubaruForester\")= " + mapCarList.get("2001SubaruForester"));
	}
}