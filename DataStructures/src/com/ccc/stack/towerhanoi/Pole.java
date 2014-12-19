package com.ccc.stack.towerhanoi;

// Source code example for "A Practical Introduction
// to Data Structures and Algorithm Analysis"
// by Clifford A. Shaffer, Prentice Hall, 1998.
// Copyright 1998 by Clifford A. Shaffer

// Pole class for Towers of Hanoi test.
// Its just something with an integer value.
class Pole {
  int poleNum;
  
  Pole(int value) {
    poleNum = value;
  }

  // Override Object.toString
  public String toString() {
    return Integer.toString(poleNum);
  }
}
