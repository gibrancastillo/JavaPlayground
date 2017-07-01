package com.ccc.uber;

/**
 * Longest Increasing Subarray
 * Given an array, return the length of the longest increasing subarray.
 * For example, if the input is [1, 3, 2, 3, 4, 8, 7, 9], the output should be 5 because the longest increasing array is [1, 2, 3, 4, 8].
 * 
 * This question has been asked by Uber, Facebook recently (as the time of writing this post). Another reason I’d like to discuss this
 * problem is that many techniques used in this question can be re-used in other places.
 * 
 * Let us discuss Longest Increasing Subsequence (LIS) problem as an example problem that can be solved using Dynamic Programming.
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the
 * subsequence are sorted in increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * 
 * More Examples:
 * 
 * Input  : arr[] = {3, 10, 2, 1, 20}
 * Output : Length of LIS = 3
 * The longest increasing subsequence is 3, 10, 20
 * 
 * Input  : arr[] = {3, 2}
 * Output : Length of LIS = 1
 * The longest increasing subsequences are {3} and {2}
 * 
 * Input : arr[] = {50, 3, 10, 7, 40, 80}
 * Output : Length of LIS = 4
 * The longest increasing subsequence is {3, 7, 40, 80}
 * 
 * @author gecasti
 *
 */
public class LongestIncreasingSubsequence {
	static int max_ref; // stores the LIS
	
	/**
	 * Dynamic programming:  Recursive implementation NOT using memo-ization.
	 * 
	 * <> Dynamic programming is a technique for solving problems recursively and is applicable when the computations of the subproblems overlap.
	 *    Dynamic programming is a method for solving a complex problem by breaking it down into a collection of simpler problems, solving each of those problems just once, and storing their solutions.
	 * 
	 * <> Recursion is just a function calling itself.
	 * 
	 * <> Memoization is a term describing an optimization technique where you cache previously computer results, and return the cached result when the same computation is needed again.
	 * 
	 * We can see that there are many subproblems which are solved again and again. So this problem has Overlapping Substructure property
	 * and re-computation of same subproblems can be avoided by either using Memoization or Tabulation.
	 * 
	 * Note that the time complexity of this Dynamic Programming (DP) solution is O(n^2) 
	 * 
	 * @param arr
	 * @param n
	 * @return
	 */
	static int _lis(int arr[], int n) {
		// base case
		if(n == 1)
			return 1;
		
		// 'max_ending_here' is length of LIS ending with arr[n-1]
		int res, max_ending_here = 1;
		
		for(int i = 1; i < n; i++) {
			res = _lis(arr, i);
			
			if(arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here)
				max_ending_here = res + 1;
		}
		
		if(max_ref < max_ending_here)
			max_ref = max_ending_here;
		
		return max_ending_here;
	}
	
	static int lis(int arr[], int n) {
		max_ref = 1;
		
		_lis(arr, n);
		
		return max_ref;
	}
	
	public static void main(String[] args) {
		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		
		System.out.println("Length of LIS is " + lis(arr, arr.length));
	}
}