package com.ccc.sorting;

public class SortingArrayStructure {
	private int[] theArray = new int[50];
	private int arraySize = 10;
	
	public void generateRandomArray() {
		for(int i = 0; i < arraySize; i++) {
			theArray[i] = (int) (Math.random() * 10) + 10;
		}
	}
	
	public int[] getTheArray() {
		return theArray;
	}
	
	public int getArraySize() {
		return arraySize;
	}
	
	/**
	 * Used to slow down calculations
	 */
	public void pauseAndUpdate() {
		try {
			Thread.sleep(700);
		} catch(InterruptedException ie) {
			ie.printStackTrace();
		}
	}
	
	/**
	 * Prints the Array on the screen in a grid
	 */
	public void printArray() {
		System.out.println("----------");
		for(int i = 0; i < arraySize; i++) {
			System.out.print("| " + i + " | ");
			System.out.println(theArray[i] + " |");
			System.out.println("----------");
		}
	}
	
	/**
	 * Gets value at provided index
	 * @param index
	 * @return
	 */
	public int getValueAtIndex(int index) {
		if(index < arraySize) return theArray[index];
		return 0;
	}
	
	/**
	 * Returns true or false if a value is in the Array
	 * @param searchValue
	 * @return
	 */
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
	
	/**
	 * Delete Array row for the index and move elements up		
	 * @param index
	 */
	public void deleteIndex(int index) {
		if(index < arraySize) {
			/*
			 * Start looping thru the array at the index provided.
			 * Overwrite the value for the supplied index and then keep overwriting
			 * every index that follows until you get to the last index in the array.
			 */
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
	 * 
	 * The time and space complexity of linear search is O(n), where n is the number of elements in the array.
	 * 
	 * http://bigocheatsheet.com/
	 * Time Complexity:  O(?) -> bad
	 * Space Complexity: O(?)  --> Constant
	 * 
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
	 * This bubble sort ascending will sort everything from smallest to largest
	 * 
	 * http://bigocheatsheet.com/
	 * Time Complexity:  O(n^2) -> bad
	 * Space Complexity: O(1)  --> Constant
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
	
	/**
	 * Bubble sort descending will sort everything from largest to smallest.
	 * 
	 * http://bigocheatsheet.com/
	 * Time Complexity:  O(n^2) -> bad
	 * Space Complexity: O(1)  --> Constant
	 */
	public void bubbleSortDescending() {
		/*
		 * i starts at the beginning of the Array
		 * As it is incremented all indexes less then it are sorted
		 */
		for(int i = 0; i < arraySize; i++) {
			
			/*
			 * The inner loop starts at the beginning of the array 1 index in more than i.
			 */
			for(int j = 1; j < arraySize - 1; j++) {
				/*
				 * Here we check if the 1st index is less than the next during the first run through.
				 * Then we just increase the indexes until they have all been checked.
				 */
				if(theArray[j - 1] > theArray[j])
					swapValues(j - 1, j);
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
	 * Recursive version 1
	 * 
	 * http://bigocheatsheet.com/
	 * Time Complexity:  O(log n) -> the best
	 * Space Complexity: Iterative O(1) --> Constant
	 *                   Recursive O(log n) -> the best
	 * 
	 * @param value
	 */
	public int recursiveBinarySearch(int lowIndex, int highIndex, int value) {
		if(lowIndex > highIndex) {
			/*
			 * Some people like to be careful, because 'int middleIndex = (lowIndex + highIndex) / 2;' can actually overflow middleIndex
			 * with Java integers; therefore, to avoid the Java integer overflow issue you can actually just do this 'int middleIndex = lowIndex + ((highIndex - lowIndex) / 2);'
			 */
			int middleIndex = lowIndex + ((highIndex - lowIndex) / 2);
			
			// If the element is present at the middle itself
			if(theArray[middleIndex] == value) return middleIndex;
			
			// Else if value we are searching for is smaller than the middle element value, then it can only be present in the left half of the array.
			else if(theArray[middleIndex] > value) return recursiveBinarySearchForValue(lowIndex, middleIndex - 1, value);
			//printHorzArray(middleIndex, -1);
			// Else the value we are searchin for is greater than the middle element value, then it canonly be present in the right half of the array.
			else return recursiveBinarySearchForValue(middleIndex + 1, highIndex, value);
		}
		
		// We reach here when the value we are searching for is not present in the array.
		return -1;
	}
	
	/**
	 * The Binary Search is quicker than the linear search because all the values are sorted. Because everything
	 * is sorted once you get to a number larger than what you are looking for you can stop the search.  Also you
	 * be able to start searching from the middle which speeds the search. It also works best when there are no duplicates
	 * Recursive version 2
	 * 
	 * http://bigocheatsheet.com/
	 * Time Complexity:  O(log n) -> the best
	 * Space Complexity: Iterative O(1) --> Constant
	 *                   Recursive O(log n) -> the best
	 * 
	 * @param value
	 */
	public int recursiveBinarySearchForValue(int lowIndex, int highIndex, int value) {
		if(highIndex >= 1) {
			/*
			 * Some people like to be careful, because 'int middleIndex = (lowIndex + highIndex) / 2;' can actually overflow middleIndex
			 * with Java integers; therefore, to avoid the Java integer overflow issue you can actually just do this 'int middleIndex = lowIndex + ((highIndex - lowIndex) / 2);'
			 */
			int middleIndex = lowIndex + (highIndex - lowIndex) / 2;
			
			// If the element is present at the middle itself
			if(theArray[middleIndex] == value) return middleIndex;
			
			// If value we are searching for is smaller than the middle element value, then it can only be present in the left half of the array.
			if(theArray[middleIndex] > value) return recursiveBinarySearchForValue(lowIndex, middleIndex - 1, value);
			//printHorzArray(middleIndex, -1);
			// Else the value we are searchin for is greater than the middle element value, then it canonly be present in the right half of the array.
			return recursiveBinarySearchForValue(middleIndex + 1, highIndex, value);
		}
		
		// We reach here when the value we are searching for is not present in the array.
		return -1;
	}
	
	/**
	 * The Binary Search is quicker than the linear search because all the values are sorted. Because everything
	 * is sorted once you get to a number larger than what you are looking for you can stop the search.  Also you
	 * be able to start searching from the middle which speeds the search. It also works best when there are no duplicates
	 * Iterative version 1
	 * 
	 * http://bigocheatsheet.com/
	 * Time Complexity:  O(log n) -> the best
	 * Space Complexity: Iterative O(1) --> Constant
	 *                   Recursive O(log n) -> the best
	 * 
	 * @param value
	 */
	public int binarySearch(int x) {
        int l = 0, r = arraySize - 1;
        
        while (l <= r) {
        	/*
			 * Some people like to be careful, because 'int middleIndex = (lowIndex + highIndex) / 2;' can actually overflow middleIndex
			 * with Java integers; therefore, to avoid the Java integer overflow issue you can actually just do this 'int middleIndex = lowIndex + ((highIndex - lowIndex) / 2);'
			 */
            int m = l + (r-l)/2;
            
            // Check if x is present at mid
            if (theArray[m] == x) return m;
            
            // If x greater, ignore left half
            if (theArray[m] < x) l = m + 1;
            
            // If x is smaller, ignore right half
            else
                r = m - 1;
        }
        
        // if we reach here, then element was not present
        return -1;
    }
	
	/**
	 * The Binary Search is quicker than the linear search because all the values are sorted. Because everything
	 * is sorted once you get to a number larger than what you are looking for you can stop the search.  Also you
	 * be able to start searching from the middle which speeds the search. It also works best when there are no duplicates
	 * Iterative version 2
	 * 
	 * http://bigocheatsheet.com/
	 * Time Complexity:  O(log n) -> the best
	 * Space Complexity: Iterative O(1) --> Constant
	 *                   Recursive O(log n) -> the best
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
	 * A variation of the binary search method to find out the number of rotations of a sorted array in O(log n) time using binary search.
	 * 
	 * Assumptions are that the array is sorted and has no duplicates
	 * 
	 * @param theArr
	 * @param arrayLength
	 * @return
	 */
	static int findSortedArrayRotationCount(int theArr[], int arrayLength) {
		int low = 0, high = arrayLength - 1;
		
		while(low <= high) {
			// case 1:  adfa
			if(theArr[low] <= theArr[high]) return low;
			
			int mid = (low + high) / 2;
			int next = (mid + 1) % arrayLength, prev = (mid + arrayLength - 1) % arrayLength;
			
			// case 2:  adfa
			if(theArr[mid] <= theArr[next] && theArr[mid] <= theArr[prev]) return mid;
			else if(theArr[mid] <= theArr[high]) high = mid - 1;  // case 3:  adfaf
			else if(theArr[mid] >= theArr[low]) low = mid + 1;    // case 4:  afaf
		}
		
		return -1;
	}
	
	/**
	 * A variation of the binary search method that does binary search on a circular sorted array with distinct elements.
	 * Finds the element in a circularly sorted array.
	 * Example - Array Elements:  12, 14, 18, 21, 3, 6, 8, 9
	 *           Array Indexes:    0   1   2   3  4  5  6  7
	 * 
	 * Assumptions are that the array is sorted and has no duplicates
	 * The following is a divide and conquer strategy.
	 * 
	 * @param theArr
	 * @param arrayLength
	 * @param value
	 * @return
	 */
	static int circularSortedArraySearch(int theArr[], int arrayLength, int value) {
		int low = 0, high = arrayLength - 1;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			// case 1:  The middle element in the array is the value we are searching for
			if(value == theArr[mid]) return mid; 
			
			/*
			 * The junction point or the pivot point, where we have the first element or the minimum element
			 * in the sorted sequence, in the example above is index 4, element value 3, 
			 * case 2:  The right half of the array is sorted, discard the left half.
			 */
			if(theArr[mid] <= theArr[high]) {
				if(value > theArr[mid] && value <= theArr[high])
					low = mid + 1;  // case 2A:  The value we are searching for is in the right sorted half of the array.
				else
					high = mid - 1; // case 2B:  The value we are searching for is in the left unsorted half of the array.
			} else {
				/*
				 * else --> theArr[low] <= theArr[mid]
				 * The first element in the array is less than or equal to the middle element in the array
				 * case 3:  The left half of the array is sorted, discard the right half.
				 */
				
				if(theArr[low] <= value && value < theArr[mid])
					high = mid - 1; // case 3A:  The value we are searching for is in the left sorted half of the array.
				else
					low = mid + 1;  // case 3B:  The value we are searching for is in the right unsorted half of the array.
			}
		}
		
		return -1;
	}
	
	/**
	 * Selection sort search for the smallest number in the array saves it in the
	 * minimum spot and then repeats searching through the entire array each time
	 * 
	 * http://bigocheatsheet.com/
	 * Time Complexity:  O(n^2) -> bad
	 * Space Complexity: O(1)  --> Constant
	 */
	public void selectionSort() {
		for(int x = 0; x < arraySize; x++) {
			int minimum = x;
			
			for(int y = x; y < arraySize; y++) {
				// To change selection sort to descending change to "<"
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
	 * 
	 * http://bigocheatsheet.com/
	 * Time Complexity:  O(n^2) -> bad
	 * Space Complexity: O(1)  --> Constant
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
		
		// ***************************************
		System.out.println("\n\n");
		int circularSortedArray1[] = {15, 22, 23, 28, 31, 38, 5, 6, 8, 10, 12};
		System.out.println("The sorted array is rotated " + findSortedArrayRotationCount(circularSortedArray1, circularSortedArray1.length) + " times.");
		
		int circularSortedArray2[] = {12, 14, 18, 21, 3, 6, 8, 9};
		System.out.println(circularSortedArraySearch(circularSortedArray2, circularSortedArray2.length, 8));
		// ***************************************
	}
}