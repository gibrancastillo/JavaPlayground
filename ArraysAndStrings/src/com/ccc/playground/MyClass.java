package com.ccc.playground;

public class MyClass {
	
	/**
	 * Check if the two strings have identical counts for each unique char
	 * 
	 * @param s
	 * @param t
	 * @return
	 */
	public static int isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return 0;
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
			
			//System.out.println("t.chartAt(" + i + "): " + t.charAt(i) + " --> c: " + c);
			
			if(letters[c] == 0) {
				// found a char in t that is not present in s.
				return 0;
			}
			
			--letters[c];
			
			if(letters[c] == 0) {
				++num_completed_t;
				
				if(num_completed_t == num_unique_chars) {
					// it�s a match if t has been processed completely
					if(i == t.length() - 1) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		}
		
		return 0;
	}
	
	public static void check_anagrams(String[] firstWords, String[] secondWords) {
        // Write your code here
        // To print results to the standard output you can use System.out.println()
        // Example: System.out.println("Hello world!");
		
		for(int i = 0; i < firstWords.length; i++) {
        	String word = firstWords[i];
			String wordPlay = secondWords[i];
        	int anagram = isAnagram(word, wordPlay);
        	System.out.println(anagram);
        }
    }
	
	public static void main(String[] args) {
		String[] firstWords = {"cinema", "host", "aba", "train"};
		String[] secondWords = {"iceman", "shot", "bab", "rain"};
		
		check_anagrams(firstWords, secondWords);
	}
	
	
	/*public static void check_braces(String[] expressions) {
        // Write your code here
        // To print results to the standard output you can use System.out.println()
        // Example: System.out.println("Hello world!");
		Set<E> braceSet = {'(' => ')', '[' => ']', '{' => '}'}
	    expressions.each do |expression|
	        chars = expression.chars.to_a
	        loop do
	            if match.values.include? chars.first
	                puts "0 - close bracket found before open bracket"
	                break
	            elsif match.keys.include? chars.last
	                puts "0 - open bracket found without closed bracket"
	            else
	                if chars.last == match[chars.first]
	                    chars.pop
	                    chars.shift
	                elsif chars[1] == match[chars.first]
	                    chars.shift
	                    chars.shift
	                elsif chars.last == match[chars[-2]]
	                    chars.pop
	                    chars.pop
	                else
	                    puts "0 - unmatched brackets"
	                    break
	                end
	            end
	            if chars.length == 0
	        		puts "1 - all brackets match"
	        		break
	        	end
	        end
	    end
	end
    }
	
	public static void main(String[] args) {
		String[] expressions = {")(){}", "[]({})", "([])", "{()[]}", "([)]"};
		
		check_braces(expressions);
	}*/	
}