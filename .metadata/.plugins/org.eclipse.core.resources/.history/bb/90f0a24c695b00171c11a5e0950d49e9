package com.ccc.playground.bst1;

/**
 * Binary Trees have Nodes, each node usually contains some sort of a key, which is usually the data inside the Node in which information
 * is store.  These Nodes with respect to a Binary Tree can only have a maximum of two children, a left child and right child.
 * 
 * @author Gibran E. Castillo
 *
 */
public class BinaryTree {
	// root Node
	Node root;
	
	public void add(int data) {
		Node nodeToAdd = new Node(data);
		
		if(root == null) {
			// no elements or nodes in the binary tree
			root = nodeToAdd;
		}
		
		/*
		 * How should this BinaryTree react when we add a new node.
		 * We'll create a Binary Search Tree algorithm to decide the best location to add the new node.
		 * if data <node, traverse left child, else traverse right child until we get to a node that we can't
		 * traverse.... insert our new node.
		 */
		traverseAndAddNode(root, nodeToAdd);
		
		
	}
	
	private void traverseAndAddNode(Node node, Node nodeToAdd) {
		if(nodeToAdd.data < node.data) {
			if(node.leftChild == null) {
				nodeToAdd.parent = node;
				// Add new node to current node's as left child node
				node.leftChild = nodeToAdd;
			} else {
				traverseAndAddNode(node.leftChild, nodeToAdd);
			}
		} else if(nodeToAdd.data > node.data) {
			if(node.rightChild == null) {
				nodeToAdd.parent = node;
				// Add new node to current node's as right child node
				node.rightChild = nodeToAdd;
			} else {
				traverseAndAddNode(node.rightChild, nodeToAdd);
			}
		}
	}
	
	/**
	 * 
	 * @param nodeToTraverse
	 */
	public void preOrderTraversal(Node nodeToTraverse) {
		// base line, empty subtree, nothing to traverse
		if(nodeToTraverse == null) {
			return;
		}
		
		System.out.println(nodeToTraverse.data);
		preOrderTraversal(nodeToTraverse.leftChild);
		preOrderTraversal(nodeToTraverse.rightChild);
	}
	
	/**
	 * Sort binary tree in ascending order, from smallest data element to biggest data element
	 * 
	 * @param nodeToTraverse
	 */
	public void inOrderTraversal(Node nodeToTraverse) {
		// base line, empty subtree, nothing to traverse
		if(nodeToTraverse == null) {
			return;
		}
		
		inOrderTraversal(nodeToTraverse.leftChild);
		System.out.println(nodeToTraverse.data);
		inOrderTraversal(nodeToTraverse.rightChild);
	}
	
	public void postOrderTraversal(Node nodeToTraverse) {
		// base line, empty subtree, nothing to traverse
		if(nodeToTraverse == null) {
			return;
		}
		
		postOrderTraversal(nodeToTraverse.leftChild);
		postOrderTraversal(nodeToTraverse.rightChild);
		System.out.println(nodeToTraverse.data);
		
	}
	
	
	public Node getRoot() {
		return root;
	}
	
	public boolean delete(int val) {
		Node nodeToBeDeleted = find(val);
		
		if(nodeToBeDeleted != null) {
			if(nodeToBeDeleted.leftChild == null && nodeToBeDeleted.rightChild == null) {
				deleteCaseOne(nodeToBeDeleted);
			} else if(nodeToBeDeleted.leftChild != null && nodeToBeDeleted.rightChild != null) {
				// case 3:  Node has two children, very hard to delete
				deleteCaseThree(nodeToBeDeleted);
			} else if(nodeToBeDeleted.leftChild != null) {
				// case 2:  Node has one child, where left child should be deleted, difficult to delete.
				deleteCaseTwo(nodeToBeDeleted);
			} else if(nodeToBeDeleted.rightChild != null) {
				// case 2:  Node has one child, where right child should be deleted, difficult to delete.
				deleteCaseTwo(nodeToBeDeleted);
			}
		}
		
		return false;
	}

	private void deleteCaseOne(Node nodeToBeDeleted) {
		/*
		 *  case 1:  Node has no children, easy to delete
		 *  check if the node to be deleted is the left or right child of the parent of the node
		 *             5
		 *  delete--> 1 10
		 *                11
		 */
		if(nodeToBeDeleted.parent.leftChild == nodeToBeDeleted) {
			nodeToBeDeleted.parent.leftChild = null;
		} else if(nodeToBeDeleted.parent.rightChild == nodeToBeDeleted) {
			nodeToBeDeleted.parent.rightChild = null;
		}
	}
	
	private void deleteCaseTwo(Node nodeToBeDeleted) {
		/*
		 *                    50
		 * delete-->        25  75
		 *                10   65 80
		 */
		if(nodeToBeDeleted.parent == null) {
			// pending!!
		} else {
			if(nodeToBeDeleted.parent.leftChild == nodeToBeDeleted) {
				if(nodeToBeDeleted.leftChild != null) {
					nodeToBeDeleted.parent.leftChild = nodeToBeDeleted.leftChild;
				} else if(nodeToBeDeleted.rightChild != null) {
					nodeToBeDeleted.parent.leftChild = nodeToBeDeleted.rightChild;
				}
			} else if(nodeToBeDeleted.parent.rightChild == nodeToBeDeleted) {
				if(nodeToBeDeleted.leftChild != null) {
					nodeToBeDeleted.parent.rightChild = nodeToBeDeleted.leftChild;
				} else if(nodeToBeDeleted.rightChild != null) {
					nodeToBeDeleted.parent.rightChild = nodeToBeDeleted.rightChild;
				}
			}
		}
	}
	
	private void deleteCaseThree(Node nodeToBeDeleted) {
		/*
		 *                    50
		 *                25     75  <-- delete
		 *              10    60    80
		 *                        77  90
		 *  copy to memory -->  76
		 *  
		 *  From the node to be deleted, go right once and then left until you reach the leaf [last node]
		 *  
		 *                     50
		 *                25     76  <-- 75 was deleted/replace with 76.
		 *              10    60    80
		 *                        77  90
		 */
		Node minLeftNode = minLeftTraversal(nodeToBeDeleted.rightChild);
		
		deleteCaseTwo(minLeftNode);
		
		minLeftNode.parent = nodeToBeDeleted.parent;
		minLeftNode.leftChild = nodeToBeDeleted.leftChild;
		minLeftNode.rightChild = nodeToBeDeleted.rightChild;
		
		if(nodeToBeDeleted.parent == null) {
			root = minLeftNode;
		} else {
			if(nodeToBeDeleted.parent.leftChild == nodeToBeDeleted) {
				nodeToBeDeleted.parent.leftChild = minLeftNode;
			} else if(nodeToBeDeleted.parent.rightChild == nodeToBeDeleted) {
				nodeToBeDeleted.parent.rightChild = minLeftNode;
			}
		}
	}
	
	private Node minLeftTraversal(Node node) {
		// base case
		if(node.leftChild == null) {
			return node;
		}
		
		return minLeftTraversal(node.leftChild);
	}
	
	public Node find(int val) {
		if(root != null) {
			return findNode(root, new Node(val));
		}
		
		return null;
	}
	
	private Node findNode(Node search, Node node) {
		// base case
		if(search == null) {
			return null;
		}
		
		if(search.data == node.data) {
			return search;
		} else {
			Node returnNode = findNode(search.leftChild, node);
			
			if(returnNode == null) {
				returnNode = findNode(search.rightChild, node);
			}
			
			return returnNode;
		}
	}
}