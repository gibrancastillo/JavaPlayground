package com.ccc.sorting;

public class SortingArrayStructure {
	private int[] theArray = new int[50];
	private int arraySize = 10;
	
	public void generateRandomArray() {
		for(int i = 0; i < arraySize; i++) {
			theArray[i] = (int) (Math.random() * 10) + 10;
		}
	}
	
	public void printHorzArray(int i, int j) {
		// For Linear Search Only
		for(int n = 0; n < 51; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < arraySize; n++) {
			System.out.print("| " + n + "  ");
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 51; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < arraySize; n++) {
			System.out.print("| " + theArray[n] + " ");
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 51; n++)System.out.print("-");
		
		System.out.println();
		// END OF FIRST PART
		
		
		// ADDED FOR BUBBLE SORT
		if(j != -1) {
			// ADD THE +2 TO FIX SPACING
			for(int k = 0; k < ((j * 5) + 2); k++)System.out.print(" ");
			
			System.out.print(j);
		}
		
		// THEN ADD THIS CODE
		if(i != -1) {
			// ADD THE -1 TO FIX SPACING
			for(int l = 0; l < (5 * (i - j) - 1); l++)System.out.print(" ");
			
			System.out.print(i);
		}
		
		System.out.println();
	}
	
	/**
	 * Linear Search:  Every index must be looked at
	 * We are going to look at every single index value in the entire array.
	 * For instance, if you wanted to find all the index or elements that have the value 11
	 * because linear search works best when you want to find all matches instead of just 
	 * one match.  For one match and no duplicate index values in your array then you would
	 * use the binary search algorithm. 
	 * @param value
	 * @return
	 */
	public String linearSearchForValue(int value) {
		boolean isValueInArray = false;
		String indexsWithValue = "";
		
		for(int i = 0; i < arraySize; i++) {
			if(theArray[i] == value) {
				isValueInArray = true;
				indexsWithValue += i + " ";
			}
			
			printHorzArray(i, -1);
		}
		
		if(!isValueInArray) {
			indexsWithValue = "None";
			System.out.print(isValueInArray);
		}
		
		System.out.print("The value " + value + " was found in the following index(es): " + isValueInArray);
		System.out.println();
		
		return indexsWithValue;
	}
	
	/**
	 * This bubble sort will sort everything from smallest to largest
	 */
	public void bubbleSort() {
		/**
		 * The outer loop starts at the end of the array int i = arraySize - 1 and as 'i' is decremented
		 * all the indexes greater than it are going to be sorted and we're going to do this
		 * as long as 'i' is greater than one and we are going to decrement 'i' and move towards zero.
		 */
		for(int i = arraySize - 1; i > 1; i--) {
			
			/**
			 * The inner loop starts at the beginning of the array int j = 0 and as 'j' is incremented is
			 * going to compare each value next to each other and if the value is greater it's simply going to swamp the values
			 */
			for(int j = 0; j < i; j++) {
				
				// To change bubble sort to descending change to "<"
				if(theArray[j] > theArray[j + 1]) {
					swapValues(j, j + 1);
					
					printHorzArray(i, j);
				}
				
				printHorzArray(i, j);
			}
		}
	}
	
	public void swapValues(int indexOne, int indexTwo) {
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp;
	}
	
	/**
	 * The Binary Search is quicker than the linear search because all the values are sorted. Because everything
	 * is sorted once you get to a number larger than what you are looking for you can stop the search.  Also you
	 * be able to start searching from the middle which speeds the search. It also works best when there are no duplicates
	 * 
	 * @param value
	 */
	public void binarySearchForValue(int value) {
		int lowIndex = 0;
		int highIndex = arraySize - 1;
		
		while(lowIndex <= highIndex) {
			int middleIndex = (highIndex - lowIndex) / 2;
			
			if(theArray[middleIndex] < value) lowIndex = middleIndex + 1;
			else if(theArray[middleIndex] > value) highIndex = middleIndex - 1;
			else {
				System.out.println("\nFound a Match for " + value + " at Index " + middleIndex);
				lowIndex = highIndex + 1;
			}
			
			printHorzArray(middleIndex, -1);
		}
	}
	
	/**
	 * Selection sort search for the smallest number in the array saves it in the
	 * minimum spot and then repeats searching through the entire array each time
	 */
	public void selectionSort() {
		for(int x = 0; x < arraySize; x++) {
			int minimum = x;
			
			for(int y = x; y < arraySize; y++) {
				// To change bubble sort to descending change to "<"
				if(theArray[minimum] > theArray[y]) {
					minimum = y;
				}
			}
			
			swapValues(x, minimum);
			
			printHorzArray(x, -1);
		}
	}
	
	/**
	 * The Insertion Sort is normally the best of the elementary sorts. Unlike the other sorts
	 * that had a group sorted at any given time, groups are only partially sorted here.
	 */
	public void insertionSort() {
		/**
		 * Search through the array and find a minimum and put it
		 * precisely into place skipping multiple different indexes
		 */
		for(int i = 1; i < arraySize; i++) {
			int j = i;
			int toInsert = theArray[i];  // the value we plan to insert somewhere else in the array
			
			while((j > 0) && (theArray[j - 1] > toInsert)) {
				theArray[j] = theArray[j - 1];
				j--;
				
				printHorzArray(i, j);
			}
			
			theArray[j] = toInsert;
			
			printHorzArray(i, j);
			
			System.out.println("\nArray[i] = " + theArray[i] + " Array[j] = " + theArray[j] + " toInsert = " + toInsert + "\n");
		}
	}
	
	public static void main(String[] args) {
		SortingArrayStructure mySortingArray = new SortingArrayStructure();
		mySortingArray.generateRandomArray();
		mySortingArray.printHorzArray(-1, -1);
		//mySortingArray.linearSearchForValue(11);
		//mySortingArray.bubbleSort();
		//mySortingArray.binarySearchForValue(11);
		//mySortingArray.selectionSort();
		mySortingArray.insertionSort();
	}
}