// Source code example for "A Practical Introduction
// to Data Structures and Algorithm Analysis"
// by Clifford A. Shaffer, Prentice Hall, 1998.
// Copyright 1998 by Clifford A. Shaffer

class LQueue implements Queue {        // Linked queue class
  private Link front;                  // Pointer to front node
  private Link rear;                   // Pointer to rear node

  public LQueue() { setup(); }         // Constructor
  public LQueue(int sz) { setup(); }   // Constuctor: Ignore sz

  private void setup()                 // Initialize queue
  { front = rear = null; }

  // Remove all Objects from queue
  public void clear() { front = rear = null; }
  
  // Enqueue Object at rear of queue
  public void enqueue(Object it) {
    if (rear != null) {             // Queue not empty: add to end
      rear.setNext(new Link(it, null));
      rear = rear.next();
    }
    else front = rear = new Link(it, null); // Empty queue
  }

  public Object dequeue() {         // Dequeue Object from front
    Assert.notFalse(!isEmpty());    // Must be something to dequeue
    Object it = front.element();    // Store dequeued Object
    front = front.next();           // Advance front
    if (front == null) rear = null; // Dequeued last Object
    return it;                      // Return Object
  }

  public Object firstValue()        // Return value of top Object
  { Assert.notFalse(!isEmpty());  return front.element(); }

  public boolean isEmpty()          // Return true if queue is empty
  { return front == null; }
} // clases LQueue
