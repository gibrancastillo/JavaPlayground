package com.ccc.bst;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A Tree has top node known as the root.  The lines that connect all of the nodes there after are known as paths or edges.
 * A leaf is a node that does not have any children nodes.  
 * A subtree is a section of the tree.
 * 
 * A Binary Tree is the same as the tree, but it will only will ever have two children nodes and the keys to create binary 
 * trees have parent node or root node key has the middle value, the left node key has the lesser value of the parent and the right node key 
 * has the greater value of the parent.
 * 
 * Random data normally is not going to create an unbalanced tree.  An unbalanced tree is where most of the nodes are found one side
 * of the root node.  However, ordered data tends to create unbalanced trees.  Unbalanced trees are bad because they are slow.
 * 
 * Why use a binary tree?
 * 1. You can search, insert and delete items quickly in a tree.
 * 2. Ordered Arrays are bad at insertions and deletions.
 * 3. Finding items in a Linked List is slow.
 * 4. Time needed to perform an operation on a tree is O(log N).
 * 5. On average a tree is more efficient if you need to perform many different types of operations.
 * 
 * There are three types of Traversals (Traversing the nodes in the Binary Tree):
 * 1. In Order Traversal
 * 2. 
 * 3. 
 * 
 * @author gecasti
 *
 */
public class BinaryTree {
	Node root;
	
	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);
		
		if(root == null) {
			root = newNode;
		} else {
			Node focusNode = root;
			Node parent;  //future parent of new node
			
			while(true) {
				parent = focusNode;
				
				//Should the new node go on the left side or the right side of the parent node
				if(key < focusNode.key) {
					//The left child node has to have key value that is less than the parent node key value
					focusNode = focusNode.leftChild;
					
					if(focusNode == null) {
						/*
						 * The parent node has no left child node; therefore, add (create) 
						 * new node to the left of the parent node in the binary tree.
						 */
						parent.leftChild = newNode;
						return;
					}
				} else {
					//The right child node has to have key value that is equal or greater than the parent node key value
					focusNode = focusNode.rightChild;
					
					if(focusNode == null) {
						/*
						 * The parent node has no right child node; therefore, add (create) 
						 * new node to the right of the parent node in the binary tree.
						 */
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
	
	/**
	 * Traversing Nodes in a Binary Tree - In Order Traversal:  The key values are increasing as we traverse the Binary Tree.
	 * <> Aim for the smallest value first; therefore, start at 1st Left Child Node from the root node.
	 * <> When Null Node is reached then move up in value.
	 * 
	 * Using recursion to accomplish this
	 * 
	 * @param focusNode
	 */
	public void inOrderTraverseTree(Node focusNode) {
		if(focusNode != null) {
			inOrderTraverseTree(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	/**
	 * Traversing Nodes in a Binary Tree - Pre Order Traversal:  The key values are print out as you traverse the Binary Tree.
	 * <> First hit our main focus Node, if we start we root Node, then we go with root Node first.
	 * <> Then cycle down thru all of the left children nodes.
	 * <> Then jump up one parent when we hit null in the left most child Node and go to the right child node.
	 * <> Then jump up to root Node and go thru the right child Nodes.
	 * 
	 * Using recursion to accomplish this
	 * 
	 * @param focusNode
	 */
	public void preOrderTraverseTree(Node focusNode) {
		if(focusNode != null) {
			System.out.println(focusNode);
			preOrderTraverseTree(focusNode.leftChild);
			preOrderTraverseTree(focusNode.rightChild);
		}
	}
	
	/**
	 * Traversing Nodes in a Binary Tree - In Post Order Traversal:  The key values are print out as we traverse the Binary Tree with left child, right child and then parent.
	 * <> First hit our main focus Node, if we start we root Node, then we go with root Node first.
	 * <> Aim for the smallest value first; therefore, start at 1st Left Child Node from the root node.
	 * <> Then go to the right child node of the parent Node.
	 * <> Then jump up to the parent Node.
	 * <> Then jump up to root Node and go thru the right child Nodes.
	 * <> Root Node comes last.
	 * 
	 * Using recursion to accomplish this
	 * 
	 * @param focusNode
	 */
	public void postOrderTraverseTree(Node focusNode) {
		if(focusNode != null) {
			postOrderTraverseTree(focusNode.leftChild);
			postOrderTraverseTree(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}
	
	/**
	 * 
	 * @param key an integer value that represents the Node you are looking for.
	 * @return
	 */
	public Node findNode(int key) {
		Node focusNode = root;
		
		while(focusNode.key != key) {
			
			if(key < focusNode.key) {
				//search down the left child Node side
				focusNode = focusNode.leftChild;
			} else {
				//search down the right child Node side
				focusNode = focusNode.rightChild;
			}
			
			if(focusNode == null) {
				//We did not find the Node in the Binary Tree.
				return null;
			}
		}
		
		return focusNode;
	}
	
	/**
	 * Given a root of a Binary Search Tree (BST) and a number num, implement an efficient function findLargestSmallerKey that finds the largest
	 * key in the tree that is smaller than num.  Analyze the time and space complexities of your solution.
	 * 
	 * While the code to solve this question is simple, it takes some understanding of binary search trees. There are two key parts for the algorithm.
	 * Part 1: traversing the tree
	 * ---------------------------
	 * A node in a binary search tree is larger than all keys in its left subtree and smaller than all keys i its right subtree. Starting from the root,
	 * for each node we choose its left or its right child as the next step, based on a comparison between that node’s key and num: If the current node
	 * holds a key smaller than num, we proceed to its right subtree looking for larger keys. Otherwise, we proceed to its left subtree looking for smaller keys.
	 * 
	 * Part 2: finding the key
	 * -----------------------
	 * During this iteration, when the current key is smaller than num, we store it as our result and keep looking for a larger key that is still smaller than num.
	 * It’s important to understand why we always store the last key without comparing it to the value stored beforehand. If we have stored a key before, then it
	 * means we have chosen to continue down the key’s right subtree. Therefore, all subsequent keys will be larger than any previously stored keys.

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
	 * Your function would return:  14 since it’s the largest key in the tree that is still smaller than 17.
	 * Constraints:
	 * •	[time limit] 5000ms
	 * •	[input] Node rootNode
	 * •	[output] integer
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
				focusNode = focusNode.leftChild;
			} else {
				//search down the right child Node side
				result = focusNode.key;
				focusNode = focusNode.rightChild;
			}  
		}
		
		return result;
	}
	
	public boolean removeNode(int key) {
		Node focusNode = root;
		Node parent = root;
		
		boolean isItALeftChild = true;
		
		// Finding the Node to delete in the Binary Tree
		while(focusNode.key != key) {
			// 1. Find Node to be deleted in the binary tree
			parent = focusNode;
			
			if(key < focusNode.key) {
				isItALeftChild = true;
				focusNode = focusNode.leftChild;
			} else {
				isItALeftChild = false;
				focusNode = focusNode.rightChild;
			}
			
			if(focusNode == null) {
				// The Node we are trying to delete was not found in the Binary Tree
				return false;
			}
		}
		
		// Deleting the Node
		if(focusNode.leftChild == null && focusNode.rightChild == null) {
			// 2. Node to be deleted is a leaf Node or does not have any children Nodes
			
			if(focusNode == root) {
				/*
				 * The focus Node or the Node to remove does not have a left or right child Node and
				 * the focus Node or the Node to remove is equal to the root Node then delete root Node.
				 */
				root = null;
			} else if(isItALeftChild) {
				/*
				 * The focus Node was marked as a left child Node of the parent Node; therefore,
				 * delete the focus Node on it's parent or delete the parent's left child Node.
				 */
				parent.leftChild = null;
			} else {
				/*
				 * The focus Node was marked as a right child Node of the parent Node; therefore,
				 * delete the focus Node on it's parent or delete the parent's right child Node.
				 */
				parent.rightChild = null;
			}
		} else if(focusNode.rightChild == null) {
			// 3. Node to be deleted does not have a right child Node.
			if(focusNode == root) {
				root = focusNode.leftChild;
			} else if(isItALeftChild) {
				parent.leftChild = focusNode.leftChild;
			} else {
				parent.rightChild = focusNode.leftChild;
			}
		} else if(focusNode.leftChild == null) {
			// 4. Node to be deleted does not have a left child Node.
			if(focusNode == root) {
				root = focusNode.rightChild;
			} else if(isItALeftChild) {
				parent.leftChild = focusNode.rightChild;
			} else {
				parent.rightChild = focusNode.rightChild; // focusNode.leftChild; ??
			}
		} else {
			// 5. Node to be deleted has a left Node and a right Node.
			Node replacement = getReplacementNode(focusNode);
			
			if(focusNode == root) {
				// The replacement Node is root's right child node
				root = replacement;
			} else if(isItALeftChild) {
				parent.leftChild = replacement;
			} else {
				parent.rightChild = replacement;
			}
			
			replacement.leftChild = focusNode.leftChild;
		}
		
		return true;
	}
	
	/**
	 * 
	 * @param replacedNode is the Node to be replace
	 * @return
	 */
	public Node getReplacementNode(Node replacedNode) {
		Node replacementParent = replacedNode;
		Node replacement = replacedNode;
		
		// Moving the right child up
		Node focusNode = replacedNode.rightChild;
		
		while(focusNode != null) {
			// While they are no more left child Nodes keep going
			replacementParent = replacement;
			replacement = focusNode;
			
			// Moving the left child up
			focusNode = focusNode.leftChild;
		}
		
		if(replacement != replacedNode.rightChild) {
			replacementParent.leftChild = replacement.rightChild;
			replacement.rightChild = replacedNode.rightChild;
		}
		
		return replacement;
	}
	

	/**
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
	 * For example, this binary tree is symmetric:
	 *     1
	 *    / \
	 *   2   2
	 *  / \ / \
	 * 3  4 4  3
	 * 
	 * But the following is not:
	 *     1
	 *    / \
	 *   2   2
	 *    \   \
	 *    3    3
	 * 
	 * Note:  Bonus points if you could solve it both recursively and iteratively.
	 * 
	 * @param root
	 * @return returns true if the binary tree is symmetric i.e mirror image of itself
	 */
	public boolean isSymmetric(Node root) {
		if(root == null) return true;
		
		return isMirrorRecursive(root.leftChild, root.rightChild);
	}
	
	/**
	 * For two binary trees to be mirror images, the following three conditions must be true:
	 * 1. Their root node's key must be the same
	 * 2. The left subtree of left three and right subtree of right tree have to be mirror images
	 * 3. The right subtree of left three and left subtree of right tree have to be mirror images
	 * 
	 * @param leftNode
	 * @param rightNode
	 * @return
	 */
	public boolean isMirrorRecursive(Node leftNode, Node rightNode) {
		if(leftNode == null && rightNode == null) return true;
		if(leftNode == null || rightNode == null) return false;
		
		if(leftNode.key != rightNode.key) return false;
		
		// recursion
		if(!isMirrorRecursive(leftNode.leftChild, rightNode.rightChild)) return false;
		if(!isMirrorRecursive(leftNode.rightChild, rightNode.leftChild)) return false;
		
		return true;
	}
	
	public boolean isMirrorIterative(Node leftNode, Node rightNode) {
		boolean result = false;
		Queue<Node> queue = new LinkedList<>();
		queue.offer(leftNode);
		queue.offer(rightNode);
		
		while(!queue.isEmpty()) {
			Node left = queue.poll();
			Node right = queue.poll();
			
			if(left == null && right == null) {
				result = true;
			} else if(left == null || right == null) {
				// It is required to set result = false here
				result = false;
				break;
			} else if(left != null && right != null) {
				queue.offer(left.leftChild);
				queue.offer(right.rightChild);
				
				queue.offer(left.rightChild);
				queue.offer(right.leftChild);
			}
		}
		
		return result;
	}
	
	public Node mirrorTree(Node focusNode) {
		if(focusNode == null)
			return focusNode;
		
		Node leftNode = mirrorTree(focusNode.leftChild);
		Node rightNode = mirrorTree(focusNode.rightChild);
		
		focusNode.leftChild = rightNode;
		focusNode.rightChild = leftNode;
		
		return focusNode;
	}
}