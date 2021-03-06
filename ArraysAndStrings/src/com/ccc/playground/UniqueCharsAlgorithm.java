package com.ccc.playground;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 * 
 * @author Gibran E. Castillo
 *
 */
public class UniqueCharsAlgorithm {
	
	/**
	 * We can reduce our space usage a little bit by using a bit vector. We will assume, in the below code, that
	 * the string is only lower case �a� through �z�.  This will allow us to use just a single int.
	 * 
	 * Bit Manipulation
	 * And (&):    0 & 0 = 0    1 & 0 = 0    0 & 1 = 0    1 & 1 = 1
	 * Or  (|):    0 | 0 = 0    1 | 0 = 1    0 | 1 = 1    1 | 1 = 1
	 * Xor (^):    0 ^ 0 = 0    1 ^ 0 = 1    0 ^ 1 = 1    1 ^ 1 = 0
	 * 
	 * x << y means x shifted y bits to the left, example:  00011001 << 4 = 10010000
	 * 
	 * 
	 * @param str
	 * @return
	 */
	public boolean isUniqueCharsBitManipulation(String str) {
		int checker = 0;
		
		System.out.println("str= " + str);
		
		// ++i Prefix or Pre-increment, increment i by 1 and then assign it
		for(int i = 0; i < str.length(); ++i) {
			int val = str.charAt(i) - 'a';
			
			System.out.println("str.chartAt(" + i + "): " + str.charAt(i) + " --> val: " + val);
			System.out.println(checker + " & (1 << " + val + ")= " + (1 << val) + ") --> " + (checker & (1 << val)));
			
			if((checker & (1 << val)) > 0) {
				System.out.print("not a unique chars");
				
				return false;
			}
			
			checker |= (1 << val);
		}
		
		return true;
	}
	
	/**
	 * Create a boolean array of 256 elements with index 0 to 255 with all the values initialize to false.
	 * Time complexity is O(n), where n is the length of the string, and space complexity is O(n).
	 * 
	 * @param str
	 * @return
	 */
	public boolean isUniqueCharsCharSet(String str) {
		boolean[] char_set = new boolean[256];
		
		System.out.println("str= " + str);
		
		// i++ Postfix or Post-increment, assign i and then increment i by 1.
		for(int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			
			System.out.println("str.chartAt(" + i + "): " + str.charAt(i));
			System.out.println("char_set[" + val + "]: " + char_set[val]);
			
			if(char_set[val]) {
				return false;
			}
			
			// The decimal value of this char has already been seen once in the string.
			char_set[val] = true;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param agrs
	 */
	public static void main(String[] agrs) {
		UniqueCharsAlgorithm uniqueCharsAlgorithm = new UniqueCharsAlgorithm();
		String[] words = {"abcde", "hello", "apple", "kite", "padle"};
		
		for(String word : words) {
			//System.out.println(word + ": " + isUniqueCharsBitManipulation(word));
			System.out.println(word + ": " + uniqueCharsAlgorithm.isUniqueCharsCharSet(word));
		}
		
		/*for(int i = 0; i < words.length; i++) {
			String word = words[i];
			System.out.println(word + ": " + isUniqueCharsBitManipulation(word));
			System.out.println(word + ": " + isUniqueCharsCharSet(word))
		}*/
	}	
}