package com.ccc.stack.towerhanoi;

// Source code example for "A Practical Introduction
// to Data Structures and Algorithm Analysis"
// by Clifford A. Shaffer, Prentice Hall, 1998.
// Copyright 1998 by Clifford A. Shaffer

class TOHobj { // Stack element for Tower of Hanoi
  public int op;  // Operation (imitate recursion or move)
  public int num; // Size of pile to move (recursion level)
  public Pole start, goal, temp;

  TOHobj(int o, int n, Pole s, Pole g, Pole t) // TOH
  { op = o; num = n; start = s; goal = g; temp = t; }

  TOHobj(int o, Pole s, Pole g)                // MOVE
  { op = o; start = s; goal = g; }
}
