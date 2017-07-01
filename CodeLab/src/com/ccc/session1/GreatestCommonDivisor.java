package com.ccc.session1;

/**
 * In mathematics, the greatest common divisor (gcd) of two or more integers, which are not all zero, is 
 * the largest positive integer that divides each of the integers. For example, the gcd of 8 and 12 is 4.
 * 
 * 
 * Given 2 non negative integers m and n, find gcd(m, n)
 * GCD of 2 integers m and n is defined as the greatest integer g such that g is a divisor of both m and n.
 * Both m and n fit in a 32 bit signed integer.
 * 
 * Example
 * 	m : 6
 * 	n : 9
 * 
 * 	GCD(m, n) : 3 
 * 
 * NOTE : DO NOT USE LIBRARY FUNCTIONS
 * 
 * @author gecasti
 *
 */
public class GreatestCommonDivisor {
	
	/**
	 * The remainder or modulus operator '%' returns the remainder of two numbers.
	 * For instance 10 % 3 is 1 because 10 divided by 3 leaves a remainder of 1.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Calculate Greatest Common Divisor");
		System.out.println("gcd(m:6, n:9) = " + gcd(6, 9));
		System.out.println("gcd1(m:6, n:9) = " + gcd1(6, 9));
		
		System.out.println("\n\nCalculate Least Common Multiple");
		System.out.println("lcm(m:6, n:9) = " + lcm(6, 9));
	}
	
	public static int gcd(int m, int n) {
		if(m < n) {
			return gcd(n, m);
		} else if(n == 0) {
			// corner case
			return m;
		} else {
			return gcd(m % n, n);
		}
	}
	
	/**
	 * Euclidean algorithm, or Euclid's algorithm, is an efficient method for computing the greatest common 
	 * divisor (GCD) of two numbers, the largest number that divides both of them without leaving a remainder.
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int gcd1(int m, int n) {
		return n == 0 ? m : gcd(n, m % n);
	}
	
	/**
	 * Given 2 non negative integers m and n, find lcm(m, n); in other words, write a method that returns the
	 * first number r that is divisible by both (e.g., the least common multiple).
	 * Both m and n fit in a 32 bit signed integer.
	 * 
	 * Example
	 * 	m : 6
	 * 	n : 9
	 * 
	 * 	LCM(m, n) : 18
	 * 
	 * NOTE : DO NOT USE LIBRARY FUNCTIONS
	 * 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int lcm(int m, int n) {
		return m * n / gcd(m, n);
	}
}