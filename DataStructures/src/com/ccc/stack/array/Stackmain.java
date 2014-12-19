package com.ccc.stack.array;

// Source code example for "A Practical Introduction
// to Data Structures and Algorithm Analysis"
// by Clifford A. Shaffer, Prentice Hall, 1998.
// Copyright 1998 by Clifford A. Shaffer

import java.io.*;

// Driver class for Stack implementation tests
class Stackmain {

// Main routine for Stack implementation tests
public static void main(String args[]) throws IOException {
  
  // Create two array-based stacks
  Stack L1 = new AStack();   // Default size
  Stack L2 = new AStack(15); // Defined size

  // Do some stack operations
  L2.push(new IElem(10));
  L2.push(new IElem(20));
  L2.push(new IElem(15));
  while(!L2.isEmpty()) {
    L1.push(L2.pop());
    System.out.print(L1.topValue() + " ");
  }
  System.out.println();
  System.out.println("New top: " + L1.topValue());
  L1.clear();
  System.in.read();
}

}