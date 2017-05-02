package com.ccc.playground;

/**
 * Nodes are implemented by class, structures or as Link-List nodes.  In this case I represent node as follows:  
 * 
 * @author gecasti
 *
 */
public class Node {
	public char label;
	public boolean visited = false;
	
	public Node(char l) {
		this.label = l;
	}
}