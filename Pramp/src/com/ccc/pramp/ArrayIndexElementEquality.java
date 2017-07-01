package com.ccc.pramp;

public class ArrayIndexElementEquality {
	
	static int indexEqualsValueSearch(int[] arr) {
		// your code goes
		if(arr == null)
			return -1;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == i)
				return i;
		}
		
		return -1;
	}
	
	//strictly monotonically increasing sequence 
	static boolean binarySearch(int[] arr, int key) {
		int low = 0;
		int high = arr.length - 1;
		
		while(high >= low) {
			int middle = (low + high) / 2;
			
			if(arr[middle] == key)
				return true;
			
			if(arr[middle] < key)
					low = middle + 1;
			
			if(arr[middle] > key)
				high = middle - 1;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
	    int[] arr = {-8,0,2,5};
	    System.out.println(indexEqualsValueSearch(arr));
	    
	    int[] arr2 = {-1,0,3,6};
	    System.out.println(indexEqualsValueSearch(arr2));
	    
	    System.out.println(binarySearch(arr, 2));
	}
}