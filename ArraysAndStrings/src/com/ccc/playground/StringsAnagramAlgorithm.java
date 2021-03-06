package com.ccc.playground;

import java.util.Arrays;

/**
 * Write a method to decide if two strings are anagrams or not.
 * 
 * @author Gibran E. Castillo
 *
 */
public class StringsAnagramAlgorithm {
	
	/**
	 * Sort the two strings and then compare the values to see if they are equal.  If yes, then both strings are anagrams.
	 * 
	 * @param wordStr
	 * @param wordPlayStr
	 * @return
	 */
	public boolean isAnagramSort(String wordStr, String wordPlayStr) {
		if(wordStr.length() != wordPlayStr.length()) {
			return false;
		}
		
		System.out.println("word:" + wordStr + "  word play [anagram]: " + wordPlayStr);
		
		char[] wordChar = wordStr.toCharArray();
		Arrays.sort(wordChar);
		String sortedWordStr = new String(wordChar);
		
		char[] wordPlayChar = wordPlayStr.toCharArray();
		Arrays.sort(wordPlayChar);
		String sortedWordPlayStr = new String(wordPlayChar);
		
		System.out.println("Sorted word:" + sortedWordStr + "  sorted word play [anagram]: " + sortedWordPlayStr);
		
		/*
		 * In Java, when the == operator is used to compare 2 objects, it checks to see if the objects refer to the same place in memory.
		 * In other words, it checks to see if the 2 object names are basically references to the same memory location.
		 * 
		 * The equals method is defined in the Object class.  By default, the equals() method actually behaves the same as the == operator  
		 * meaning it checks to see if both objects reference the same place in memory.  The Java String class actually overrides the default equals()
		 * implementation in the Object class  and it overrides the method so that it checks only the values of the strings, not their locations in memory.
		 */
		return sortedWordStr.equals(sortedWordPlayStr);
	}
	
	/**
	 * Check if the two strings have identical counts for each unique char
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		
		// Create a primitive integers array of 256 elements with index 0 to 255 with all the values initialize to 0.
		int[] letters = new int[256];
		
		int num_unique_chars = 0;
		int num_completed_t = 0;
		
		char[] s_array = s.toCharArray();
		
		for(char c : s_array) {
			if(letters[c] == 0) {
				// ++i Prefix or Pre-Increment, increment i by 1 and then assign i
				++num_unique_chars;
			}
			
			/*
			 * Keep track of how many times you found a particular letter
			 * In other words, count number of each char in s.
			 */
			++letters[c];
		}
		
		// ++i Pretfix or Pre-Increment, increment i by 1 and then assign i.
		for(int i = 0; i < t.length(); ++i) {
			int c = (int) t.charAt(i);
			
			System.out.println("t.chartAt(" + i + "): " + t.charAt(i) + " --> c: " + c);
			
			if(letters[c] == 0) {
				// found a char in t that is not present in s.
				return false;
			}
			
			--letters[c];
			
			if(letters[c] == 0) {
				++num_completed_t;
				
				if(num_completed_t == num_unique_chars) {
					// its a match if t has been processed completely
					return i == t.length() - 1;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		StringsAnagramAlgorithm strAnagramAlgorithm = new StringsAnagramAlgorithm();
		String[][] wordPairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		
		for(String[] wordPair : wordPairs) {
			String word = wordPair[0];
			String wordPlay = wordPair[1];
			boolean anagram = strAnagramAlgorithm.isAnagram(word, wordPlay);
			//boolean anagram = strAnagramAlgorithm.isAnagramSort(word, wordPlay);
			System.out.println(word + ", " + wordPlay + ": " + anagram);
		}
	}
}