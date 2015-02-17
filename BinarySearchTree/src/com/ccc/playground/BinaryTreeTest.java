package com.ccc.playground;

import org.junit.Test;

public class BinaryTreeTest {
	@Test
	public void test() {
		BinaryTree binaryTree = new BinaryTree();
		binaryTree.add(50);  // root
		binaryTree.add(25);  // left child of the root
		binaryTree.add(75);  // right child of the root
		binaryTree.add(10);
		binaryTree.add(30);
		binaryTree.add(60);
		binaryTree.add(65);
		binaryTree.add(80);
		binaryTree.add(85);
		binaryTree.add(1);
		binaryTree.add(100);
		
		binaryTree.delete(50);
		//binaryTree.preOrderTraversal(binaryTree.getRoot());
		binaryTree.inOrderTraversal(binaryTree.getRoot());
		//binaryTree.postOrderTraversal(binaryTree.getRoot());
		
		//binaryTree.delete(75);
	}
}