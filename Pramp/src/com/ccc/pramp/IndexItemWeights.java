package com.ccc.pramp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IndexItemWeights {
	
	/**
	 * Given a package with a weight limit limit and an array arr of item weights, implement a function getIndicesOfItemWights that finds two items
	 * whose sum of weights equals the weight limit limit. Your function should return a pair [i, j] of the indices of the item weights.  If such a
	 * pair doesn’t exist, return null.  Analyze the time and space complexities of your solution.
	 * 
	 * Example
	 * input:  arr = [4, 6, 10, 15, 16],  lim = 21
	 * output: [1, 3] since these are the indices of the weights 6 and 15 whose sum equals to 21
	 * 
	 * Constraints:
	 * •	[time limit] 5000ms
	 * •	[input] array.integer arr
	 * 		o	0 <= arr.length <= 100
	 * •	[input] integer limit
	 * •	[output] array.integer
	 * 
	 * • A common mistake is to assume that the input array is sorted. Make sure your peer doesn’t make that assumption.  Better yet, if your peer is following
	 *   any common “best practices” in technical interviews, they would know to ask whether they can make any assumptions in the beginning of their interview.
	 * • Another common mistake is to assume that the item weights in the input array are unique. This is not the case. A valid input could be, for instance, arr = [4,4] and limit = 8.
	 * • If your peer can’t think of a better solution than the brute force, ask them if they’re familiar with any data structures, i.e. a Map/Hash Table,
	 *   that enable lookups in constant time. Then ask how they can use this data structure to solve the problem efficiently.
	 * • Watch out for hashing an item weight before looking up in the map its complement.
	 * • For instance, for an item weight w that equals to limit/2 (whose complement is also limit/2), hashing the weight before looking up the
	 *   complement can “detect” a pair even when there is only one item whose weight is win arr.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[] {4, 6, 10, 15, 16};
		int[] output = getIndicesOfItemWights1(arr, 21);
		
		if(output != null)
			System.out.println("Indeces: " + Arrays.toString(output));
		else
			System.out.println("No pair [i, j] of the indices of the item weights exist.");
	}
	
	/**
	 * This is a classic case to use a map for an optimize solution. We traverse arr only once. For each weight w in arr we compute its complement limit - w
	 * and check whether that complement was hashed so far. If we find the complement in the map, we return a pair that consists of w’s and limit - w’s indices.
	 * if not, we hash w while using the weight as the hash key and its array index as the hash value. Even if the same weight is found more than once it doesn’t
	 * matter because at the time of the lookup we only need one item with that weight.
	 * 
	 * Time Complexity: going over the array only once, performing constant time work for each weight and assuming we have a good hash function with rare collisions, we get a linear O(N) time complexity.
	 * Space Complexity: we used a map as an auxiliary space. In the worst-case scenario, the space complexity of that map is O(N).
	 * 
	 * @param arr
	 * @param limit
	 * @return
	 */
	static int[] getIndicesOfItemWights(int[] arr, int limit) {
		System.out.println("Weight Limit is " + limit);
		System.out.println("List of item weights: " + Arrays.toString(arr));
		
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		
		// O(n)
		for(int index = 0; index < arr.length; index++) {
			
			if(!indexMap.containsKey(index))
				indexMap.put(arr[index], index);
			
			int complementWeight = limit - arr[index];
			
			if(indexMap.containsKey(complementWeight))
				return new int[] {(int) indexMap.get(complementWeight), index};
		}
		
		return null;
	}
	
	/**
	 * This is a classic case to use a map for an optimize solution. We traverse arr only once. For each weight w in arr we compute its complement limit - w
	 * and check whether that complement was hashed so far. If we find the complement in the map, we return a pair that consists of w’s and limit - w’s indices.
	 * if not, we hash w while using the weight as the hash key and its array index as the hash value. Even if the same weight is found more than once it doesn’t
	 * matter because at the time of the lookup we only need one item with that weight.
	 * 
	 * Time Complexity: going over the array only once, performing constant time work for each weight and assuming we have a good hash function with rare collisions, we get a linear O(N) time complexity.
	 * Space Complexity: we used a map as an auxiliary space. In the worst-case scenario, the space complexity of that map is O(N).
	 * 
	 * @param arr
	 * @param limit
	 * @return
	 */
	static int[] getIndicesOfItemWights1(int[] arr, int limit) {
		System.out.println("Weight Limit is " + limit);
		System.out.println("List of item weights: " + Arrays.toString(arr));
		
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		
		// O(n)
		for(int index = 0; index < arr.length; index++) {
			int w = arr[index];
			
			if(indexMap.get(limit - w) != null)
				return new int[] {(int) indexMap.get(limit - w), index};
			else
				indexMap.put(w, index);
		}
		
		return null;
	}
	
	/**
	 * The brute force solution consists of two nested loops. For every index i in the outer loop, we look for j (such that i < j < arr.length) in
	 * the inner loop that satisfies the condition arr[i] + arr[j] == lim.
	 * 
	 * Time Complexity: The time complexity of this algorithm in the worst case scenario is O(N^2).
	 * Space Complexity: ?
	 * 
	 * @param arr
	 * @param limit
	 * @return
	 */
	static int[] getIndicesOfItemWights2(int[] arr, int limit) {
		// your code goes here
		System.out.println("Weight Limit is " + limit);
		System.out.println("List of item weights: " + Arrays.toString(arr));
		
		//O(N^2)
		for(int i = 0; i < arr.length; i++) {
	      	for(int j = i + 1; j < arr.length; j++) {
	        	int sum = arr[i] + arr[j];
	        	
	        	if(sum == limit) {
	          		return new int[] {i, j};
	        	}
	      	}
		}
		
		return null;
	}
}