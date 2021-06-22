package com.ccc.easy;

import java.io.*;

public class Staircase {
	public static void main(String[] args) throws IOException {
		/*BufferedReader bufferedReader = new BufferedReader(new
		InputStreamReader(System.in));
		int n = Integer.parseInt(bufferedReader.readLine().trim()); Result.staircase(n);
		bufferedReader.close();*/
		
		staircase(6);
	}

	public static void staircase(int n) {
		//StringBuilder staircase = new StringBuilder();
		
		// Constraints  0 < n <= 100
		/*if (0 < n && n <= 100) {
			for (int row = 0; row < n; row++) {
				// rows in two dimensional array

				for (int col = 0; col < (n - row - 1); col++) {
					// columns for empty spaces
					staircase.append(" ");
				}
				
				for (int col = 0; col < (row + 1); col++) {
					// columns for # symbol(s)
					staircase.append("#");
				}
				
				staircase.append("\n");
			}

			System.out.print(staircase);
		}*/
		
		if(0 < n && n <= 100) {
			for (int i = 1; i <= n; i++) {
		    	System.out.println(new String(new char[n-i]).replace("\0", " ") + new String(new char[i]).replace("\0", "#"));
			}
		}
	}
}

/*class Result {

	public static void staircase(int n) {
		StringBuilder staircase = new StringBuilder();

		if (0 < n && n <= 100) {
			for (int row = 0; row < n; row++) {
				// rows in two dimensional array

				for (int col = 0; col < (n - row - 1); col++) {
					// columns for empty spaces
					staircase.append(" ");
				}

				for (int col = 0; col < row + 1; col++) {
					// columns for # symbol(s)
					staircase.append("#");
				}

				staircase.append("\n");
			}

			System.out.println(staircase);
		}
	}

}*/