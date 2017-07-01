package com.ccc.stacks;

import java.util.Arrays;

/**
 * Stacks are used to complete a task and are soon after discarded
 * 
 * Stacks
 * 1. Allow only a single item to be added or removed at a time
 * 2. Stacks allow access to the last item inserted (LIFO:  Last In First Out)
 * 
 * This is an Array-Based Stack implementation, which is essentially a simplified
 * version of the array-based list.  The only important decision to be made is which
 * end of the array should represent the top of the stack.
 * <> One choice is to make the top be at position (index) 0 in the array.  In terms
 *    of array-based list functions, all insert (push) and remove (pop) operations would
 *    then be on the element in position (index) 0.  This implementation is inefficient,
 *    since now every push (insert) or pop (remove) operation will require that all 
 *    elements currently in the stack be shifted one position in the array, for a cost
 *    of O(n) if there are n elements.
 *<> The other choice is to have the top element be at position (index) n - 1 when there
 *   are n elements in the stack.  In other words, as elements are pushed (inserted) onto
 *   the stack, they are appended to the tail of the array-based list.  Member pop removes
 *   the tail element.  In this case, the cost for each push or pop operation is only O(1).
 *   <<< This is what was implemented in this array-based stack >>>
 * 
 * @author gecasti
 *
 */
public class TheStack {
	private String[] stackArray; // holds the items
	private int stackSize;       // number of items in stack, capacity.
	private int topOfStack = -1; // Sets stack String array elements as empty space
	
	TheStack(int size) {
		stackSize = size;
		stackArray = new String[stackSize];
		
		/*
		 * Assigns the String value of "-1" to every value in the array
		 * so I control what gets printed to screen. "-1" equals empty space
		 */
		Arrays.fill(stackArray, "-1");
	}
	
	public boolean isEmpty() {
		return topOfStack < 0; 
	}
	
	public boolean isFull() {
		return topOfStack == stackSize;
	}
	
	/**
	 * To add (insert) or push a value to the top of the stack
	 * @param input
	 */
	public void push(String input) {
		// Make sure you have enough room in the array or stack array to add or push a value
		if(topOfStack + 1 < stackSize) {
			topOfStack++;
			stackArray[topOfStack] = input;
		} else System.out.println("Sorry But the Stack is Full, avoid Stack Overflow.");
		
		displayTheStack();
		
		System.out.println("PUSH " + input + " Was Added to the Stack\n");
	}
	
	/**
	 * To get and remove (delete) or pop the value from the top of the stack
	 */
	public String pop() {
		if(topOfStack >= 0) {
			displayTheStack();
			
			System.out.println("POP " + stackArray[topOfStack] + " Was Removed From the Stack\n");
			
			// Just like in memory an item isn't deleted, but instead is just not available
			stackArray[topOfStack] = "-1"; // Assigns -1 so the value won't appear
			
			return stackArray[topOfStack--];
		} else {
			displayTheStack();
			
			System.out.println("Sorry But the Stack is Empty");
			
			return "-1";
		}
	}
	
	/**
	 * To see or view and get the value that is on top of the stack
	 * @return
	 */
	public String peek() {
		displayTheStack();
		
		System.out.println("PEEK " + stackArray[topOfStack] + " Is at the Top of the Stack\n");
		
		return stackArray[topOfStack];
	}
	
	public void pushMany(String multipleValues) {
		String[] tempString = multipleValues.split(" ");
		
		for(int i = 0; i < tempString.length; i++) {
			push(tempString[i]);
		}
	}
	
	public void popAll() {
		for(int i = topOfStack; i >= 0; i--) {
			pop();
		}
	}
	
	public void popDisplayAll() {
		String theReverse = "";
		
		for(int i = topOfStack; i >= 0; i--) {
			theReverse += stackArray[i];
		}
		
		System.out.println("The Reverse: " + theReverse);
		
		popAll();
	}
	
	public void displayTheStack() {
		for(int n = 0; n < 61; n++)
			System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < stackSize; n++)
			System.out.format("| %2s " + " ", n);
		
		System.out.println("|");
		
		for(int n = 0; n < 61; n++)
			System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < stackSize; n++) {
			if(stackArray[n].equals("-1")) System.out.print("|     ");
			else System.out.print(String.format("| %2s "+ " ", stackArray[n]));
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 61; n++)
			System.out.print("-");
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		TheStack theStack = new TheStack(10);
		
		theStack.push("10");
		theStack.push("17");
		theStack.push("13");
		
		// Look at the top value on the stack
		theStack.peek();
		
		// Remove values from the stack (LIFO)
		theStack.pop();
		theStack.pop();
		theStack.pop();
		
		// Add many to the stack
		theStack.pushMany("R E D R U M");
		
		// Remove all from the stack
		// theStack.popAll();
		
		// Remove all from the stack and print them
		theStack.popDisplayAll();
		theStack.displayTheStack();
	}
}