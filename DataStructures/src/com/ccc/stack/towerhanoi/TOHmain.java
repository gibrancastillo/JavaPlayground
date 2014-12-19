package com.ccc.stack.towerhanoi;

// Source code example for "A Practical Introduction
// to Data Structures and Algorithm Analysis"
// by Clifford A. Shaffer, Prentice Hall, 1998.
// Copyright 1998 by Clifford A. Shaffer

import java.io.*;

// Driver class for testing Tower of Hanoi function
class TOHmain
{
  static int counter = 1; // Count the number of moves

  // Do (and count) a move by printing the action
  static void move(Pole start, Pole goal) {
    System.out.println(counter + ": Move " + start + " to " + goal);
    counter++;
  }

//Tower of Hanoi function
static final int MOVE = 1;       // Move operation indicator
static final int TOH = 2;        // TOH operation indicator

static void TOH(int n, Pole start, Pole goal, Pole temp) {
  Stack S = new AStack(2*n+1);   // Make stack just big enough
  S.push(new TOHobj(TOH, n, start, goal, temp)); // Initial form
  while (!S.isEmpty()) {
    TOHobj it = (TOHobj)S.pop(); // Grab next task
    if (it.op == MOVE)           // Do a move
      move(it.start, it.goal);
    else if (it.num > 0) {       // Imitate three statements in TOH
                                 // recursive solution (in reverse)
      S.push(new TOHobj(TOH, it.num-1, it.temp, it.goal, it.start));
      S.push(new TOHobj(MOVE, it.start, it.goal));  // A move to do
      S.push(new TOHobj(TOH, it.num-1, it.start, it.temp, it.goal));
    }
  }
}

  // Main function for TOH driver
  public static void main(String args[]) throws IOException {
    Assert.notFalse(args.length == 1, "Usage: TOHmain <size>");
    // Arbitrarily assign identifiers to poles for printing
    Pole start = new Pole(1);
    Pole goal = new Pole(2);
    Pole temp = new Pole(3);

    // Read in number of disks
    int disks = Integer.parseInt(args[0]);
    TOH(disks, start, goal, temp);
    System.in.read();
  }
}
