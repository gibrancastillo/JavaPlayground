package com.ccc.playground;

import java.util.Random;

/**
 * Memory Footprint Analysis
 * =========================
 * Memory Footprint is how much memory a program uses.  Important in constrained environments such as mobile devices.
 * Memory usage of an algorithm; determine the amount of storage required for each item.
 * Memory footprint of an implementation; understand how the underlying data structures might be implemented.
 * Example:  Unicode string, which enables more compact representations of strings while making it more expensive to
 * perform many common string operations.
 * 
 * @author Gibran E. Castillo
 *
 */
public class MaximumArrayValue {
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MaximumArrayValue maxArrayValue = new MaximumArrayValue();
		int numbers[] = new int[900000];
		
		Random generator = new Random();
		
		for(int i = 0; i < numbers.length; i++) {
			numbers[i] = generator.nextInt(900000);
		}
		
		maxArrayValue.compareToMax(numbers, numbers.length);
		
		System.out.println("\n\n");
		
		maxArrayValue.compareToAll(numbers, numbers.length);
	}
	
	/*
	 * Returns the largest value in an array of non-negative integers
	 */
	int compareToMax(int array[], int n) {
		System.out.println("compareToMax");
		
		int curMax, i;
		long a, b, numOpsPerN = 0;
		
		// Make sure that there is at least one element in the array.
		if(n <= 0) {
			return -1;
		}
		
		// Set the largest number so far to the first array value.
		curMax = array[0];
		
		System.out.println("So far the first array value for curMax: " + curMax);
		System.out.println("**********************************");
		a = System.currentTimeMillis();
		
		// Compare every number with the largest number so far.
		for(i = 1; i < n; i++) {
			numOpsPerN++;
			
			if(array[i] > curMax) {
				curMax = array[i];
				//System.out.println("Is curMax: " + curMax);
			}
		}
		
		b = System.currentTimeMillis();
		System.out.println("Perfomrance - time in milliseconds: " + (b - a));
		
		/*
		 *  How many operations [comparing array value to another value] were performed for each n - n examination or O(n)
		 *  Linear time:  The time required to run the algorithm increases linearly with the number of input items.
		 *  Big-O is concern with the asymptotic running time: the limit of the running time as n gets very large.
		 */
		System.out.println("O(n) - numOpsPerN: " + numOpsPerN);
		System.out.println("**********************************");
		
		return curMax;
	}
	
	/**
	 * 
	 * @param array
	 * @param n
	 * @return
	 */
	int compareToAll(int array[], int n) {
		System.out.println("compareToAll()");
		
		int i, j;
		long a, b, numOpsPerN = 0;
		boolean isMax;
		
		// Make sure that there is at least one element in the array.
		if(n <= 0) {
			return -1;
		}
		
		System.out.println("**********************************");
		a = System.currentTimeMillis();
		
		for(i = n - 1; i > 0; i--) {
			isMax = true;
			//System.out.println("Is curMax: " + array[i]);
			
			for(j = 0; j < n; j++) {
				numOpsPerN++;
				
				// See if any value is greater.
				if(array[j] > array[i]) {
					isMax = false;  // current array[i] is not the largest value.
					break;
				}
			}
			
			// If isMax is true, no larger value exists; current array[i] is max.
			if(isMax) {
				break;
			}
		}
		
		b = System.currentTimeMillis();
		System.out.println("Perfomrance - time in milliseconds: " + (b - a));
		/*
		 *  How many operations [comparing array value to another value] were performed for each n - n examination or O(n)
		 *  Linear time:  The time required to run the algorithm increases linearly with the number of input items.
		 *  Big-O is concern with the asymptotic running time: the limit of the running time as n gets very large.
		 */
		System.out.println("O(n) - numOpsPerN: " + numOpsPerN);
		System.out.println("**********************************");
		
		return array[i];
	}
}