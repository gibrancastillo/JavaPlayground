package com.ccc.stack.linked;

// Source code example for "A Practical Introduction
// to Data Structures and Algorithm Analysis"
// by Clifford A. Shaffer, Prentice Hall, 1998.
// Copyright 1998 by Clifford A. Shaffer

class LStack implements Stack {       // Linked stack class
  private Link top;                   // Pointer to list header

  public LStack() { setup(); }        // Constructor
  public LStack(int sz) { setup(); }  // Constructor: ignore sz

  private void setup() { top = null; } // Initialize stack

  public void clear() { top = null; } // Remove Objects from stack
  
  public void push(Object it)         // Push Object onto stack
  { top = new Link(it, top); }

  public Object pop() {               // Pop Object at top of stack
    Assert.notFalse(!isEmpty(), "Empty stack");
    Object it = top.element();
    top = top.next();
    return it;
  }

  public Object topValue()            // Get value of top Object
  { Assert.notFalse(!isEmpty(), "No top value");
    return top.element(); }

  public boolean isEmpty()            // Return true if empty stack
  { return top == null; }
} // class LStack
