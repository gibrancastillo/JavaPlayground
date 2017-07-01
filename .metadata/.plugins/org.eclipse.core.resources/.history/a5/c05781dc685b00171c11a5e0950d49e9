package com.ccc.playground.bst2;

public class BinaryTreeTest {
	
	public static void main(String[] args) {
		BinaryTree theBinaryTree = new BinaryTree();
		theBinaryTree.addNode(50, "Boss"); // root Node
		theBinaryTree.addNode(25, "Vice President"); // left child Node from root Node
		theBinaryTree.addNode(15, "Office Manager");
		theBinaryTree.addNode(30, "Secretary");
		theBinaryTree.addNode(75, "Sales Manager"); // right child Node from root Node
		theBinaryTree.addNode(85, "Salesman 1");
		
		theBinaryTree.inOrderTraverseTree(theBinaryTree.root);
		//theBinaryTree.preOrderTraverseTree(theBinaryTree.root);
		//theBinaryTree.postOrderTraverseTree(theBinaryTree.root);
		System.out.println();
		
		System.out.println("Search (findNode) for Node with key 30");
		System.out.println(theBinaryTree.findNode(30));
		System.out.println();
		
		System.out.println("Delete (removeNode) for Node with key 25");
		System.out.println(theBinaryTree.removeNode(25));
		System.out.println();
		
		theBinaryTree.inOrderTraverseTree(theBinaryTree.root);
	}
}