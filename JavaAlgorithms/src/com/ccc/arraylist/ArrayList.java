package com.ccc.arraylist;

/**
 * Array-based list implementation.
 * 
 * @author Gibran E. Castillo
 *
 */
public class ArrayList implements List {
	// Default array list size.
	private static final int defaultSize = 10;
	
	private int maxListSize;      // Maximum size of array list.
	private int numElemInList;    // Actual number of Objects [Elements] in the array list.
	private int currentPosition;  // Position of current Object [Element]
	private Object[] listArray;   // Array holding list Objects [Elements].
	
	/**
	 * Construct an ArrayList with default size.
	 */
	public ArrayList() {
		setup(defaultSize);
	}
	
	/**
	 * Construct an ArrayList with user-specified size.
	 * 
	 * @param userSize an interger value that represents the maximum size of the array list.
	 */
	public ArrayList(int userSize) {
		setup(userSize);
	}
	
	/**
	 * Do actual initialization work.
	 * 
	 * @param msize
	 */
	private void setup(int msize) {
		maxListSize = msize;
		numElemInList = 0;
		currentPosition = 0;
		
		// Create a listArray object with msize
		listArray = new Object[msize];
	}
	
	/**
	 * Remove all Objects [Elements] from the array list by simply reinitialize values.
	 */
	public void clear() {
		numElemInList = 0;
		currentPosition = 0;
	}
	
	/**
	 * Insert Object at current position of the array list.
	 * 
	 * @param it the Object to be inserted at current position of the array list.
	 */
	public void insert(Object it) {
		if(numElemInList > maxListSize) {
			System.out.println("ArrayList is full!");
		}
		
		if(currentPosition <= 0 && currentPosition >= numElemInList) {
			System.out.println("Bad value for current position.");
		}
		
		for(int i = numElemInList; i > currentPosition; i--) {
			// Shift Objects [Elements] to make room for 'it'.
			listArray[i] = listArray[i - 1];
		}
		
		// Insert Object 'it' at current position of the array list.
		listArray[currentPosition] = it;
		
		/*
		 * <> PostFix or Post-Increment, causes the value of 'numElemInList' to be incremented by
		 *    one after the value of 'numElemInList' is used or evaluated in the expression (if any).
		 *    In this case, PostFix increments the size by one of the number of Objects [Elements] in the array list.
		 */
		numElemInList++;
	}
	
	/**
	 * Insert Object at end or tail of the array list.
	 * 
	 * @param it the Object to be inserted at end or tail of the array list.
	 */
	public void append(Object it) {
		if(numElemInList > maxListSize) {
			System.out.println("ArrayList is full!");
		}
		
		/*
		 * <> Insert Object [Element] at end or tail of the array list.
		 * <> PostFix or Post-Increment, causes the value of 'numElemInList' to be incremented by
		 *    one after the value of 'numElemInList' is used or evaluated in the expression (if any).
		 *    In this case, PostFix increments the size by one of the number of Objects [Elements] in the array list.
		 */
		listArray[numElemInList++] = it;
	}
	
	public Object remove() {
		if(isEmpty()) {
			System.out.println("Can't delete from an empty array list.");
		}
		
		if(!isCurrInList()) {
			System.out.println("No current element.");
		}
		
		// Hold removed Object [Element]
		Object it = listArray[currentPosition];
		
		for(int i = currentPosition; i < numElemInList - 1; i++) {
			// Shift Objects [Elements] down.
			listArray[i] = listArray[i + 1];
		}
		
		/*
		 * <> PostFix or Post-Increment, causes the value of 'numElemInList' to be decremented by
		 *    one after the value of 'numElemInList' is used or evaluated in the expression (if any).
		 *    In this case, PostFix decrements the size by one of the number of Objects [Elements] in the array list.
		 */
		numElemInList--;
		
		return it;
	}
	
	/**
	 * Set current position to first position or head of the array list.
	 */
	public void setFirst() {
		currentPosition = 0;
	}
	
	/**
	 * Move current position to next position of the array list.
	 */
	public void next() {
		currentPosition++;
	}
	
	/**
	 * Move current position to previous position of the array list.
	 */
	public void previous() {
		currentPosition--;
	}
	
	/**
	 * Return length of the array list, that is, the number of elements in the array list.
	 * 
	 * @return an integer value that represents the number of objects in the array list.
	 */
	public int length() {
		return numElemInList;
	}
	
	/**
	 * Set current position to specified position in the array list.
	 * 
	 * @param position an integer value that represents the specified position in the array list.
	 */
	public void setPosition(int position) {
		currentPosition = position;
	}
	
	/**
	 * Set current Object's value.
	 * 
	 * @param it the Object value to be set.
	 */
	public void setValue(Object it) {
		if(!isCurrInList()) {
			System.out.println("Not current object [element] in the array list.");
		}
		
		listArray[currentPosition] = it;
	}
	
	/**
	 * Return current Object's value.
	 * 
	 * @return the return Object value.
	 */
	public Object currentValue() {
		if(!isCurrInList()) {
			System.out.println("Not current object [element] in the array list.");
		}
		
		return listArray[currentPosition];
	}
	
	/**
	 * Return true if the array list is empty, false otherwise.
	 * 
	 * @return a boolean value that tells you if the array list is empty or not.
	 */
	public boolean isEmpty() {
		return numElemInList == 0;
	}
	
	/**
	 * Return true if current position is within the array list boundaries.
	 * 
	 * @return a boolean value that tells you if the current position is within the array list boundaries.
	 */
	public boolean isCurrInList() {
		return (currentPosition >= 0) && (currentPosition < numElemInList);
	}
	
	/**
	 * Print or display all array list's Objects [Elements]
	 */
	public void print() {
		if(isEmpty()) {
			System.out.println("[]");
		} else {
			System.out.println("[ ");
			
			for(setFirst(); isCurrInList(); next()) {
				System.out.println(currentValue() + " ");
			}
			
			System.out.println("]");
		}
	}
}