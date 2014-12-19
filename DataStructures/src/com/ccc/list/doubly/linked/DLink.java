package com.ccc.list.doubly.linked;

// Source code example for "A Practical Introduction
// to Data Structures and Algorithm Analysis"
// by Clifford A. Shaffer, Prentice Hall, 1998.
// Copyright 1998 by Clifford A. Shaffer

class DLink {                // A doubly-linked list node
  private Object element;    // Object for this node
  private DLink next;        // Pointer to next node in list
  private DLink prev;        // Pointer to previous node in list
  DLink(Object it, DLink n, DLink p)               // Constructor 1
  { element = it;  next = n; prev = p; }           //  Given Object
  DLink(DLink n, DLink p) { next = n;  prev = p; } // Constructor 2
  DLink next() { return next; }
  DLink setNext(DLink nextval) { return next = nextval; }
  DLink prev() { return prev; }
  DLink setPrev(DLink prevval) { return prev = prevval; }
  Object element() { return element; }
  Object setElement(Object it) { return element = it; }
} // class Dlink
