package com.ccc.graph;

/**
 * A Java Console application which creates a simple undirected graph and then invokes the DFS and BFS traversal of the graph.
 * 
 *                   A
 *                /  |  \
 *               /   |   \
 *              B    C    D
 *            /   \ /
 *           E     F
 * 
 * @author gecasti
 *
 */
public class GraphDemo {
	public static void main(String[] args) {
		//Create nodes as given in graph above
		Node nA = new Node('A');
		Node nB = new Node('B');
		Node nC = new Node('C');
		Node nD = new Node('D');
		Node nE = new Node('E');
		Node nF = new Node('F');
		
		//Create the graph
		Graph g = new Graph();
		
		//Add nodes
		g.addNode(nA);
		g.addNode(nB);
		g.addNode(nC);
		g.addNode(nD);
		g.addNode(nE);
		g.addNode(nF);
		
		//Set root node
		g.setRootNode(nA);
		
		//Create edges between nodes
		g.connectNode(nA, nB);
		g.connectNode(nA, nC);
		g.connectNode(nA, nD);
		
		g.connectNode(nB, nE);
		g.connectNode(nB, nF);
		g.connectNode(nC, nF);
		
		//Perform the traversal of the graph
		System.out.println("Start DFS Traversal of a tree -------------->");
		g.dfs();
		System.out.println("\n<---------------- End DFS Traversal of a tree");
		
		
		System.out.println("\n\nStart BFS Traversal of a tree -------------->");
		g.bfs();
		System.out.println("\n<---------------- End BFS Traversal of a tree");
	}
}