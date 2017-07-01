package com.ccc.pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixSpiralCopy {
	
	/**
	 * Time Complexity: iterating over N * M cells, where N is the number of rows and M the number of columns, and copying
	 * them into any array takes O(N * M).  Note that this is a linear time complexity since the size of the input is O(N * M).
	 * 
	 * Space Complexity: we used an auxiliary array of size N * M as a return value, hence the space complexity is O(N * M).
	 * This is a linear space complexity since the size of the input is O(N * M) as well.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = { { 1,  2,  3, 4,   5},
                		   { 6,  7,  8, 9,  10},
                		   {11, 12, 13, 14, 15},
                		   {16, 17, 18, 19, 20} };
		
		System.out.println("**********************************");
		long a = System.currentTimeMillis();
		System.out.println( Arrays.toString(spiralCopy(matrix)) );
		long b = System.currentTimeMillis();
		System.out.println("Perfomrance - time in milliseconds: " + (b - a));
		System.out.println("**********************************");
		
		System.out.println("\n");
		
		System.out.println("**********************************");
		a = System.currentTimeMillis();
		System.out.println( Arrays.toString(spiralCopy1(matrix)) );
		b = System.currentTimeMillis();
		System.out.println("Perfomrance - time in milliseconds: " + (b - a));
		System.out.println("**********************************");

		System.out.println("\n");
		
		System.out.println("**********************************");
		a = System.currentTimeMillis();
		System.out.println( Arrays.toString(spiralOrder(matrix)) );
		b = System.currentTimeMillis();
		System.out.println("Perfomrance - time in milliseconds: " + (b - a));
		System.out.println("**********************************");
	}
	
	/**
	 * This is the 2 indices solution, this can be achieved by counting the number of copied rows and the number of copied columns
	 * from each side. The counter will increment after each two rows (top & bottom) or two columns (right & left) are copied.
	 * 
	 * @param inputMatrix
	 * @return
	 */
	static int[] spiralCopy(int[][] inputMatrix) {
		List<Integer> result = new ArrayList<Integer>();
		
		if(inputMatrix == null || inputMatrix.length == 0) return new int[] { 0 };
		
        int numRow = inputMatrix.length;
        int numCols = inputMatrix[0].length;
        
        int row = 0; 
        int col = 0;
        
        while(numRow > 0 && numCols > 0) {
            //if one row/column left, no circle can be formed
            if(numRow == 1) {
                for(int i = 0; i<numCols; i++)
                    result.add(inputMatrix[row][col++]);
                break;
            } else if(numCols == 1) {
                for(int i = 0; i<numRow; i++)
                    result.add(inputMatrix[row++][col]);
                break;
            }
            
            //below, process a clockwise circle
            
            //top - move right
            for(int i=0;i<numCols-1;i++)
                result.add(inputMatrix[row][col++]);
            
            //right - move down
            for(int i=0;i<numRow-1;i++)
                result.add(inputMatrix[row++][col]);
            
            //bottom - move left
            for(int i=0;i<numCols-1;i++)
                result.add(inputMatrix[row][col--]);
            
            //left - move up
            for(int i=0;i<numRow-1;i++)
                result.add(inputMatrix[row--][col]);
            
            row++;
            col++;
            numRow = numRow - 2;
            numCols = numCols - 2;
        }
		
		return result.stream().mapToInt(i -> i).toArray();
	}
	
	/**
	 * The general idea of the solution is to copy the 4 edges of the spiral rim we currently at and then move on to copy the
	 * next (inner) rim.  We keep doing that until we reached to the end of the spiral. We copy edges in the following order:
	 * Copy the uppermost row from left to right.
	 * Copy the rightmost column from top to bottom.
	 * Copy the lowermost row from right to left.
	 * Copy the leftmost column from bottom to top.
	 * 
	 * This is the 4 indices solution, in order to figure what is the next row/column to copy in
	 * the spiral order we maintain 4 indices: top row, bottom row, left column and right column.
	 * 
	 * @param inputMatrix
	 * @return
	 */
	static int[] spiralCopy1(int[][] inputMatrix) {
		List<Integer> result = new ArrayList<Integer>();
		
		if(inputMatrix == null||inputMatrix.length == 0||inputMatrix[0].length == 0)
			return result.stream().mapToInt(i -> i).toArray();
		
		int numRows = inputMatrix.length;
		int numCols = inputMatrix[0].length;
		
		int topRow = 0;             //index of the the uppermost row to be copied, starting from 0 and incrementing.
		int btmRow = numRows - 1;   //index of the the lowermost row to be copied, starting from numRows-1 and decrementing.
		int leftCol = 0;            //index of the leftmost column to be copied, starting from 0 and incrementing.
		int rightCol = numCols - 1; //index of the the rightmost column to be copied, starting from numCols-1 and decrementing
		
		while(topRow <= btmRow && leftCol <= rightCol) {
			// Copy the next top row, move left to right
			for(int i = leftCol; i <= rightCol; i++)
				result.add(inputMatrix[topRow][i]);
			topRow++;
			
			// copy the next right hand side column, move top to bottom
			for(int i = topRow; i <= btmRow; i++)
				result.add(inputMatrix[i][rightCol]);
			rightCol--;
			
			// copy the next bottom row, move right to left
			if(topRow <= btmRow) {
				for(int j = rightCol; j >= leftCol; j--)
					result.add(inputMatrix[btmRow][j]);
				btmRow--;
			}
			
			// copy the next left hand side column, move bottom to top
			if(leftCol <= rightCol) {
				for(int i = btmRow; i >= topRow; i--)
					result.add(inputMatrix[i][leftCol]);
				leftCol++;
			}
		}
		
		return result.stream().mapToInt(i -> i).toArray();
	}
	
	/**
	 * Recursive solution.  The solution's performance is not better than iterative
	 * solution above (4 indices).  Therefore, solutions above should be preferred.
	 * 
	 * @param matrix
	 * @return
	 */
	public static int[] spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0) 
            return result.stream().mapToInt(i -> i).toArray();
        
        result = spiralOrder(matrix, 0, 0, matrix.length, matrix[0].length);
        
        return result.stream().mapToInt(i -> i).toArray();
    }
	
    public static ArrayList<Integer> spiralOrder(int [][] matrix, int row, int col, int numRows, int numCols){
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(numRows <= 0 || numCols <= 0) 
            return result;
        
        //only one element left
        if(numRows == 1 && numCols == 1) {
            result.add(matrix[row][col]);
            return result;
        }
        
        //top - move right
        for(int i = 0; i < numCols - 1; i++)
            result.add(matrix[row][col++]);
        
        //right - move down
        for(int i = 0; i < numRows - 1; i++)
            result.add(matrix[row++][col]);
        
        //bottom - move left
        if(numRows > 1){    
            for(int i = 0; i < numCols - 1; i++)
                result.add(matrix[row][col--]);
        }
        
        //left - move up
        if(numCols > 1){
            for(int i = 0; i < numRows - 1; i++)
                result.add(matrix[row--][col]);
        }
        
        if(numRows == 1||numCols == 1)
            result.addAll(spiralOrder(matrix, row, col, 1, 1));
        else    
            result.addAll(spiralOrder(matrix, row + 1, col + 1, numRows - 2, numCols - 2));
        
        return result;
    }
}