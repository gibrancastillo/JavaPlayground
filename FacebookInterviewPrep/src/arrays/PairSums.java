package arrays;

/**
 * Given a list of n integers arr[0..(n-1)], determine the number of different pairs of elements within it which sum to k.
 * 
 * If an integer appears in the list multiple times, each copy is considered to be different; that is, two pairs are considered
 * different if one pair includes at least one array index which the other doesn't, even if they include the same values.
 * 
 * Method Signature
 * int numberOfWays(int[] arr, int k)
 * 
 * Input
 * n is in the range [1, 100,000].
 * Each value arr[i] is in the range [1, 1,000,000,000].
 * k is in the range [1, 1,000,000,000].
 * 
 * Output
 * Return the number of different pairs of elements which sum to k.
 * 
 * Example
 * n = 5
 * k = 6
 * arr = [1, 2, 3, 4, 3]
 * output = 2
 * 
 * The valid pairs are 2+4 and 3+3
 * 
 * @author gibrancastillo
 *
 */
public class PairSums {

}


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


class Result {

    /*
     * Complete the 'getNumberOfOptions' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY priceOfJeans
     *  2. INTEGER_ARRAY priceOfShoes
     *  3. INTEGER_ARRAY priceOfSkirts
     *  4. INTEGER_ARRAY priceOfTops
     *  5. INTEGER dollars
     */

    public static long getNumberOfOptions(List<Integer> priceOfJeans, List<Integer> priceOfShoes, List<Integer> priceOfSkirts, List<Integer> priceOfTops, int dollars) {
        long options = 0;
        
        if(dollars != 0) {
            int[][] matrix = new int[4][3];
            
            int a = priceOfJeans.size();
            int b = priceOfShoes.size();
            int c = priceOfSkirts.size();
            int d = priceOfTops.size();
            
            int listIndex = 0;
            
            for(int row = 0; row < matrix.length; row++) {
                for(int col = 0; col < matrix[row].length; col++) {
                    maxtrix[row][col] = 
                }
            }
            
            
        }
        
        return options;
    }

}
public class Solution {