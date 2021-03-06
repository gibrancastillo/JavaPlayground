package com.ccc.playground;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 * First, ask yourself, what does an additional buffer mean?  Can we use an additional array of constant size?
 * 
 * Algorithm�No (Large) Additional Memory:
 * 1. For each character, check if it is a duplicate of already found characters.
 * 2. Skip duplicate characters and update the non duplicate characters.
 * 
 * @author Gibran E. Castillo
 *
 */
public class RemoveDuplicateCharsAlgorithm {
	
	/**
	 * 
	 * @param str
	 */
	public void removeDuplicateChars(char[] str) {
		// Test Case:  Null string
		if(str == null) {
			return;
		}
		
		System.out.println("str= " + String.copyValueOf(str));
		
		int len = str.length;
		
		// Test Case:  String contains one character, no possible duplicates.
		if(len < 2) {
			return;
		}
		
		int tail = 1;
		
		// ++i Prefix or Pre-increment, increment i by 1 and then assign it
		for(int i = 1; i < len; ++i) {
			int j;
			
			// ++j Prefix or Pre-incremen, increment j by 1 and then assign it
			for(j = 0; j < tail; ++j) {
				System.out.println("str[" + i + "]: " + str[i] + " == str[" + j + "]: " + str[j]);
				
				if(str[i] == str[j]) {
					break;
				}
			}
			
			if(j == tail) {
				str[tail] = str[i];
				++tail;
			}
		}
		
		System.out.println("str= " + String.copyValueOf(str));
		
		str[tail] = 0;
		
		System.out.println("str= " + String.copyValueOf(str));
	}
	
	/**
	 * 
	 * @param str
	 */
	public void removeDuplicateCharsEff(char[] str) {
		// Test Case:  Null string
		if(str == null) {
			return;
		}
		
		System.out.println("str= " + String.copyValueOf(str));
		
		int len = str.length;
		
		// Test Case:  String contains one character, no possible duplicates.
		if(len < 2) {
			return;
		}
		
		// Create a boolean array of 256 elements with index 0 to 255 with all the values initialize to false.
		boolean[] hit = new boolean[256];
		hit[str[0]] = true;  // first character in the string could be a possible duplicate
		
		int tail = 1;
		
		// ++i Prefix or Pre-increment, increment i by 1 and then assign it
		for(int i = 1; i < len; ++i) {
			System.out.println("str[" + i + "]: " + str[i] + " == hit[" + str[i] + "]: " + hit[str[i]]);
			
			if(!hit[str[i]]) {
				str[tail] = str[i];
				++tail;
				hit[str[i]] = true;
			}
		}
		
		System.out.println("str= " + String.copyValueOf(str));
		
		str[tail] = 0;
		
		System.out.println("str= " + String.copyValueOf(str));
	}
	
	/**
	 * Test Cases:
	 * 1. String does not contain any duplicates, e.g.: abcd
	 * 2. String contains all duplicates, e.g.: aaaa
	 * 3. Null string
	 * 4. String with all continuous duplicates, e.g.: aaabbb
	 * 5. String with non-contiguous duplicate, e.g.: abababa
	 * 6. Empty string
	 * 
	 * @param agrs
	 */
	public static void main(String[] agrs) {
		String s = "helloiloveyou";
		char[] charArr = s.toCharArray();
		
		RemoveDuplicateCharsAlgorithm rdCharsAlgorithm = new RemoveDuplicateCharsAlgorithm();
		rdCharsAlgorithm.removeDuplicateChars(charArr);
		//rdCharsAlgorithm.removeDuplicateCharsEff(charArr);
	}
}