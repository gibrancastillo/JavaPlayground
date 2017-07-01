package com.ccc.session1;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * N light bulbs are connected by a wire. Each bulb has a switch associated with it, however due to faulty wiring, a switch also changes the state of all the bulbs to the right of 
 * current bulb.  Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs. You can press the same switch multiple times.
 * 
 * Note : 0 represents the bulb is off and 1 represents the bulb is on.
 * 
 * Example:
 * Input : [0 1 0 1]
 * Return : 4
 * 
 * Explanation :
 * 	press switch 0 : [1 0 1 0]
 * 	press switch 1 : [1 1 0 1]
 * 	press switch 2 : [1 1 1 0]
 * 	press switch 3 : [1 1 1 1]
 * 
 * @author gecasti
 *
 */
public class NBulbs {

	public static void main(String[] args) {
		int[] A = { 0, 1, 0, 1 };
		
		System.out.println("Input int array A: " + Arrays.toString(A));
		System.out.println("minNumSwitches(A): " + minNumSwitches(A));
		System.out.println("minNumSwitches1(A): " + minNumSwitches1(A));
	}
	
	public static int minNumSwitches(int[] A) {
		int state = 0, ans = 0;
		
		for(int i = 0; i < A.length; i++) {
			if(A[i] == state) {
				ans++;
				state = 1 - state;
			}
		}
		
		return ans;
	}
	
	public static int minNumSwitches1(int[] A) {
		boolean flipped = false;
		int ans = 0;
		
		for(int i = 0; i < A.length; i++) {
			if(flipped == false) {
				if(A[i] == 0) {
					ans++;
					flipped = true;
				}
			} else if(flipped == true) {
				if(A[i] == 1) {
					ans++;
					flipped = false;
				}
			}
			
		}
		
		return ans;
	}
	
    public int bulbs(ArrayList<Integer> a) {
        int state = 0;
        int switches = 0;
        
        for(int i = 0; i < a.size(); i++) {
            if(state == a.get(i)) {
                state = 1 - state;
                switches++;
            }
        }
        
        return switches;
    }
}