package com.ccc.playground;


/**
 * Write a method to replace all spaces in a string with �%20�.
 * 
 * @author Gibran E. Castillo
 *
 */
public class ReplaceSpacesAlgorithm {
	
	/**
	 * The algorithm is as follows:
	 * 1. Count the number of spaces during the first scan of the string.
	 * 2. Parse the string again from the end and for each character:
	 * 	��If a space is encountered, store �%20�.
	 * 	��Else, store the character as it is in the newly shifted location.
	 * 
	 * Using one char[]:  str only.
	 * 
	 * @param str
	 * @param length
	 */
	public void replaceSpaces(char[] str, int length) {
		int spaceCount = 0;
		int newLength;
		int i = 0;
		
		System.out.println("str= '" + String.copyValueOf(str) + "'");
		
		// i++ Postfix or Post-Increment, assign i value and then increment i by 1.
		for(i = 0; i < length; i++) {
			if(str[i] == ' ') {
				spaceCount++;
			}
		}
		
		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		
		System.out.println("newLength: " + newLength);
		System.out.println("str= '" + String.copyValueOf(str) + "'");
		
		/*
		 *  Starting point looks like this:
		 *  length = 9
		 *  newLength = 15
		 *  
		 *  0    1    2    3    4    5    6    7    8    9   10   11   12   13   14    15
		 * 'a', 'b', 'c', ' ', 'd', ' ', 'e', ' ', 'f', ' ', ' ', ' ', ' ', ' ', ' ', '\0'
		 *                                          ^
		 *                                          |
		 *                                   i = length - 1
		 */
		for(i = length - 1; i >= 0; i--) {
			if(str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			} else {
				str[newLength - 1] = str[i];
				newLength = newLength - 1;
			}
		}
		
		System.out.println("str= '" + String.copyValueOf(str) + "'");
	}
	
	/**
	 * The algorithm is as follows:
	 * 1. Count the number of spaces during the first scan of the string.
	 * 2. Parse the string again from the start and for each character:
	 * 	��If a space is encountered, store �%20�.
	 * 	��Else, store the character as it is in the newly shifted location.
	 * 
	 * Using two char[]:  str and newArray.
	 * 
	 * @param str
	 * @param length
	 * @return
	 */
	private char[] replaceSpaceInString(char[] str, int length) {
		int spaceCounter = 0;
		
		System.out.println("str= '" + String.copyValueOf(str) + "'");
		
		//First lets calculate number of spaces
		for(int i = 0; i < length; i++) {
			if(str[i] == ' ') 
				spaceCounter++;
		}
		
		//calculate new size
		int newLength = length + spaceCounter * 2;
		
		char[] newArray = new char[newLength + 1];
		newArray[newLength] = '\0';
		
		System.out.println("newLength= '" + newLength);
		System.out.println("str= '" + String.copyValueOf(str) + "'");
		
		int newArrayPosition = 0;
		
		/*
		 *  Starting point looks like this:
		 *  length = 12
		 *  newLength = 18
		 *  
		 *  0    1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17   18
		 * 'a', 'b', 'c', 'd', '', 'e', 'f', 'g ', ' ', 'h', ' ', 'j', ' ', ' ', ' ',' ', ' ', ' ', '\0'
		 *  ^
		 *  |
		 *  i = 0
		 */
		for(int i = 0; i < length; i++) {
			if (str[i] == ' ') {
				newArray[newArrayPosition] = '%';
				newArray[newArrayPosition + 1] = '2';
				newArray[newArrayPosition + 2] = '0';
				newArrayPosition = newArrayPosition + 3;
			} else {
				newArray[newArrayPosition] = str[i];
				newArrayPosition++;
			}
		}
		
		System.out.println("str= '" + String.copyValueOf(newArray) + "'");
		
		return newArray;
	}
	
	/**
	 * Use the replaceAll(ReGex, replacement) in the String class.
	 * 
	 * @param str
	 */
	public void replaceAllSpaces(String str) {
		System.out.println("str= '" + str + "'");
		str = str.replaceAll(" ", "%20");
		System.out.println("str= '" + str + "'");
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "abc d e f";
		char[] charArr = new char[str.length() + 3 * 2 + 1];
		
		System.out.println("charArr.length= " + charArr.length + "  str.length()= " + str.length());
		
		// i++ Postfix or Post-Increment, assign i value and then increment i by 1.
		for(int i = 0; i < str.length(); i++) {
			charArr[i] = str.charAt(i);
		}
		
		ReplaceSpacesAlgorithm replaceSpacesAlgorithm = new ReplaceSpacesAlgorithm();
		replaceSpacesAlgorithm.replaceSpaces(charArr, str.length());
		
		System.out.println();
		
		char[] array = {'a','b','c','d',' ','e','f','g',' ','h',' ','j'};
		replaceSpacesAlgorithm.replaceSpaceInString(array, array.length);
	    //System.out.println(replaceSpaceInString(array, array.length));
		
		System.out.println();
		
		String str2 = "abc d e f";
		replaceSpacesAlgorithm.replaceAllSpaces(str2);
	}
}