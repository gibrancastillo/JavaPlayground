// Source code example for "A Practical Introduction
// to Data Structures and Algorithm Analysis"
// by Clifford A. Shaffer, Prentice Hall, 1998.
// Copyright 1998 by Clifford A. Shaffer

public interface Queue {          // Queue ADT
  public void clear();            // Remove all Objects from queue
  public void enqueue(Object it); // Enqueue Object at rear of queue
  public Object dequeue();        // Dequeue Object from front of queue
  public Object firstValue();     // Return value of top Object
  public boolean isEmpty();       // Return TRUE if stack is empty
}
