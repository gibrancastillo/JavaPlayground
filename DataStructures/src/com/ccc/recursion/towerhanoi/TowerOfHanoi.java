package com.ccc.recursion.towerhanoi;

import java.io.*;

/**
 * The <code>TowerOfHanoi</code> class is a lightweight class solves 'The Tower of Hanoi' puzzle with a recursive algorithm.
 * The Tower of Hanoi was invented by the French mathematician Edouard Lucas in 1883.
 * 1.  Problem Hanoi(N):  Move the N disks from peg or pole 1 to peg or pole 2.
 * 2.  Problem Hanoi(N):  Move the N disks from peg or pole 1 to peg or pole 3.
 * Tower of Hanoi Rules:
 * - You can only move one disk at a time from any peg or pole to any othe peg or pole, and 
 * - You may not stack a smaller disk on top of a larger disk.
 * 
 * @author Gibran E Castillo
 *
 */
public class TowerOfHanoi {
	// Count the number of moves
	static int counter = 1;
	
	/**
	 * Do and count a move by printing the action
	 * @param disk an integer value that represents the number of rings or disks.
	 * @param source a Pole object that represents the source or leftmost pole.
	 * @param dest a Pole object that represents the destination (middle or rightmost) pole.
	 */
	static void move(int disk, Pole source, Pole dest) {
		System.out.println("Move # " + counter + " - Disk " + disk + ": move from pole " + source + " to pole " + dest);
		counter++;
	}
	
	/**
	 * The Tower of Hanoi method moves n rings or disks from the leftmost pole [source] to the destination pole [dest]
	 * in a series of steps.  This is a accomplish with a recursive algorithm:  First, there must be a base case 
	 * (what to do if there is only one ring or disk) so that the recursive process will not go on forever.  Second,
	 * the recursive call to MoveTower can only be used to solve a smaller problem, and then only one of the proper.
	 * 
	 * @param disk an integer value that represents the number of rings or disks.
	 * @param source a Pole object that represents the source or leftmost pole in the original call of MoveTower.
	 * @param dest a Pole object that represents the destination (middle or rightmost) pole in the original call of MoveTower.
	 * @param spare a Pole object that represents the temporary (middle or rightmost) pole in the original call of MoveTower.
	 */
	static void MoveTower(int disk, Pole source, Pole dest, Pole spare) {
		System.out.println("MoveTower(" + disk + ", " + source + ", " + dest + ", " + spare + ")");
		
		if (disk == 0) {
			// Base case
			move(disk, source, dest);
		} else {
			MoveTower(disk - 1, source, spare, dest); // Recursive call: n-1 rings
			move(disk, source, dest);                 // Move bottom disk to goal
			MoveTower(disk - 1, spare, dest, source); // Recursive call: n-1 rings
		}
	}
	
	// Main function for TOH driver
	public static void main(String args[]) throws IOException {
		Assert.notFalse(args.length == 1, "Usage: TOHmain <size>");
		
		// Read in number of disks
		int disks = Integer.parseInt(args[0]);
		
		System.out.println("**************************************");
		System.out.println("* Move " + (disks + 1) + " disks from pole A to pole B *");
		System.out.println("**************************************");
		
		Pole start = new Pole("A");
		Pole goal = new Pole("B");
		Pole temp = new Pole("C");
		MoveTower(disks, start, goal, temp);
		
		counter = 1;
		
		System.out.println("\n\n");
		
		System.out.println("**************************************");
		System.out.println("* Move " + (disks + 1) + " disks from pole A to pole C* ");
		System.out.println("**************************************");
		
		goal = new Pole("C");
		temp = new Pole("B");
		MoveTower(disks, start, goal, temp);
	}
}