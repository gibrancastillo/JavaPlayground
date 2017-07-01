package com.ccc.test1;

public class FindTheNumber {
	
	static String findNumber(int[] arr, int k) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == k)
				return "YES";
		}
		
		return "NO";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
