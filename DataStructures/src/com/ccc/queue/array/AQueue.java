// Source code example for "A Practical Introduction
// to Data Structures and Algorithm Analysis"
// by Clifford A. Shaffer, Prentice Hall, 1998.
// Copyright 1998 by Clifford A. Shaffer

class AQueue implements Queue {   // Array-based queue class
  private static final int defaultSize = 10;
  private int size;               // Maximum size of queue
  private int front;              // Index prior to front item
  private int rear;               // Index of rear item
  private Object [] listArray;    // Array holding Objects

  AQueue() { setup(defaultSize); } // Constructor: default size
  AQueue(int sz) { setup(sz); }    // Constructor: set size

  void setup(int sz)              // Initialize queue
  { size = sz+1;  front = rear = 0;  listArray = new Object[sz+1]; }

  public void clear()             // Remove all Objects from queue
  { front = rear = 0; }

  public void enqueue(Object it) { // Enqueue Object at rear
    Assert.notFalse(((rear+1) % size) != front, "Queue is full");
    rear = (rear+1) % size;       // Increment rear (in circle)
    listArray[rear] = it;
  }

  public Object dequeue() {       // Dequeue Object from front
    Assert.notFalse(!isEmpty(), "Queue is empty");
    front = (front+1) % size;     // Increment front
    return listArray[front];      // Return value
  }

  public Object firstValue() {    // Return value of front Object
    Assert.notFalse(!isEmpty(), "Queue is empty");
    return listArray[(front+1) % size];
  }

  public boolean isEmpty()        // Return true if queue is empty
  { return front == rear; }
} // class AQueue
