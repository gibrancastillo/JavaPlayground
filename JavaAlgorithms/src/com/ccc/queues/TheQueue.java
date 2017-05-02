package com.ccc.queues;

import java.util.Arrays;

/**
 * Queues are used to complete a task and are soon after discarded.
 * A queue is like a line of people.  The first person in line gets served first.
 * 
 * Queues
 * 1. Allow only a single item to be added or removed at a time
 * 2. Queues allow access to the first item inserted (FIFO:  First In First Out)
 * 
 * @author gecasti
 *
 */
public class TheQueue {
	private String[] queueArray;
	private int queueSize;
	
	/*
	 * Sets queue as empty
	 * We are going to be monitorinig the front and read
	 * of the queue and the number of items in the queue
	 */
	private int front, numberOfItems, rear = 0;
	
	TheQueue(int size) {
		queueSize = size;
		queueArray = new String[queueSize];
		
		/*
		 * Assigns the String value of "-1" to every value in the array
		 * so I control what gets printed to screen. "-1" equals empty space
		 */
		Arrays.fill(queueArray, "-1");
	}
	
	/**
	 * To add (insert) or enqueue a value to the end of the queue
	 * 
	 * @param input
	 */
	public void enqueue(String input) {
		// Make sure you have enough room in the array or queue array to add or enqueue a value
		if(numberOfItems + 1 <= queueSize) {
			queueArray[rear] = input;
			rear++;
			numberOfItems++;
			System.out.println("INSERT " + input + " Was Added to the Stack\n");
		} else {
			System.out.println("Sorry But the Queue is Full");
		}
	}
	
	/**
	 * This priority add (insert) or enqueue will add items in order from high to low
	 * 
	 * @param input
	 */
	public void priorityEnqueue(String input) {
		int i;
		
		if(numberOfItems == 0) {
			enqueue(input);
		} else {
			/*
			 * The loop starts at the end (rear) of the queue array int i = numberOfItems - 1 and as 'i' is decremented
			 * and if the new input is greater than the input that is in the array, then copy that value further up into
			 * the queue array because it's going to be moved, else break out of it because you are don shifting items in the queue.
			 */
			for(i = numberOfItems - 1; i >= 0; i--) {
				if(Integer.parseInt(input) > Integer.parseInt(queueArray[i])) {
					queueArray[i + 1] = queueArray[i];
				} else break; // Done shifting items in queue
			}
			
			queueArray[i + 1] = input;
			rear++;
			numberOfItems++;
		}
	}
	
	/**
	 * To get and remove (delete) or dequeue the value from the front of the queue
	 * 
	 * @return
	 */
	public String dequeue() {
		// Make sure you have something to get/remove (delete) or dequeue from the queue.
		if(numberOfItems > 0) {
			System.out.println("REMOVE " + queueArray[front] + " Was Removed From the Queue\n");
			
			// Just like in memory an item isn't deleted, but instead is just not available
			queueArray[front] = "-1";
			numberOfItems--;
			
			return queueArray[front++];
		} else {
			System.out.println("Sorry But the Queue is Empty");
			
			return "-1";
		}
	}
	
	/**
	 * To see or view and get the value that is on the front of the queue
	 * @return
	 */
	public String peek() {
		System.out.println("PEEK " + queueArray[front] + " Is at the front of the Queue\n");
		
		return queueArray[front];
	}
	
	public void displayTheQueue(){
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < queueSize; n++) {
			System.out.format("| %2s "+ " ", n);
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < queueSize; n++) {
			if(queueArray[n].equals("-1")) System.out.print("|     ");
			else System.out.print(String.format("| %2s "+ " ", queueArray[n]));
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
		
		// Number of spaces to put before the F
		int spacesBeforeFront = 3*(2*(front+1)-1);
		
		for(int k = 1; k < spacesBeforeFront; k++)System.out.print(" ");
		
		System.out.print("F");
		
		// Number of spaces to put before the R
		int spacesBeforeRear = (2*(3*rear)-1) - (spacesBeforeFront);
		
		for(int l = 0; l < spacesBeforeRear; l++)System.out.print(" ");
		
		System.out.print("R");
		System.out.println("\n");
	}
	
	public static void main(String[] args) {
		TheQueue theQueue = new TheQueue(10);
		
		theQueue.displayTheQueue();
		
		theQueue.priorityEnqueue("16");
		theQueue.displayTheQueue();
		theQueue.priorityEnqueue("10");
		theQueue.displayTheQueue();
		theQueue.priorityEnqueue("25");
		theQueue.displayTheQueue();
		theQueue.priorityEnqueue("19");
		
		/*theQueue.enqueue("10");
		theQueue.displayTheQueue();
		theQueue.enqueue("15");
		theQueue.displayTheQueue();
		theQueue.enqueue("25");
		theQueue.displayTheQueue();
		theQueue.enqueue("25");
		theQueue.displayTheQueue();
		theQueue.enqueue("25");*/
		
		theQueue.displayTheQueue();
		
		theQueue.dequeue();
		theQueue.displayTheQueue();
		/*theQueue.dequeue();
		theQueue.displayTheQueue();*/
		theQueue.peek();
	}
}