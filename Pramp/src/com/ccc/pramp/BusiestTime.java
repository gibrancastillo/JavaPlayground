package com.ccc.pramp;

import java.time.Instant;

/**
 * Busiest Time in The Mall
 * 
 * The Westfield Mall management is trying to figure out what the busiest moment at the mall was last year. 
 * You’re given data extracted from the mall’s door detectors. Each data point is represented as an integer 
 * array whose size is 3. 
 * 
 * Note that time is given in a Unix format called Epoch, which is a nonnegative integer holding the number 
 * of seconds that have elapsed since 00:00:00 UTC, Thursday, 1 January 1970.
 * 
 * @author gibran
 *
 */
public class BusiestTime {
	
	/**
	 * Given an array, data, of data points, write a function findBusiestPeriod that returns the time at which 
	 * the mall reached its busiest moment last year. The return value is the timestamp, e.g. 1480640292. 
	 * Note that if there is more than one period with the same visitor peak, return the earliest one.
	 * 
	 * @param data
	 * @return
	 */
	private static int findBusiestPeriod(int[][] data) {
		/*
		 * Time Complexity: O(N) since every data point in the input array gets visited only once in the loop.
		 * Space Complexity: O(1). The various auxiliary counters and the output, all use constant space.
		 */
		int currMax = 0, num_of_people = 0, busiestPeriod = 0;
		
		for(int i = 0; i < data.length; i++) {
			// update count or number of visitors in the mall
			if(data[i][2] == 1)
				// number of visitors that entered the mall
				num_of_people += data[i][1];
			else if(data[i][2] == 0)
				// number of visitors that exited the mall
				num_of_people -= data[i][1];
			
			// check for current and next data points with the same timestamp
	        if (i < data.length - 1 && data[i][0] == data[i+1][0])
	        	// The continue keyword is used to end the current iteration in a 
	        	// for loop (or a while loop), and continues to the next iteration.
	            continue;
			
			// update busiest period or maximum
			if(num_of_people > currMax) {
				currMax = num_of_people;
				busiestPeriod = data[i][0];
			}
		}
		
		return busiestPeriod;
	}

	public static void main(String[] args) {
		/*
		 * The values at indices 0, 1 and 2 are the timestamp, the count of visitors, and whether 
		 * the visitors entered or exited the mall (0 for exit and 1 for entrance), respectively. 
		 * Here’s an example of a data point: [ 1440084737, 4, 0 ].
		 * 
		 * Assume that the array data is sorted in ascending order by the timestamp. 
		 * Explain your solution and analyse its time and space complexities.
		 */
		int[][] input = { 
		//[ timestamp, visitors, in 1 or out 0 ]
			{1487799425, 14, 1},
			{1487799425, 4,  0},
			{1487799425, 2,  0},
			{1487800378, 10, 1},
			{1487801478, 18, 0},
			{1487801478, 18, 1},
			{1487901013, 1,  0},
			{1487901211, 7,  1},
			{1487901211, 7,  0}
		};
		
		int epoch = findBusiestPeriod(input);
		
		System.out.println("Busiest Period [Unix Format]: " + epoch);
		System.out.println("Busiest Period [Java Date]: " + Instant.ofEpochSecond(epoch));
	}
}