package com.ccc.playground;

public class LinkedListNode {
	int data;
	public LinkedListNode next;
	public LinkedListNode prev;
	
	public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
		this.data = d;
		this.setNext(n);
		this.setPrevious(p);
	}
	
	public void setNext(LinkedListNode n) {
		next = n;
		
		if(n != null && n.prev != this) {
			n.setPrevious(this);
		}
	}
	
	public void setPrevious(LinkedListNode p) {
		prev = p;
		
		if(p != null && p.next != this) {
			p.setNext(this);
		}
	}
}