package com.ccc.solution;

import java.util.Arrays;

/**
 * Sageworks coding assessment
 * 
 * Task 1
 * ======
 * Integer V lies strictly between integers U and W if U < V < W or if U > V > W.
 * 
 * A non-empty zero-indexed array A consisting of N integers is given.  A pair of indices (P, Q), where
 * 0 =< P < Q < N, is said to have adjacent values if no value in the array lies strictly between values
 * A[P] and A[Q].
 * 
 * For example, in array A such that:
 * A[0] = 0
 * A[1] = 3
 * A[2] = 3
 * A[3] = 7
 * A[4] = 5
 * A[5] = 3
 * A[6] = 11
 * A[7] = 1
 * 
 * the following pairs of indices have adjacent values:
 * (0, 7), (1, 2), (1, 4),
 * (1, 5), (1, 7), (2, 4),
 * (2, 5), (2, 7), (3, 4),
 * (3, 6), (4, 5), (5, 7),
 * 
 * For example, indices 4 and 5 have adjacent values because there is no value in array A that lies strictly
 * between A[4] = 5 and A[5] = 3; the only such value could be the number 4, and it is not present in the array.
 * 
 * Given two indices P and Q, their distance is defined as abs(A[P] - A[Q]), where abs(X) = X for X>= 0, and
 * abs(X) = -X for X < 0.  For example, the distance between indices 4 and 5 is 2 because (A[4] - A[5]) = (5 - 3) = 2.
 * For the example above, the function should return 0 because:
 * <> indices 1 and 2 are adjacent (next to each other), because the array does not contain any value that lies
 *    strictly between A[1] = 3 and A[2] = 3;
 * <> the distance between these indices is (A[1] - A[2]) = (3 - 3) = 0;
 * <> no other pair of adjacent indices that has smaller distance exists.
 * 
 * Complexity:
 * <> expected worst-case time complexity is O(N*log(N));
 * <> expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * 
 * Write a function:  class Solution { public int solution(int[] A); }
 * that, given a non-empty zero-indexed array A consisting of N integers, returns the minimum distance between
 * indices of this array that have adjacent values.  The function should return - 1 if the minimum distance is
 * greater than 100,000,000.  The function should return -2 if no adjacent indices exist.
 * 
 * Assume that:
 * N is an integer within the range [1..40,000];
 * each element of array A is an integer within the range [-2,147,483,648..2,147,483,647].
 * 
 * 
 * 
 * Task 2
 * ======
 * Given a table events with the following structure:
 * create table events (
 * 	sensor_id integer not null,
 * 	event_type integer not null,
 * 	value integer not null,
 * 	time timestamp unique not null
 * );
 * 
 * write an SQL query that, for each sensor event type (sensor_id, event_type), returns the most recent value (in terms of time).
 * The table should be ordered by sensor_id (in ascending order), event_type (in ascending order).
 * 
 * For example, given the following data:
 * sensor_id  | event_type  | value      | time
 * -----------|-------------|------------|---------------------
 * 2          | 2           | 5          | 2014-02-13 12:42:00
 * 2          | 4           | -42        | 2014-02-13 13:19:57
 * 2          | 2           | 2          | 2014-02-13 14:48:30
 * 3          | 2           | 7          | 2014-02-13 12:54:39
 * 2          | 3           | 54         | 2014-02-13 13:32:36
 * 
 * your query should return the following rowset:
 * sensor_id  | event_type  | value
 * -----------|-------------|--------------
 * 2          | 2           | 2
 * 2          | 3           | 54
 * 2          | 4           | -42      
 * 3          | 2           | 7  
 * 
 * SELECT events.sensor_id, events.event_type, events.value FROM events
 * JOIN
 * (
 * SELECT sensor_id, event_type, MAX(time) AS most_recent_time FROM events GROUP BY sensor_id, event_type
 * ) E2
 * ON events.time = E2.most_recent_time AND events.sensor_id = E2.sensor_id AND events.event_type = E2.event_type
 * ORDER BY events.sensor_id, events.event_type;
 * 
 * 
 * 
 * 
 * Task 3
 * ======
 * A zero-indexed array A consisting of N integers is given.  The elements of array A together represent a chain,
 * and each element represents the strength of each link in the chain.  We want to divide this chain into three
 * smaller chains.
 * 
 * All we can do is to break the chain in exactly two non-adjacent positions.  More precisely, we should break links
 * P, Q (0 < P < Q < N - 1, Q - P > 1), resulting in three chains [0, P - 1], [P + 1, Q - 1], [Q + 1, N - 1].  The
 * total cost of this operation is equal to A[P] + A[Q].
 * 
 * For example, consider array A such that:
 * A[0] = 5
 * A[1] = 2
 * A[2] = 4
 * A[3] = 6
 * A[4] = 3
 * A[5] = 7
 * 
 * We can choose to break the following links:
 * (1, 3):  total cost is 2 + 6 = 8
 * (1, 4):  total cost is 2 + 3 = 5
 * (2, 4):  total cost is 4 + 3 = 7
 * 
 * @author gecasti
 *
 */
public class Solution {
	
	/*static int solution(int[] A) {
		int N = A.length;
		int sum = A[0] - A[2];
		
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 2; j < N; j++) {
				if(A[i] + A[j] < sum)
					sum = A[i] + A[j];
			}
		}
		
		return sum;
	}*/
	
	static int solution(int[] A) {
		if(A == null)
			return -2;
		
		int N = A.length;
		
		if(N == 0 || N == 1)
			return -2;
		
		int sum = -2, i = 0, j = 0, k = 0;
		
		for(int pos = 0; pos < N - 1; pos++) {
			if(A[pos] < A[i]) {
				k = j;
				j = i;
				i = pos;
			} else if(A[pos] < A[j]) {
				k = j;
				j = pos;
			} else if(A[pos] < A[k])
				k = pos;
			if(Math.abs(i - j) > 1)
				sum = A[i] + A[j];
			else if(Math.abs(i - k) > 1)
				sum = A[i] + A[k];
			else
				sum = A[j] + A[k];
		}
		
		if(sum > 100000000) 
			return -1;
		
		return sum;
	}
	
	static int solution1(int[] A) {
		int N = A.length;
		Arrays.sort(A);
		int minDiff = A[1] - A[0];
		
		for(int i = 2; i != N; i++)
			minDiff = Math.min(minDiff, A[i] - A[i - 1]);
		
		return minDiff;
	}
	
	public static void main(String[] args) {
		int[] task1 = { 0, 3, 13, 7, 5, 3, 11, 1 };
		int[] task3 = { 5, 2, 4, 6, 3, 7 };
		
		System.out.println("Task 1:  " + solution(task1));
		System.out.println("Task 3:  " + solution(task3));
		
		System.out.println("\nTask 1:  " + solution1(task1));
		System.out.println("Task 3:  " + solution1(task3));
	}
}