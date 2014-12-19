package com.ccc.stack.linked;

// Source code example for "A Practical Introduction
// to Data Structures and Algorithm Analysis"
// by Clifford A. Shaffer, Prentice Hall, 1998.
// Copyright 1998 by Clifford A. Shaffer

public interface Stack {       // Stack ADT
  public void clear();         // Remove all Objects from stack
  public void push(Object it); // Push Object onto stack
  public Object pop();         // Pop Object from top of stack
  public Object topValue();    // Return value of top Object
  public boolean isEmpty();    // Return true if stack is empty
}
