package com.ccc.pramp;

public class SudokuSolver {
	
	public static void main(String[] args) {
		/*
		 * The board setter provides a partially completed board,
		 * which for a well-posed board has a unique solution.
		 * 0 means unassigned cells. 
		 */
		int[][] board = {
						{5, 3, 0, 0, 7, 0, 0, 0, 0}, 
						{6, 0, 0, 1, 9, 5, 0, 0, 0}, 
						{0, 9, 8, 0, 0, 0, 0, 6, 0}, 
						{8, 0, 0, 0, 6, 0, 0, 0, 3}, 
						{4, 0, 0, 8, 0, 3, 0, 0, 1}, 
						{7, 0, 0, 0, 2, 0, 0, 0, 6}, 
						{0, 6, 0, 0, 0, 0, 2, 8, 0}, 
						{0, 0, 0, 4, 1, 9, 0, 0, 5}, 
						{0, 0, 0, 0, 8, 0, 0, 7, 9}
					};
		
		printSudoku(board);
		System.out.println();
		
		if(sudokuSolve(board) == true)
			printSudoku(board);
		else
			System.out.println("No solution exists");
		
		System.out.println("\n");
		
		int[][] grid = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}};
		
		printSudoku(grid);
		System.out.println();
		
		if(sudokuSolve(grid) == true)
			printSudoku(grid);
		else
			System.out.println("No solution exists");
		
		//System.out.print("\n\n" + isValidSudoku(board));
	}
	
	static void printSudoku(int[][] board) {
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board.length; col++)
				System.out.print(" " + board[row][col]);
			System.out.println();
		}
	}
	
	/**
	 * Recursive Sudoku Solver
	 * 
	 * @param board
	 * @return
	 */
	static boolean sudokuSolve(int[][] board) {
		if(board == null || board.length != 9 || board[0].length != 9)
			return false;
		
		int[] unassignedLocation = findUnassignedLocation(board);
		boolean isUnassignedLocation = unassignedLocation[0] == 1 ? true : false;
		int row = unassignedLocation[1], col = unassignedLocation[2];
		
		/*
		 * If there is no unassigned location, we are done
		 * Base Case:  If no empty cell
		 */
		if(!isUnassignedLocation)
			return true;
		
		// consider digits 1 to 9:  [1,2,3,4,5,6,7,8,9]
		for(int num = 1; num <= 9; num++) {
			
			// Is the current cell a possible candidate to assign a num? 
			if(isPossibleCandidate(board, row, col, num)) {
				// make tentative assignment
				board[row][col] = num;
				
				// return true if success, yay!
				if(sudokuSolve(board))
					return true;
				
				// failure, unmake and try again.  mark cell as empty (with 0)  
				board[row][col] = 0;
			}
		}
		
		// trigger backtracking
		return false;
	}
	
	/**
	 * Searches the grid to find an entry that is still unassigned. If found, the reference parameters row, col will
	 * be set the location that is unassigned, and true is returned. If no unassigned entries remain, false is returned.
	 * 
	 * @param board
	 * @param row
	 * @param col
	 * @return
	 */
	static int[] findUnassignedLocation(int[][] board) {
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board[0].length; col++) {
				if(board[row][col] == 0)
					return new int[] { 1, row, col };  // true
			}
		}
		
		return new int[] { 0, -1, -1 }; // false
	}
	
	/**
	 * Returns a boolean which indicates whether it will be legal to assign number (num) to the given row, column location.
	 * 
	 * @param board
	 * @param row
	 * @param col
	 * @param num
	 * @return
	 */
	static boolean isPossibleCandidate(int[][] board, int row, int col, int num) {
		/*
		 * modulo % or mod
		 * "9 mod 3" would evaluate to 0 because the division of 9 by 3 has a quotient of 3 and
		 * leaves a remainder of 0; there is nothing to subtract from 9 after multiplying 3 times 3
		 */
		int subGridRow = row - (row % 3);
		int subGridCol = col - (col % 3);
		
		return !rowContains(board, row, num) && !colContains(board, col, num) && !subBoardContains(board, subGridRow, subGridCol, num);
	}
	
	/**
	 * Returns a boolean which indicates whether any assigned entry in the specified row matches the given number.
	 * 
	 * @param board
	 * @param row
	 * @param num
	 * @return
	 */
	static boolean rowContains(int[][] board, int row, int num) {
		for(int col = 0; col < board.length; col++) {
			if(board[row][col] == num)
				return true;
		}
		
		return false;
	}
	
	/**
	 * Returns a boolean which indicates whether any assigned entry in the specified column matches the given number.
	 * 
	 * @param board
	 * @param col
	 * @param num
	 * @return
	 */
	static boolean colContains(int[][] board, int col, int num) {
		for(int row = 0; row < board.length; row++) {
			if(board[row][col] == num)
				return true;
		}
		
		return false;
	}
	
	/**
	 * Returns a boolean which indicates whether any assigned entry within the specified 3x3 box matches the given number.
	 * 
	 * @param board
	 * @param subGridStartRow
	 * @param subGridStartCol
	 * @param num
	 * @return
	 */
	static boolean subBoardContains(int[][] board, int subGridStartRow, int subGridStartCol, int num) {
		for(int row = 0; row < 3; row++) {
			for(int col = 0; col < 3; col++) {
				if(board[row + subGridStartRow][col + subGridStartCol] == num)
					return true;
			}
		}
		
		return false;
	}
	
	
	
	
	/**
	 * Iterative Sudoku Solver
	 * 
	 * @param board
	 * @return
	 */
	static boolean isValidSudoku(int[][] board) {
		if(board == null || board.length != 9 || board[0].length != 9)
			return false;
		
		// check each column
		for(int row = 0; row < board.length; row++) {
			boolean[] m = new boolean[board.length];
			
			for(int col = 0; col < board.length; col++) {
				if(board[row][col] != 0) {
					if(m[board[row][col] - 1])
						return false;
					
					m[board[row][col] - 1] = true;
				}
			}
		}
		
		// check each row
		for(int col = 0; col < board.length; col++) {
			boolean[] m = new boolean[board.length];
			
			for(int row = 0; row < board.length; row++) {
				if(board[row][col] != 0) {
					if(m[board[row][col] - 1])
						return false;
					
					m[board[row][col] - 1] = true;
				}
			}
		}
		
		// check each 3*3 matrix
		for(int block = 0; block < board.length; block++) {
			boolean[] m = new boolean[board.length];
			
			for(int row = block / 3 * 3; row < block / 3 * 3 + 3; row++) {
				for(int col = block % 3 * 3; col < block % 3 * 3 + 3; col++) {
					if(board[row][col] != 0) {
						if(m[board[row][col] - 1])
							return false;
						
						m[board[row][col] - 1] = true;
					}
				}
			}
		}
		
		return true;
	}
}