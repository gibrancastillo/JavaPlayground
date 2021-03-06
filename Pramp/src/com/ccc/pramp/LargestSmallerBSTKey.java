package com.ccc.pramp;

/**
 * CODE INSTRUCTIONS:
 * 1) The method findLargestSmallerKey you're asked to implement is located at line 56.
 * 2) Use the helper code below to implement it.
 * 3) In a nutshell, the helper code allows you to build a Binary Search Tree.
 * 4) Jump to line 82 to see an example for how the helper code is used to test findLargestSmallerKey.
 * 
 * @author gecasti
 *
 */
public class LargestSmallerBSTKey {
	
	static class Node {
		int key;
		Node left;
		Node right; 
		Node parent;

		Node(int key) {
			this.key = key;
			left = null;
			right = null;
			parent = null;
		}
	}
	
	static class BinarySearchTree {
		Node root;
		
		int find(int num) {
			Node focusNode = root;

			while(focusNode.key != num) {

				if(num < focusNode.key) {
					//search down the left child Node side
					focusNode = focusNode.left;
				} else {
					//search down the right child Node side
					focusNode = focusNode.right;
				}

				if(focusNode == null) {
					//We did not find the Node in the Binary Tree.
					return 0;
				}
			}

			return focusNode.key;
		}
		
		/**
		 * Given a root of a Binary Search Tree (BST) and a number num, implement an efficient function findLargestSmallerKey that finds the largest
		 * key in the tree that is smaller than num.  Analyze the time and space complexities of your solution.
		 * 
		 * While the code to solve this question is simple, it takes some understanding of binary search trees. There are two key parts for the algorithm.
		 * Part 1: traversing the tree
		 * ---------------------------
		 * A node in a binary search tree is larger than all keys in its left subtree and smaller than all keys i its right subtree. Starting from the root,
		 * for each node we choose its left or its right child as the next step, based on a comparison between that node�s key and num: If the current node
		 * holds a key smaller than num, we proceed to its right subtree looking for larger keys. Otherwise, we proceed to its left subtree looking for smaller keys.
		 * 
		 * Part 2: finding the key
		 * -----------------------
		 * During this iteration, when the current key is smaller than num, we store it as our result and keep looking for a larger key that is still smaller than num.
		 * It�s important to understand why we always store the last key without comparing it to the value stored beforehand. If we have stored a key before, then it
		 * means we have chosen to continue down the key�s right subtree. Therefore, all subsequent keys will be larger than any previously stored keys.

		 * 
		 * Time Complexity: we scan the tree once from the root to the leaves and do a constant number of actions for each node. if the
		 *                  tree is balanced the complexity is O(log(N)). Otherwise, it could be up to O(N).
		 * Space Complexity: throughout the entire algorithm we used only a constant amount of space, hence the space complexity is O(1).
		 * 
		 * Example - For num = 17 and the binary search tree below:
		 *                             20
		 *                           /    \
		 *                          9      25
		 *                         /         \
		 *                        5          null
		 *                      /   \
		 *                   null     12
		 *                          /    \
		 *                         11     14
		 * 
		 * Your function would return:  14 since it�s the largest key in the tree that is still smaller than 17.
		 * Constraints:
		 * �	[time limit] 5000ms
		 * �	[input] Node rootNode
		 * �	[output] integer
		 * 
		 * @param num
		 * @return
		 */
		int findLargestSmallerKey(int num) {
			// your code goes here 
			Node focusNode = root;
			int result = -1;

			while(focusNode != null) {

				if(num < focusNode.key) {
					//search down the left child Node side
					focusNode = focusNode.left;
				} else {
					//search down the right child Node side
					result = focusNode.key;
					focusNode = focusNode.right;
				}  
			}

			return result;
		}
		
		static int findLargestSmallerKey(Node rootNode, int num)
		{
			if (rootNode == null) {
				return -1;
			}

			while (rootNode.key != num) {

				if (rootNode.key > num) {
					return findLargestSmallerKey(rootNode.left, num);
				} else {
					return findLargestSmallerKey(rootNode.right, num);
				}
			}

			return rootNode.key;
		}
		
		//  inserts a new node with the given number in the
		//  correct place in the tree
		void insert(int key) {

			// 1) If the tree is empty, create the root
			if(this.root == null) {
				this.root = new Node(key);
				return;
			}

			// 2) Otherwise, create a node with the key
			//    and traverse down the tree to find where to
			//    to insert the new node
			Node currentNode = this.root;
			Node newNode = new Node(key); 

			while(currentNode != null) {
				if(key < currentNode.key) {
					if(currentNode.left == null) {
						currentNode.left = newNode;
						newNode.parent = currentNode;
						break;
					} else {
						currentNode = currentNode.left;
					}
				} else {
					if(currentNode.right == null) {
						currentNode.right = newNode;
						newNode.parent = currentNode;
						break;
					} else {
						currentNode = currentNode.right;
					}
				}
			}
		}
	}

	/*********************************************
	 * Driver program to test above function     *
	 *********************************************/
	public static void main(String[] args) {
		// Create a Binary Search Tree
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(20);
		bst.insert(9);
		bst.insert(25);
		bst.insert(5);
		bst.insert(12);
		bst.insert(11);
		bst.insert(14);
		
		System.out.println("Found the number " + bst.find(11));
		System.out.println("Largest smaller number is " + bst.findLargestSmallerKey(17));
	}
}