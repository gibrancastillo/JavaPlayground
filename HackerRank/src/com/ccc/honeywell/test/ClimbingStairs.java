package com.ccc.honeywell.test;

public class ClimbingStairs {
	
    /**
     * First approach    
     * @param n
     * @return
     */
    static long get_ways1(int n) {
    	int[] ways = new int[n + 1];
        return climb(ways, n);
    }
    
    static int climb(int []ways, int n) {
    	if(n < 0) return 0 ; 
    	if(n == 0) return 1; 
	
    	if(ways[n]!=0) return ways[n]; 
    	ways[n]=climb(ways, n-1)+climb(ways, n-2);
	
    	return ways[n]; 
	}
    
     
    /**
     * Second approach
     * Returns number of ways to reach s'th stair
     * @param s
     * @return
     */
    static long get_ways(int s) {
    	long M = 1000000007;
        return fib(s + 1) % M;
    }
    
    /**
     * A simple recursive program to find n'th fibonacci number
     * @param n
     * @return
     */
    static long fib(int n) {
       if (n <= 1)
          return n;
       
       return fib(n-1) + fib(n-2);
    }
    
	public static void main(String[] args) {
		System.out.println("" + get_ways(50));
	}
}