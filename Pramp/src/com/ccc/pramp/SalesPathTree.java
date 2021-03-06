package com.ccc.pramp;

class SalesPathTree {
	static class Node {
		//int key;
		int cost;
		Node[] children;
		Node parent;
		
		Node(int cost) {
			this.cost = cost;
			children = null;
			parent = null;
		}
	}
	
	static class SalesPath {
		
		int getCheapestCost(Node rootNode) {
			// your code goes here
			if(rootNode == null)
				return 0;  // base case
			
			if(rootNode.children == null)
				return rootNode.cost;
			
			int minCost = Integer.MAX_VALUE;
			
			// rootNode
			for(Node n : rootNode.children) {
				int tempCost += getCheapestCost(n);
				
				if(tempCost < minCost)
					minCost = tempCost;
			}
			
			return minCost;
		}
	}
	
	int getCheapestCost1(Node rootNode){
		int minCost = 0;
	    int n = rootNode.children.length;

	    if (n == 0)
	        return rootNode.cost;
	    else {
	        // initialize minCost to the largest integer in the system
	        minCost = Integer.MAX_VALUE;
	          
	        for (int i = 0; i < n; i++) {
	            int tempCost = getCheapestCost1(rootNode.children[i]);
	            if (tempCost < minCost)
	                minCost = tempCost;
	       }
	    }
	    
	    return minCost + rootNode.cost;
	  }
	
	/*********************************************
	 * Driver program to test above method     *
	 *********************************************/
	public static void main(String[] args) {
		Node root = new Node(0);
		root.parent = null;
		root.children = new Node [] { new Node(5), new Node(3), new Node(6) };
		
		root.children[0].children = new Node[] { new Node(4)};
		root.children[1].children = new Node[] { new Node(2), new Node(0)};
		root.children[2].children = new Node[] { new Node(1), new Node(5)};
		
		SalesPath sp = new SalesPath();
		
		System.out.println("Minimal Sales Path Cost " + sp.getCheapestCost(root));
	}
}