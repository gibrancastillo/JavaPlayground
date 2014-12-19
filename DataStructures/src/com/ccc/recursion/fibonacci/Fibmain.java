package com.ccc.recursion.fibonacci;

// Driver class for testing Fibonacci Number generators
class Fibmain {
	/*
	 * Two versions of a Fibonacci Number generator.  The fibi is iterative and executes the for loop n -2 times.
	 * The fibr is recursive (and not very efficient!), calling fibr a total more than Fib(n) times.
	 * 
	 * Why fibr is so much slower than fibi?
	 * 
	 * Both are static since there is no object that they can meaningfully act on.
	 * 
	 */
	
	
	static long fibi(int n) {    // Iterative Fibonacci generator
		Assert.notFalse((n>0) && (n<92), "Parameter out of range");
		long curr, prev;
		
		if((n == 1) || (n == 2)) return 1;
		
		curr = prev = 1;           // curr holds current Fib value
		
		for(int i=3; i<=n; i++) { // Compute next value
			curr = prev + curr;
			prev = curr - prev;      // prev holds previous Fib value
		}
		
		return curr;
	}
	
	static long fibr(int n) { // Recursive Fibonacci generator
		Assert.notFalse((n>0) && (n<92), "Parameter out of range");
		
		if((n == 1) || (n == 2)) return 1; // Base case
		
		return fibr(n-1) + fibr(n-2);       // Recursive call
	}
	
	// Main function for the Fibonacci Number generator driver
	public static void main(String args[]) {
		Assert.notFalse(args.length == 1, "Usage: Fibmain <size>");
		int val = Integer.parseInt(args[0]);
		
		for(int i=1; i<=val; i++) {
			System.out.print("Doing " + i + ": Iterative Version " + fibi(i));
			System.out.println("; Recursive Version " + fibr(i));
		}
		
		//System.out.println("Now do fibi for 100");
		//fibi(100); // This will fail Assert
	}
}