package com.ccc.threads;

public class ThreadExecution implements Runnable {
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + "---> i value: " + i);
		}
	}
	
	public static void main(String[] args) {
		try {
			ThreadExecution te1 = new ThreadExecution();  // The "job" to be done.
			// Creating the first thread, the "worker"
			Thread t1 = new Thread(te1); // thread has been instantiated but not started (the new state)
			t1.setName("First Thread");
			// Invoking the first thread and launch a new call stack.  Threads moves from new state to the runnable state (alive)
			t1.start();
			
			ThreadExecution te2 = new ThreadExecution();
			// Creating the second thread
			Thread t2 = new Thread(te2);
			t2.setName("Second Thread");
			// Invoking the first thread
			t2.start();
			
			ThreadExecution te3 = new ThreadExecution();
			// Creating the third thread
			Thread t3 = new Thread(te3);
			t3.setName("Third Thread");
			// Invoking the third thread
			t3.start();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}