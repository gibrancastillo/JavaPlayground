// Source code example for "A Practical Introduction
// to Data Structures and Algorithm Analysis"
// by Clifford A. Shaffer, Prentice Hall, 1998.
// Copyright 1998 by Clifford A. Shaffer

import java.io.*;

// Driver class for Queue tests
class Queuemain {

// Driver main routine for Queue tests
public static void main(String args[]) throws IOException {
  
  // Create two array-based queues
  Queue L1 = new LQueue();   // Default size
  Queue L2 = new LQueue(15); // Definted size
  // Do some queue tests
  L2.enqueue(new IElem(10));
  L2.enqueue(new IElem(20));
  L2.enqueue(new IElem(15));
  while(!L2.isEmpty()) {
    System.out.print(L2.firstValue() + " ");
    L1.enqueue(L2.dequeue());
  }
  System.out.println();
  System.out.println("New front: " + L1.firstValue());
  L1.clear();
  System.in.read();
}

}