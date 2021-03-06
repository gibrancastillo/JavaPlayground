package com.ccc.ht.closedhashing;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A Hash Table data structure with a hashing function that handles collisions with Open Addressing using <<< Double Hashing >>>.
 * 
 * Hashing - The process of accessing a record by mapping a key value to a position in the table
 * 
 * Hash Function - The function that maps key values to positions in the table.  A good hash function minimizes the chance of collisions
 * occurring in the first place.  A good hash function will have the following properties:
 * 1. Efficiently computable, use only very fast operations.
 * 2. Make use of all info provided by key, thus maximizing the number of possible hash values
 * 3 Maps similar keys to very different hash values
 * 4. Hash values should uniformly distribute the keys (Each table position equally likely for each key) across table. 
 * 
 * Hash Table - The array that holds the records
 * Slots - A position (index) in the hash table.
 * Open Addressing - Also called Closed Hashing, all elements are stored in the hash table (array) itself.
 *                 <> Linear Probing, Quadratic Probing, Double Hashing, etc.
 * 
 * If we think of a Hash Table as an array then a hash function is used to generate a unique key for every item in the array.
 * The position the item goes in is known as the slot. Hashing doesn't work very well in situations in which duplicate data is stored.
 * Also it isn't good for searching for anything except a specific key. However, a Hash Table is a data structure that offers fast
 * insertion, deletion and searching capabilities.
 * 
 * From the String key you get the hash code (a.k.a hash value), from the hash code you get the index in the array.
 * 
 * ====================================================================================================================================
 * Clustering - once a collision occurs, you significally increase chances that another collision will occurs in the same slot or area
 *              This tendency of linear probing to cluster items together is known as Primary Clustering.
 *              Another technique that eliminates primary clustering is called Quadratic Probing
 *              
 * Quadratic Probing - the ith value in the probe sequence is (h(K) + i^2) mod M.  Thus, the probe function is p(K, i) = i^2 
 *                     Once again, two keys with different home positions will have diverge probe sequences.
 *                     
 * Example:  For a hash table of size M = 101, assume for keys k1 and k2 that h(k1) = 30 and h(k2) = 29.  The probe sequence for k1 is 30,
 * then 31, then 34, then 39.  The probe sequence for k2 is 29, then 30, then 33, then 38.  Thus, while k2 will probe to k1's home position
 * as its second choice, the two keys' probe sequence diverge immediately thereafter.
 * 
 * Pseudo-random probing p(K, i) = Perm[i - 1] and quadratic probing p(K, i) = i^2 eliminate primary clustering; however, if the hash
 * function causes a cluster to a particular home position, then the cluster remains under pseudo-random and quadratic probing.  This
 * problem is called secondary clustering.
 * 
 * 
 * <<< Double Hashing >>> - to avoid secondary clustering, we need to have the probe sequence be a function of the original key value, not the
 *                  home position.  A simple technique for doing this is to return to linear probing for the probe function, but to have
 *                  the constant be based on a second hash function.  Thus, the probe sequence would be of the form:  p(K, i) = i * h2(K)
 * 
 * Example:  Again, assume a hash table has size M = 101, and that there are three keys k1, k2 and k3 with h(k1) = 30, h(k2) = 29, h(k3) = 30,
 * h2(k1) = 2, h2(k2) = 5, and h2(k3) = 5.  Then, the probe sequence for k1 will be 30, 32, 34, 36, and so on.  The probe sequence for k2 will
 * be 28, 33, 38, 43, and so on.  The probe sequence for k3 will be 30, 35, 40, 45, and so on.  Thus, none of the keys share substantial
 * portions of the same probe sequence.  Of course, if a fourth key k4 has h(k4) = 28 and h2(k4) = 2, then it will follow the same probe
 * sequence as k1.  Pseudo-random or quadratic probing can be combined with double hashing to solve this problem.
 * 
 * A good implementation of double hashing should ensure that all of the probe sequence constants are relatively prime (prime numbers)
 * to the table size M.  One way is to select M to be a prime number, and have h2 return a value in the range 1 =< h2(K) =< M - 1.
 * Another way is to set M = 2^m for some value m and let h2 return an odd value between 1 and 2^m.
 * Using a prime number for the hash table (array) size helps minimize collisions.
 * ====================================================================================================================================
 * 
 * Time Complexity
 * A good hash table and a good hash function gives you a constant time O(1) but
 * linear time O(n) in the worst case scenario (lost of collisions, etc)
 * 
 * @author gecasti
 *
 */
public class DoubleHashing {
	String[] theArray;
	int arraySize;
	int itemsInArray = 0;
	
	public static void main(String[] args) {
		DoubleHashing theFunc = new DoubleHashing(31);  // 31 is a prime number
		
		String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",
				"235", "802", "900", "723", "699", "1", "16", "999", "890",
				"725", "998", "978", "988", "990", "989", "984", "320", "321",
				"400", "415", "450", "50", "660", "624" };
		
		// Demonstrate how data normally follows patterns and how a non-prime sized array can cause havoc (cry out, shout)
		String[] elementsToAdd3 = { "30", "60", "90", "120", "150", "180",
				"210", "240", "270", "300", "330", "360", "390", "420", "450",
				"480", "510", "540", "570", "600", "989", "984", "320", "321",
				"400", "415", "450", "50", "660", "624" };
		
		theFunc.hashFunction2(elementsToAdd2, theFunc.theArray);
		
		// theFunc.modThirty();
		theFunc.increaseArraySize(60);
		theFunc.displayTheStack();
		theFunc.fillArrayWithNeg1();
		theFunc.doubleHashFunc(elementsToAdd2, theFunc.theArray);
		theFunc.displayTheStack();
		theFunc.findKeyDblHashed("990");
	}
	
	// Outputs the matches that would put an item in index 0 if arraySize was 31
	public void modThirty() {
		for(int i = 1; i < 999; i++) {
			if(i % 30 == 0) {
				System.out.println(i);
			}
		}
	}
	
	/**
	 * isPrime method - takes an integer and returns true/false if the number is prime
	 * 
	 * A prime number can only be divided by 1 or itself, so it cannot be factored any further!
	 * 
	 * @param number
	 * @return
	 */
	public boolean isPrime(int number) {
		// Eliminate the need to check for even numbers
		if (number % 2 == 0)
			return false;
		
		// Check against all odd numbers after 2
		for(int i = 3; i * i <= number; i += 2) {
			if(number % i == 0)
				return false;
		}
		
		return true;
	}
	
	/**
     * Prime factorization - numbers 2 or greater
     * 9 = "3*3"
     * 21 = "3*7"
     * 2 = "2"
     * 6 = "2*3"
     * primeFactorization(int) => String representation of prime factorization
     * 
     * 
     * A prime number can only be divided by 1 or itself, so it cannot be factored any further!
     * Every other whole number can be broken down into prime number factors. It is like the
     * Prime Numbers are the basic building blocks of all numbers.
     * 
     * A factor that is a prime number: one of the prime numbers that, when multiplied, give the original number.
     * Example: The prime factors of 15 are 3 and 5 (3�5=15, and 3 and 5 are prime numbers).
     * 
     * @param num
     * @return
     */
    public String primeFactorization(int num) {
        StringBuilder strbuilder = new StringBuilder();
        
        for(int factor = 2; factor <= num / factor; factor++) {
            while(num % factor == 0 && isPrime(factor)) {
            	strbuilder.append(factor);
            	
                num = num / factor;
                
                if(num != 1)
                	strbuilder.append("*");
            }
        }
        
        if(num > 1)
        	strbuilder.append(num);
        
        return strbuilder.toString();
    }
	
	// Receives a number and returns the next prime number that follows
	public int getNextPrime(int minNumberToCheck) {
		for(int i = minNumberToCheck; true; i++) {
			if(isPrime(i))
				return i;
		}
	}
	
	// Increase array size to a prime number
	public void increaseArraySize(int minArraySize) {
		// Get a prime number bigger than the array requested
		int newArraySize = getNextPrime(minArraySize);
		
		// Move the array into a bigger array with the larger prime size
		moveOldArray(newArraySize);
	}
	
	public void moveOldArray(int newArraySize) {
		// Create an array that has all of the values of theArray, but no empty spaces
		String[] cleanArray = removeEmptySpacesInArray(theArray);
		
		// Increase the size for theArray
		theArray = new String[newArraySize];
		arraySize = newArraySize;
		
		// Fill theArray with -1 in every space
		fillArrayWithNeg1();
		
		// Send the values previously in theArray into the new larger array
		hashFunction2(cleanArray, theArray);
	}
	
	// Will remove all empty spaces in an array
	public String[] removeEmptySpacesInArray(String[] arrayToClean) {
		ArrayList<String> stringList = new ArrayList<String>();
		
		// Cycle through the array and if a space doesn't
		// contain -1, or isn't empty add it to the ArrayList
		for(String theString : arrayToClean)
			if(!theString.equals("-1") && !theString.equals(""))
				stringList.add(theString);
		
		String[] strArr = stringList.toArray(new String[stringList.size()]);
		
		System.out.println("\nClean Array: " + Arrays.toString(strArr) + "\n");
		
		return strArr;
	}
	
	public void doubleHashFunc(String[] stringsForArray, String[] theArray) {
		for(int n = 0; n < stringsForArray.length; n++) {
			// Store value in array index
			String newElementVal = stringsForArray[n];
			
			// Create an index to store the value in by taking the modulus
			int arrayIndex = Integer.parseInt(newElementVal) % arraySize;
			
			// Get the distance to skip down in the array after a collision occurs. We are doing this
			// rather than just going to the next index to avoid creating clusters
			int stepDistance = 7 - (Integer.parseInt(newElementVal) % 7);
			
			System.out.println("step distance: " + stepDistance);
			
			/*
			 * System.out.println("Modulus Index= " + arrayIndex + " for value "
			 * + newElementVal);
			 */
			// Cycle through the array until we find an empty space
			while(theArray[arrayIndex] != "-1") {
				arrayIndex += stepDistance;
				
				System.out.println("Collision Try " + arrayIndex + " Instead");
				
				// If we get to the end of the array go back to index 0
				arrayIndex %= arraySize;
			}
			
			theArray[arrayIndex] = newElementVal;
		}
	}
	
	// Returns the value stored in the Double Hashed Hash Table
	public String findKeyDblHashed(String key) {
		// Find the keys original hash key
		int arrayIndexHash = Integer.parseInt(key) % arraySize;
		
		// Find the keys original step distance
		int stepDistance = 5 - (Integer.parseInt(key) % 5);
		
		while(theArray[arrayIndexHash] != "-1") {
			if(theArray[arrayIndexHash] == key) {
				// Found the key so return it
				System.out.println(key + " was found in index " + arrayIndexHash);
				
				return theArray[arrayIndexHash];
			}
			
			// Look in the next index
			arrayIndexHash += stepDistance;
			
			// If we get to the end of the array go back to index 0
			arrayIndexHash %= arraySize;
		}
		
		// Couldn't locate the key
		return null;
	}
	
	public void hashFunction2(String[] stringsForArray, String[] theArray) {
		for(int n = 0; n < stringsForArray.length; n++) {
			String newElementVal = stringsForArray[n];
			
			// Create an index to store the value in by taking the modulus
			int arrayIndex = Integer.parseInt(newElementVal) % arraySize;
			
			/*
			 * 
			 * System.out.println("Modulus Index= " + arrayIndex + " for value "
			 * + newElementVal);
			 */
			// Cycle through the array until we find an empty space
			while(theArray[arrayIndex] != "-1") {
				++arrayIndex;
				
				System.out.println("Collision Try " + arrayIndex + " Instead");
				
				// If we get to the end of the array go back to index 0
				arrayIndex %= arraySize;
			}
			
			theArray[arrayIndex] = newElementVal;
		}
	}
	
	// Returns the value stored in the Hash Table
	public String findKey(String key) {
		// Find the keys original hash key
		int arrayIndexHash = Integer.parseInt(key) % arraySize;
		
		while(theArray[arrayIndexHash] != "-1") {
			if(theArray[arrayIndexHash] == key) {
				// Found the key so return it
				System.out.println(key + " was found in index " + arrayIndexHash);
				
				return theArray[arrayIndexHash];
			}
			
			// Look in the next index
			++arrayIndexHash;
			
			// If we get to the end of the array go back to index 0
			arrayIndexHash %= arraySize;
		}
		
		// Couldn't locate the key
		return null;
	}
	
	DoubleHashing(int size) {
		arraySize = size;
		theArray = new String[size];
		
		// Fill Array with -1 for each empty space
		fillArrayWithNeg1();
	}
	
	public void fillArrayWithNeg1() {
		Arrays.fill(theArray, "-1");
	}
	
	public void displayTheStack() {
		int increment = 0;
		int numberOfRows = (arraySize / 10) + 1;
		
		for(int m = 0; m < numberOfRows; m++) {

			increment += 10;

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {

				System.out.format("| %3s " + " ", n);

			}

			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {

				if (n >= arraySize)
					System.out.print("|      ");

				else if (theArray[n].equals("-1"))
					System.out.print("|      ");

				else
					System.out
							.print(String.format("| %3s " + " ", theArray[n]));

			}

			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();
		}
	}
}