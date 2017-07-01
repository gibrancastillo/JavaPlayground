package com.ccc.pramp;

public class DecryptAsciiMessage {
	
	public static void main(String[] args) {
		System.out.println(decrypt("dnotq"));
		System.out.println(decrypt1("dnotq"));
	}
	
	/**
	 * Time Complexity: the function’s asymptotic time complexity is O(N), where N is the length of the input string. the loop that iterates
	 * through the letters in the input is performed N times. In the loop, almost every step is done in O(1), except for the loop that is supposed
	 * to move the decrypted letter back to the range of a-z. Theoretically, the secondStep may grow linearly with the size of the input. There are two ways to deal with this:
	 * 1.	Instead of secondStep itself, we may only keep its remainder after being divided by 26 (since we add/subtract multiples of 26 anyway,
	 *      the equation dec[N] = enc[N] - (secondStep[N-1] % 26)- 26M still holds, only for a different M). This way all values in every iteration are kept in a constant range.
	 * 2.	Note that since in practice this function is used only for words in the English language, the input is bounded and we therefore may ignore the growth of the secondStep anyway.
	 * 
	 * Space Complexity: the space usage is also O(N) since the output is the same size of the input, and we only keep the output and the second step in storage.
	 * 
	 * @param word
	 * @return
	 */
	static String decrypt(String word) {
		char[] letters = word.toCharArray();
		char[] decryptedString = new char[letters.length];
		
		// decrypting d.
		decryptedString[0] =  (char)(((int) letters[0]) - 1);
		
		for (int i = 1; i < letters.length; i++) {
			int asciiValue = (int) letters[i];
			asciiValue -= ((int) letters[i - 1]);
			
			while (asciiValue < 97)
				asciiValue += 26;
			
			decryptedString[i] = (char) asciiValue;
		}
		
		return String.valueOf(decryptedString);
	}
	
	static String decrypt1(String word) {
		if (word.length() == 0) return "";
		
		int secondStep = 1;
		char[] decryptedString = new char[word.length()];
		
		for (int i = 0; i < word.length(); i++) {
			int asciiValue = (int) word.charAt(i);
			asciiValue -= secondStep; // <==> asciiValue = asciiValue - secondStep;
			
			while(asciiValue < 97)
				asciiValue += 26;
			
			decryptedString[i] = (char) asciiValue;
			secondStep += asciiValue;
		}
		
		return String.valueOf(decryptedString);
	}
}