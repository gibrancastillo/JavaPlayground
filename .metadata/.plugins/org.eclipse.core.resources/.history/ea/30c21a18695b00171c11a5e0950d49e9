package com.ccc.playground.bst2;

import java.util.ArrayList;
import java.util.Iterator;

public class MyIterator implements Iterator<Long> {
	private ArrayList<Iterator<Long>> sortedOrder = new ArrayList<Iterator<Long>>();
	BinaryTree theBinaryTree = new BinaryTree();
	
	public MyIterator(ArrayList<Iterator<Long>> sortedOrder) {
		this.sortedOrder = sortedOrder;
	}
	
	@Override
	public Long next() {
		
		
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasNext() {
		int index = 0;
		while(!sortedOrder.isEmpty()) {
			Iterator<Long> focusIterator = sortedOrder.get(index);
			index++;
			
			if(focusIterator.hasNext()) {
				long key = focusIterator.next();
				theBinaryTree.addNode((int) key, "");
			}
		}
		
		return false;
	}
}
