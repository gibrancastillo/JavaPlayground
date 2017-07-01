package com.ccc.pramp;

import java.util.Arrays;

/**
 * Ok, why don't you start coding stuff up?
 * Try and be as clear as possible in text
 * Unfortunately the connection is really bad.

 * I'll read the question and think out loud (type here) so you can see my thought process (OK)
 * I SHALL TYPE IN CAPS SO IT IS OBVIOUS WHO IS TYPING (NOT SHOUTING)    Okie
 *
 * slotsA is the availability of one person.  slots B is the availabilit of second person.  the meetingPlanner is
 * supposed to come up with the earliest time slot that works for both of them and the duration else return null. YES
 * 
 * IF MULTIPLE TIME SLOTS BOTH WORK, RETURN EARLIEST SLOT.   Okie (good to know, thank you)
 * 
 * Now I am trying to understand the slotsA/B arrays... thinking
 * This array element [10, 50] is a pair, 10 is the start time of slot and 50 is the end time of the slot, I don't fully understand this, almost 
 * there, thinking... does this mean my dur is 40?
 YES
 * SO FOR EXAMPLE, THE ANSWER FOR THIS IS [60,68] BECAUSE
 THE OVERLAP BETWEEN [10,50] AND [0,15] IS TOO SHORT (ONLY 5 MIN)
  AND 5 MIN < 8 MIN DURATION, SO YOU NEED TO KEEP SEARCHING
  FOR A BETTER INTERVAL TO USE (IF IT EXISTS).  Okie.  So minimum dur is 8
  YEAH NEED TO SEE IF THERE IS AN INTERVAL IN A AND B WITH
  OVERLAP AT LEAST 8
 * 
 * thinking and reading your comments again
 *                      40         60         70
 * input:  slotsA = [[10, 50], [60, 120], [140, 210]]
                        5         10
 *         slotsB = [[0, 15], [60, 70]]
 *     dur = 8
 * output: [60, 68]
 *
 * slots A have 40, 60, and 70.  Slots B have 5 and 10.  therefore, earliest time slot
 * is 60 (slot A [60, 120], slot B is [60, 70]), is this correct? YES
 * REading about disjointed, to see is this important or not...
 * IT HELPS SIMPLIFY WHAT YOU NEED TO DO - NOW YOU KNOW WE HAVE
 * SLOTS_A = [10, 50], [60, 120] AND NOT [10, 50], [40, 60] FOR EXAMPLE
 * Correct, but does not give me the clue to get 8, just for understanding the big picture.  Thx
 * 
 * Now back to how I get 8 and your question, tihink and readying your comments again...
 * THINKING ABOUT SORTING. 
 * CAN YOU USE THE FACT THAT THE SLOTS ARE SORTED BY START TIME TO HELP YOU? 
 * Yes
 * GREAT, SO GIVEN TWO SLOTS, HOW DO YOU FIGURE OUT THEIR
 * OVERLAP? SET TO (0,0) IF THEY ARE COMPLETELY DISJOINT
 * Use a Map, put slotA in Map and then check if slotB  is in map
 * DO YOU NEED A MAP? GIVEN (10, 50) AND (0, 15),
 HOW DO YOU FIGURE OUT THAT THEIR OVERLAP IS (10, 15)?  I see, a Map does not help
 *
 *
 * slotsA = [[10, 50], [60, 120], [140, 210]]
   slotsB = [[0, 15], [60, 70]]
   overlaps of A and B
   [10, 15], [10, 70]
   [60, 15], [60, 70]
   [140, 15], [140, 70], is this correct? 
   dur is given, which is 8 

   Earliest is [60, 70], not I replace 70 with 68, that is the dur of meeting, therefpre return [60, 68]
   YES

   second example returns null because the overalps that are good are less then dur time, correct? YES
   slotsA = [[10, 50], [60, 120], [140, 210]]
   slotsB = [[0, 15], [60, 70]]
   overlaps for A and B
   [10, 15], [10, 70]
   [60, 15], [6 0, 70]
   [140, 15], [140, 70]

   Working on code now, I need to cycle throught both arrays and create an overlap array, it will be sort

   DO YOU NEED TO ALLOCATE THE SPACE REQUIRED FOR AN OVERLAP ARRAY?
   CAN YOU DO THIS IN CONSTANT SPACE?

   Since we are running out of time, how about I sketch a solution? sure, I hope that is ok, no audio slow down everything
   I'll do my best to hurry since Iaw this before. 
 */
public class TimePlanner {
	static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
		int indexA = 0; // index of the slot we checking for overlap at slotsA
		int indexB = 0; // index of the slot we are checking for overlap at slotsB
		while (indexA < slotsA.length && indexB < slotsB.length) { // within bounds
			int[] slotA = slotsA[indexA];
			int[] slotB = slotsB[indexB];

			/*
			 * find the start time and end time of the overlap in both slots (could be negative) motivating example:
			 * slotA = [60, 120]
			 * slotB = [70, 80]
			 * 
			 * then if duration was 8, maxStartTime = 70, minEndTime = 80
			 * so duration 8 still fits in, YES!
			 */
			int overlapEndTime = Math.min(slotA[1], slotB[1]); 
			int overlapStartTime = Math.max(slotA[0], slotB[0]);

			if (overlapEndTime - overlapStartTime >= dur) {
				// have a solution
				int[] result = {overlapStartTime, overlapStartTime + dur};
				return result;
			} else if (slotA[1] < slotB[1]) { 
				/*
				 * slotA ends first, so if we want to see which slot for
				 * person A could work, we need to look at the next slot
				 */
				indexA++;
			} else {
				// slotB ends first, before slotA look at the next slot in B for potential solution
				indexB++;
			}
		}
		
		return null; // not found
	}

	public static void main(String[] args) {
		int[][] slotsA = {{10, 50}, {60, 120}, {140, 210}};
		int[][] slotsB = {{0, 15}, {60, 70}};

		System.out.println(Arrays.toString(meetingPlanner(slotsA, slotsB, 8)));
	}
}