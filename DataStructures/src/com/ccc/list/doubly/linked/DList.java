package com.ccc.list.doubly.linked;

// Source code example for "A Practical Introduction
// to Data Structures and Algorithm Analysis"
// by Clifford A. Shaffer, Prentice Hall, 1998.
// Copyright 1998 by Clifford A. Shaffer

class DList implements List { // Doubly-linked list class
private DLink head;           // Pointer to list header
private DLink tail;           // Pointer to last Object in list 
private DLink curr;           // Position of current Object

DList(int sz) { setup(); }    // Constructor -- Ignore sz
DList() { setup(); }

private void setup()          // Do initialization
{ tail = head = curr = new DLink(null, null); } // Create header node

public void clear() {         // Remove all Objects from list
  head.setNext(null);
  curr = tail = head;         // Reinitialize
}

// The following four methods, insert, append, remove, and prev,
// are the only ones actually modified for doubly linked lists.

// Insert Object at current position
public void insert(Object it) {
  Assert.notNull(curr, "No current element");
  curr.setNext(new DLink(it, curr.next(), curr));
  if (curr.next().next() != null)
    curr.next().next().setPrev(curr.next());
  if (tail == curr)             // Appended new Object
    tail = tail.next();
}

public void append(Object it) { // Insert Object at tail of list
  tail.setNext(new DLink(it, null, tail));
  tail = tail.next();
}

public Object remove() {        // Remove and return current Object
  Assert.notFalse(isInList(), "No current element");
  Object it = curr.next().element(); // Remember Object
  if (curr.next().next() != null)
    curr.next().next().setPrev(curr);
  else tail = curr;  // Removed last Object: set tail
  curr.setNext(curr.next().next()); // Remove from list
  return it;                    // Return value removed
}

public void prev()              // Move curr to previous position
{ if (curr != null) curr = curr.prev(); }

public void setFirst()        // Set curr to first position
{ curr = head; }

public void next()            // Move curr to next position
{ if (curr != null)  curr = curr.next(); }

public int length() {         // Return current length of list
  int cnt = 0;
  for (DLink temp = head.next(); temp != null; temp = temp.next())
     cnt++;                   // Count the number of links
  return cnt;
}

public void setPos(int pos) { // Set curr to specified position
  curr = head;
  for(int i=0; (curr!=null) && (i<pos); i++)
    curr = curr.next();
}

public void setValue(Object it) // Set current Object's value
{ Assert.notFalse(isInList());  curr.next().setElement(it); }

public Object currValue() {   // Return value of current Object
  if (!isInList()) return null;
  return curr.next().element();
}

public boolean isEmpty()      // Return true if list is empty
{ return head.next() == null; }

public boolean isInList()     // true if curr is within list
  { return (curr != null) && (curr.next() != null); }

public void print() {         // Print out the list's elements
  if (isEmpty()) System.out.println("()");
  else {
    System.out.print("( ");
	for (setFirst(); isInList(); next())
	  System.out.print(currValue() + " ");
    System.out.println(")");
  }
}

} // class DList
