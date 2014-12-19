package com.ccc.list.array;

/**
 * Array-based list implementation
 * @author gibranecastillo
 *
 */
class AList implements List {
	private static final int defaultSize = 10; // Default array size
	
	private int msize;              // Maximum size of list
	private int numInList;          // Actual number of Objects in list
	private int curr;               // Position of current Object
	private Object[] listArray;     // Array holding list Objects
	
	/**
	 * Constructor: use default size
	 */
	AList() {
		setup(defaultSize);
	}
	
	/**
	 * Constructor: user-specified size
	 * @param sz
	 */
	AList(int sz) {
		setup(sz);
	}
	
	/**
	 * Do actual initialization work
	 * @param sz
	 */
	private void setup(int sz) {
		msize = sz;
		numInList = curr = 0;
		
		// Create listArray
		listArray = new Object[sz];
	}
	
	/**
	 * Remove all Objects from list
	 */
	public void clear() {
		// Simply reinitialize values
		numInList = curr = 0;
	}
	
	/**
	 * Insert Object at current position
	 */
	public void insert(Object it) {
		Assert.notFalse(numInList < msize, "List is full");
		Assert.notFalse((curr >= 0) && (curr <= numInList), "Bad value for curr");
		
		for(int i = numInList; i > curr; i--) {
			// Shift Objects to make room
			listArray[i] = listArray[i - 1];
		}
		
		// Insert Object at current position of list
		listArray[curr] = it;
		
		// Increment list size
		numInList++;
	}
	
	/**
	 * Insert Object at tail of list
	 */
	public void append(Object it) {
		Assert.notFalse(numInList < msize, "List is full");
		
		// Increment list size and insert object at tail of list
		listArray[numInList++] = it;
	}
	
	/**
	 * Remove and return current Object
	 */
	public Object remove() {
		Assert.notFalse(!isEmpty(), "Can't delete from empty list");
		Assert.notFalse(isInList(), "No current element");
		
		// Hold removed Object
		Object it = listArray[curr];
		
		for(int i = curr; i < numInList - 1; i++) {
			// Shift elements down
			listArray[i] = listArray[i + 1];
		}
		
		// Decrement list size
		numInList--;
		
		return it;
	}
	
	/**
	 * Set curr to first position
	 */
	public void setFirst() {
		curr = 0;
	}
	
	/**
	 * Move curr to previous position
	 */
	public void prev() {
		curr--;
	}
	
	/**
	 * Move curr to next position
	 */
	public void next() {
		curr++;
	}
	
	/**
	 * Return length of list
	 */
	public int length() {
		return numInList;
	}
	
	/**
	 * Set curr to specified position
	 */
	public void setPos(int pos) {
		curr = pos;
	}
	
	/**
	 * Set current Object's value
	 */
	public void setValue(Object it) {
		Assert.notFalse(isInList(), "No current element");
		listArray[curr] = it;
	}
	
	/**
	 * Return current Object's value
	 */
	public Object currValue() {
		Assert.notFalse(isInList(), "No current element");
		return listArray[curr];
	}
	
	/**
	 * Return true if list is empty
	 */
	public boolean isEmpty() {
		return numInList == 0;
	}
	
	/**
	 * True if curr is within list
	 */
	public boolean isInList() {
		return (curr >= 0) && (curr < numInList);
	}
	
	/**
	 * Print all list's Objects
	 */
	public void print() {
		if(isEmpty()) {
			System.out.println("()");
		} else {
			System.out.print("( ");
			
			for(setFirst(); isInList(); next()) {
				System.out.print(currValue() + " ");
			}
			
			System.out.println(")");
		}
	}
}