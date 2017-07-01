package com.ccc.pramp;

public class PrimeNumbers {
	
	/**
	 * Write an isPrime method that takes an integer and returns true/false if the number is prime
	 * @param num
	 * @return
	 */
    static boolean isPrime(int num) {
        if(num < 2) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        
        // TIme O(sqrt(N))
        //for(int i = 2; i < num; i++)
        for(int i = 3; (i*i) < num; i+=2)
            if(num % i == 0)
                return false;
        
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
     * Example: The prime factors of 15 are 3 and 5 (3×5=15, and 3 and 5 are prime numbers).
     * 
     * @param num
     * @return
     */
    static String primeFactorization(int num) {
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
    
    static String primeFactorizationInterview(int num) {
        StringBuilder strbuilder = new StringBuilder();
        
        for(int factor = 2; factor * factor <= num; factor++) {
            while(num % factor == 0 && isPrime(factor)) {
            	strbuilder.append(factor);
            	
                num = num / factor;
                
                if(num != 1)
                	strbuilder.append("*");
            }
        }
        
        return strbuilder.toString();
    }
    
	public static void main(String[] args) {
		System.out.println(" " + isPrime(7));
		System.out.println(" " + primeFactorization(7));
	}
}

//7 
//9 
//4 
//2