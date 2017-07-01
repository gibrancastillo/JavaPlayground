package com.ccc.pramp;

public class SearchCircularSortedArray {
	
	/**
	 * binary search on a circular sorted array with distinct elements.
	 * @param A
	 * @param n
	 * @param x
	 * @return
	 */
	static int circularArraySearch(int A[], int n, int x) {
		int low = 0, high = n - 1;
		
		while(low <= high) {
			int mid = (low + high) / 2;
			
			if(x == A[mid]) return mid;  // case 1:  found x
			
			if(A[mid] <= A[high]) {
				// case 2:  right half is sorted
				if(x > A[mid] && x <= A[high])
					low = mid + 1;  // go searching in right sorted half
				else
					high = mid - 1; // go searching in left
			} else {
				if(A[low] <= x && x < A[mid])
					high = mid - 1; // go searching in left sorted half
				else
					low = mid + 1;  // go searching right
			}
			
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		int A[] = {12, 14, 18, 21, 3, 6, 8, 9};
		
		System.out.println(circularArraySearch(A, A.length, 8));
	}
}