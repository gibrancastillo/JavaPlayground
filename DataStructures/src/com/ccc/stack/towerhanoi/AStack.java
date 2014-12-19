package com.ccc.stack.towerhanoi;

// Source code example for "A Practical Introduction
// to Data Structures and Algorithm Analysis"
// by Clifford A. Shaffer, Prentice Hall, 1998.
// Copyright 1998 by Clifford A. Shaffer

class AStack implements Stack {    // Array based stack class

  private static final int defaultSize = 10;

  private int size;                // Maximum size of stack
  private int top;                 // Index for top Object
  private Object [] listarray;     // Array holding stack Objects

  AStack() { setup(defaultSize); }
  AStack(int sz) { setup(sz); }

  public void setup(int sz)
  { size = sz;  top = 0; listarray = new Object[sz]; }

  public void clear()              // Remove all Objects from stack
    { top = 0; }

  public void push(Object it) {    // Push Object onto stack
    Assert.notFalse(top < size, "Stack overflow");
	listarray[top++] = it;
  }

  public Object pop() {            // Pop Object from top of stack
    Assert.notFalse(!isEmpty(), "Empty stack");
	return listarray[--top];
  }

  public Object topValue() {       // Return value of top Object
    Assert.notFalse(!isEmpty(), "Empty stack");
	return listarray[top-1];
  }

  public boolean isEmpty()         // Return true if stack is empty
    { return top == 0; }
} // class AStack
