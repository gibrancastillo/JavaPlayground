package com.ccc.bst;

/**
 * Parent node or root node key has the middle value, the left node key has the lesser value of the parent and the right node key 
 * has the greater value of the parent.  Parent nodes only have two children. 
 * 
 * @author gecasti
 *
 */
public class Node {
	int key;
	String name;
	
	Node leftChild;
	Node rightChild;
	
	Node(int key, String name) {
		this.key = key;
		this.name = name;
		this.leftChild = this.rightChild = null;
	}
	
	public String toString() {
		return "'" + name + "' has a key of '" + key + "'";
	}
}