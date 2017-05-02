package com.ccc.arrays;

public class ArrayStructure {
	private int[] theArray = new int[50];
	private int arraySize = 10;
	
	public void generateRandomArray() {
		for(int i = 0; i < arraySize; i++) {
			theArray[i] = (int) (Math.random() * 10) + 10;
		}
	}
	
	public void printArray() {
		System.out.println("----------");
		for(int i = 0; i < arraySize; i++) {
			System.out.print("| " + i + " | ");
			System.out.println(theArray[i] + " |");
			System.out.println("----------");
		}
	}
	
	public int getValueAtIndex(int index) {
		if(index < arraySize) return theArray[index];
		return 0;
	}
	
	public boolean doesArrayContainThisValue(int searchValue) {
		boolean isValueInArray = false;
		
		for(int i = 0; i < arraySize; i++) {
			if(theArray[i] == searchValue) {
				isValueInArray = true;
				return isValueInArray;
			}
		}
		
		return isValueInArray;
	}
	
	public void deleteIndex(int index) {
		if(index < arraySize) {
			// Start looping thru the array at the index provided
			for(int i = index; i < arraySize -1; i++) {
				// Move the array elements one value up 
				theArray[i] = theArray[i + 1];
			}
			
			// decrement array size, since we remove an element
			arraySize--;
		}
	}
	
	public void insertValue(int value) {
		if(arraySize < 50) {
			theArray[arraySize] = value;
			arraySize++;
		}
	}
	
	/**
	 * Linear Search
	 * We are going to look at every single index value in the entire array.
	 * For instance, if you wanted to find all the index or elements that have the value 11
	 * because linear search works best when you want to find all matches instead of just 
	 * one match.  For one match and no duplicate index values in your array then you would
	 * use the binary search algorithm. 
	 * @param value
	 * @return
	 */
	public String linearSearch(int value) {
		boolean isValueInArray = false;
		String indexsWithValue = "";
		
		System.out.print("The value " + value + " was found in the following index(es): ");
		
		for(int i = 0; i < arraySize; i++) {
			if(theArray[i] == value) {
				isValueInArray = true;
				System.out.print(i + " ");
				indexsWithValue += i + " ";
			}
		}
		
		if(!isValueInArray) {
			indexsWithValue = "None";
			System.out.println(indexsWithValue);
		}
		
		return indexsWithValue;
	}
	
	public static void main(String[] args) {
		// Generating/populating the Array
		ArrayStructure myArray = new ArrayStructure();
		myArray.generateRandomArray();
		myArray.printArray();
		
		// Searching the Array
		System.out.println(myArray.getValueAtIndex(3));
		System.out.println(myArray.doesArrayContainThisValue(18));
		
		// Deleting an element in the Array
		myArray.deleteIndex(4);
		myArray.printArray();
		
		// Insert an element in the Array
		myArray.insertValue(55);
		myArray.printArray();
		
		// Linear Search
		myArray.linearSearch(17);
	}
}