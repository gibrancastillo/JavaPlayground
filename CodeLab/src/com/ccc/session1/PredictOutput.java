package com.ccc.session1;

import java.util.ArrayList;

public class PredictOutput {

	public static void main(String[] args) {
		//A : [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12]] 
		ArrayList<Integer> nestedList1 = new ArrayList<Integer>();
		nestedList1.add(1);
		nestedList1.add(2);
		nestedList1.add(3);
		nestedList1.add(4);
		
		ArrayList<Integer> nestedList2 = new ArrayList<Integer>();
		nestedList2.add(5);
		nestedList2.add(6);
		nestedList2.add(7);
		nestedList2.add(8);
		
		ArrayList<Integer> nestedList3 = new ArrayList<Integer>();
		nestedList3.add(9);
		nestedList3.add(10);
		nestedList3.add(11);
		nestedList3.add(12);
		
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		A.add(nestedList1);
		A.add(nestedList2);
		A.add(nestedList3);
		
		System.out.println("Input List A: " + A);
		System.out.println();
		
		ArrayList<ArrayList<Integer>> B = performOps(A);
		
		System.out.println("Output List B: " + B);
		System.out.println();
		
		for(int i = 0; i < B.size(); i++) {
			for(int j = 0; j < B.get(i).size(); j++) {
				System.out.print(B.get(i).get(j) + " ");
			}
		}
	}
	
	public static ArrayList<ArrayList<Integer>> performOps(ArrayList<ArrayList<Integer>> A) {
		ArrayList<ArrayList<Integer>> B = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i < A.size(); i++) {
			B.add(new ArrayList<Integer>());
			
			for(int j = 0; j < A.get(i).size(); j++) {
				B.get(i).add(0);
			}
			
			for(int j = 0; j < A.get(i).size(); j++) {
				B.get(i).set(A.get(i).size() - 1 - j, A.get(i).get(j));
			}
		}
		
		return B;
	}
}