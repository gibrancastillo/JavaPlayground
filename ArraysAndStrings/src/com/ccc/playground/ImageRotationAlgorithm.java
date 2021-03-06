package com.ccc.playground;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes [primitive integer],
 * write a method to rotate the image by 90 degrees. Can you do this in place?
 * 
 * @author Gibran E. Castillo
 *
 */
public class ImageRotationAlgorithm {
	
	/**
	 * The rotation can be performed in layers, where you perform a cyclic swap on the edges on each layer.
	 * In the first for loop, we rotate the first layer (outermost edges).
	 * We rotate the edges by doing a four-way swap first on the corners, then on the element clockwise from the edges, then on the element three steps away.
	 * Once the exterior elements are rotated, we then rotate the interior region�s edges.
	 * 
	 * @param matrix
	 * @param n
	 */
	public void rotate(int[][] matrix, int n) {
		/*
		 * layer represents the rows in the 2D array matrix
		 * i represents the columns in the 2D array matrix
		 * int[][] matrix = new int[layer][i];
		 * ++layer Prefix or Pre-Increment, increment layer by 1 and then assign layer's value.
		 * 
		 * Print Matrix before rotation
		 * [row: 0] Top6    2    0    2    2    0    6    8    5   *5
		 * [row: 1]    3    5    2    2    0    4    5    6    7    8
		 * [row: 2]    4    4    1    8    8    7    3    6    0    9
		 * [row: 3]    8    4    5    4    0    7    2    4    3    0
		 * [row: 4]    2    0    2    3    5    4    3    0    2    4
		 * [row: 5]    9    5    6    0    4    5    9    6    3    0
		 * [row: 6]    8    2    8    7    8    3    9    7    1    1
		 * [row: 7]    9    0    4    8    2    6    3    1    3    9
		 * [row: 8]    3    0    1    2    2    3    8    3    5    0
		 * [row: 9]   *3    7    5    5    3    9    5    2    0   *9
		 * 
		 * 
		 * [row: 0]    3 Top2    0    2    2    0    6    8    5    6
		 * [row: 1]    3    5    2    2    0    4    5    6    7   *8
		 * [row: 2]    4    4    1    8    8    7    3    6    0    9
		 * [row: 3]    8    4    5    4    0    7    2    4    3    0
		 * [row: 4]    2    0    2    3    5    4    3    0    2    4
		 * [row: 5]    9    5    6    0    4    5    9    6    3    0
		 * [row: 6]    8    2    8    7    8    3    9    7    1    1
		 * [row: 7]    9    0    4    8    2    6    3    1    3    9
		 * [row: 8]   *3    0    1    2    2    3    8    3    5    0
		 * [row: 9]    9    7    5    5    3    9    5    2   *0    5
		 * 
		 * 
		 * [row: 0]    3    3 Top0    2    2    0    6    8    5    6
		 * [row: 1]    3    5    2    2    0    4    5    6    7    2
		 * [row: 2]    4    4    1    8    8    7    3    6    0   *9
		 * [row: 3]    8    4    5    4    0    7    2    4    3    0
		 * [row: 4]    2    0    2    3    5    4    3    0    2    4
		 * [row: 5]    9    5    6    0    4    5    9    6    3    0
		 * [row: 6]    8    2    8    7    8    3    9    7    1    1
		 * [row: 7]   *9    0    4    8    2    6    3    1    3    9
		 * [row: 8]    0    0    1    2    2    3    8    3    5    0
		 * [row: 9]    9    7    5    5    3    9    5   *2    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9 Top2    2    0    6    8    5    6
		 * [row: 1]    3    5    2    2    0    4    5    6    7    2
		 * [row: 2]    4    4    1    8    8    7    3    6    0    0
		 * [row: 3]    8    4    5    4    0    7    2    4    3   *0
		 * [row: 4]    2    0    2    3    5    4    3    0    2    4
		 * [row: 5]    9    5    6    0    4    5    9    6    3    0
		 * [row: 6]   *8    2    8    7    8    3    9    7    1    1
		 * [row: 7]    2    0    4    8    2    6    3    1    3    9
		 * [row: 8]    0    0    1    2    2    3    8    3    5    0
		 * [row: 9]    9    7    5    5    3    9   *5    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8 Top2    0    6    8    5    6
		 * [row: 1]    3    5    2    2    0    4    5    6    7    2
		 * [row: 2]    4    4    1    8    8    7    3    6    0    0
		 * [row: 3]    8    4    5    4    0    7    2    4    3    2
		 * [row: 4]    2    0    2    3    5    4    3    0    2   *4
		 * [row: 5]   *9    5    6    0    4    5    9    6    3    0
		 * [row: 6]    5    2    8    7    8    3    9    7    1    1
		 * [row: 7]    2    0    4    8    2    6    3    1    3    9
		 * [row: 8]    0    0    1    2    2    3    8    3    5    0
		 * [row: 9]    9    7    5    5    3   *9    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9 Top0    6    8    5    6
		 * [row: 1]    3    5    2    2    0    4    5    6    7    2
		 * [row: 2]    4    4    1    8    8    7    3    6    0    0
		 * [row: 3]    8    4    5    4    0    7    2    4    3    2
		 * [row: 4]   *2    0    2    3    5    4    3    0    2    2
		 * [row: 5]    9    5    6    0    4    5    9    6    3   *0
		 * [row: 6]    5    2    8    7    8    3    9    7    1    1
		 * [row: 7]    2    0    4    8    2    6    3    1    3    9
		 * [row: 8]    0    0    1    2    2    3    8    3    5    0
		 * [row: 9]    9    7    5    5   *3    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2 Top6    8    5    6
		 * [row: 1]    3    5    2    2    0    4    5    6    7    2
		 * [row: 2]    4    4    1    8    8    7    3    6    0    0
		 * [row: 3]   *8    4    5    4    0    7    2    4    3    2
		 * [row: 4]    3    0    2    3    5    4    3    0    2    2
		 * [row: 5]    9    5    6    0    4    5    9    6    3    0
		 * [row: 6]    5    2    8    7    8    3    9    7    1   *1
		 * [row: 7]    2    0    4    8    2    6    3    1    3    9
		 * [row: 8]    0    0    1    2    2    3    8    3    5    0
		 * [row: 9]    9    7    5   *5    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8 Top8    5    6
		 * [row: 1]    3    5    2    2    0    4    5    6    7    2
		 * [row: 2]   *4    4    1    8    8    7    3    6    0    0
		 * [row: 3]    5    4    5    4    0    7    2    4    3    2
		 * [row: 4]    3    0    2    3    5    4    3    0    2    2
		 * [row: 5]    9    5    6    0    4    5    9    6    3    0
		 * [row: 6]    5    2    8    7    8    3    9    7    1    6
		 * [row: 7]    2    0    4    8    2    6    3    1    3   *9
		 * [row: 8]    0    0    1    2    2    3    8    3    5    0
		 * [row: 9]    9    7   *5    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4 Top5    6
		 * [row: 1]   *3    5    2    2    0    4    5    6    7    2
		 * [row: 2]    5    4    1    8    8    7    3    6    0    0
		 * [row: 3]    5    4    5    4    0    7    2    4    3    2
		 * [row: 4]    3    0    2    3    5    4    3    0    2    2
		 * [row: 5]    9    5    6    0    4    5    9    6    3    0
		 * [row: 6]    5    2    8    7    8    3    9    7    1    6
		 * [row: 7]    2    0    4    8    2    6    3    1    3    8
		 * [row: 8]    0    0    1    2    2    3    8    3    5   *0
		 * [row: 9]    9   *7    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7 Top5    2    2    0    4    5    6   *7    2
		 * [row: 2]    5    4    1    8    8    7    3    6    0    0
		 * [row: 3]    5    4    5    4    0    7    2    4    3    2
		 * [row: 4]    3    0    2    3    5    4    3    0    2    2
		 * [row: 5]    9    5    6    0    4    5    9    6    3    0
		 * [row: 6]    5    2    8    7    8    3    9    7    1    6
		 * [row: 7]    2    0    4    8    2    6    3    1    3    8
		 * [row: 8]    0   *0    1    2    2    3    8    3   *5    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0 Top2    2    0    4    5    6    5    2
		 * [row: 2]    5    4    1    8    8    7    3    6   *0    0
		 * [row: 3]    5    4    5    4    0    7    2    4    3    2
		 * [row: 4]    3    0    2    3    5    4    3    0    2    2
		 * [row: 5]    9    5    6    0    4    5    9    6    3    0
		 * [row: 6]    5    2    8    7    8    3    9    7    1    6
		 * [row: 7]    2   *0    4    8    2    6    3    1    3    8
		 * [row: 8]    0    5    1    2    2    3    8   *3    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0    0 Top2    0    4    5    6    5    2
		 * [row: 2]    5    4    1    8    8    7    3    6    2    0
		 * [row: 3]    5    4    5    4    0    7    2    4   *3    2
		 * [row: 4]    3    0    2    3    5    4    3    0    2    2
		 * [row: 5]    9    5    6    0    4    5    9    6    3    0
		 * [row: 6]    5   *2    8    7    8    3    9    7    1    6
		 * [row: 7]    2    3    4    8    2    6    3    1    3    8
		 * [row: 8]    0    5    1    2    2    3   *8    0    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0    0    2 Top0    4    5    6    5    2
		 * [row: 2]    5    4    1    8    8    7    3    6    2    0
		 * [row: 3]    5    4    5    4    0    7    2    4    2    2
		 * [row: 4]    3    0    2    3    5    4    3    0   *2    2
		 * [row: 5]    9   *5    6    0    4    5    9    6    3    0
		 * [row: 6]    5    8    8    7    8    3    9    7    1    6
		 * [row: 7]    2    3    4    8    2    6    3    1    3    8
		 * [row: 8]    0    5    1    2    2   *3    3    0    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0    0    2    5 Top4    5    6    5    2
		 * [row: 2]    5    4    1    8    8    7    3    6    2    0
		 * [row: 3]    5    4    5    4    0    7    2    4    2    2
		 * [row: 4]    3   *0    2    3    5    4    3    0    0    2
		 * [row: 5]    9    3    6    0    4    5    9    6   *3    0
		 * [row: 6]    5    8    8    7    8    3    9    7    1    6
		 * [row: 7]    2    3    4    8    2    6    3    1    3    8
		 * [row: 8]    0    5    1    2   *2    2    3    0    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0    0    2    5    0 Top5    6    5    2
		 * [row: 2]    5    4    1    8    8    7    3    6    2    0
		 * [row: 3]    5   *4    5    4    0    7    2    4    2    2
		 * [row: 4]    3    2    2    3    5    4    3    0    0    2
		 * [row: 5]    9    3    6    0    4    5    9    6    4    0
		 * [row: 6]    5    8    8    7    8    3    9    7   *1    6
		 * [row: 7]    2    3    4    8    2    6    3    1    3    8
		 * [row: 8]    0    5    1   *2    3    2    3    0    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0    0    2    5    0    4 Top6    5    2
		 * [row: 2]    5   *4    1    8    8    7    3    6    2    0
		 * [row: 3]    5    2    5    4    0    7    2    4    2    2
		 * [row: 4]    3    2    2    3    5    4    3    0    0    2
		 * [row: 5]    9    3    6    0    4    5    9    6    4    0
		 * [row: 6]    5    8    8    7    8    3    9    7    5    6
		 * [row: 7]    2    3    4    8    2    6    3    1   *3    8
		 * [row: 8]    0    5   *1    1    3    2    3    0    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0    0    2    5    0    4    4    5    2
		 * [row: 2]    5    1 Top1    8    8    7    3   *6    2    0
		 * [row: 3]    5    2    5    4    0    7    2    4    2    2
		 * [row: 4]    3    2    2    3    5    4    3    0    0    2
		 * [row: 5]    9    3    6    0    4    5    9    6    4    0
		 * [row: 6]    5    8    8    7    8    3    9    7    5    6
		 * [row: 7]    2    3   *4    8    2    6    3   *1    6    8
		 * [row: 8]    0    5    3    1    3    2    3    0    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0    0    2    5    0    4    4    5    2
		 * [row: 2]    5    1    4 Top8    8    7    3    1    2    0
		 * [row: 3]    5    2    5    4    0    7    2   *4    2    2
		 * [row: 4]    3    2    2    3    5    4    3    0    0    2
		 * [row: 5]    9    3    6    0    4    5    9    6    4    0
		 * [row: 6]    5    8   *8    7    8    3    9    7    5    6
		 * [row: 7]    2    3    1    8    2    6   *3    6    6    8
		 * [row: 8]    0    5    3    1    3    2    3    0    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0    0    2    5    0    4    4    5    2
		 * [row: 2]    5    1    4    8 Top8    7    3    1    2    0
		 * [row: 3]    5    2    5    4    0    7    2    8    2    2
		 * [row: 4]    3    2    2    3    5    4    3   *0    0    2
		 * [row: 5]    9    3   *6    0    4    5    9    6    4    0
		 * [row: 6]    5    8    3    7    8    3    9    7    5    6
		 * [row: 7]    2    3    1    8    2   *6    4    6    6    8
		 * [row: 8]    0    5    3    1    3    2    3    0    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0    0    2    5    0    4    4    5    2
		 * [row: 2]    5    1    4    8    6 Top7    3    1    2    0
		 * [row: 3]    5    2    5    4    0    7    2    8    2    2
		 * [row: 4]    3    2   *2    3    5    4    3    8    0    2
		 * [row: 5]    9    3    6    0    4    5    9   *6    4    0
		 * [row: 6]    5    8    3    7    8    3    9    7    5    6
		 * [row: 7]    2    3    1    8   *2    0    4    6    6    8
		 * [row: 8]    0    5    3    1    3    2    3    0    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0    0    2    5    0    4    4    5    2
		 * [row: 2]    5    1    4    8    6    2 Top3    1    2    0
		 * [row: 3]    5    2   *5    4    0    7    2    8    2    2
		 * [row: 4]    3    2    2    3    5    4    3    8    0    2
		 * [row: 5]    9    3    6    0    4    5    9    7    4    0
		 * [row: 6]    5    8    3    7    8    3    9   *7    5    6
		 * [row: 7]    2    3    1   *8    6    0    4    6    6    8
		 * [row: 8]    0    5    3    1    3    2    3    0    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0    0    2    5    0    4    4    5    2
		 * [row: 2]    5    1    4    8    6    2    5    1    2    0
		 * [row: 3]    5    2    8 Top4    0    7   *2    8    2    2
		 * [row: 4]    3    2    2    3    5    4    3    8    0    2
		 * [row: 5]    9    3    6    0    4    5    9    7    4    0
		 * [row: 6]    5    8    3   *7    8    3   *9    3    5    6
		 * [row: 7]    2    3    1    7    6    0    4    6    6    8
		 * [row: 8]    0    5    3    1    3    2    3    0    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0    0    2    5    0    4    4    5    2
		 * [row: 2]    5    1    4    8    6    2    5    1    2    0
		 * [row: 3]    5    2    8    7 Top0    7    4    8    2    2
		 * [row: 4]    3    2    2    3    5    4   *3    8    0    2
		 * [row: 5]    9    3    6   *0    4    5    9    7    4    0
		 * [row: 6]    5    8    3    9    8   *3    2    3    5    6
		 * [row: 7]    2    3    1    7    6    0    4    6    6    8
		 * [row: 8]    0    5    3    1    3    2    3    0    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0    0    2    5    0    4    4    5    2
		 * [row: 2]    5    1    4    8    6    2    5    1    2    0
		 * [row: 3]    5    2    8    7    0 Top7    4    8    2    2
		 * [row: 4]    3    2    2   *3    5    4    0    8    0    2
		 * [row: 5]    9    3    6    3    4    5   *9    7    4    0
		 * [row: 6]    5    8    3    9   *8    3    2    3    5    6
		 * [row: 7]    2    3    1    7    6    0    4    6    6    8
		 * [row: 8]    0    5    3    1    3    2    3    0    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0    0    2    5    0    4    4    5    2
		 * [row: 2]    5    1    4    8    6    2    5    1    2    0
		 * [row: 3]    5    2    8    7    0    3    4    8    2    2
		 * [row: 4]    3    2    2    8 Top5   *4    0    8    0    2
		 * [row: 5]    9    3    6    3   *4   *5    7    7    4    0
		 * [row: 6]    5    8    3    9    9    3    2    3    5    6
		 * [row: 7]    2    3    1    7    6    0    4    6    6    8
		 * [row: 8]    0    5    3    1    3    2    3    0    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0    0    2    5    0    4    4    5    2
		 * [row: 2]    5    1    4    8    6    2    5    1    2    0
		 * [row: 3]    5    2    8    7    0    3    4    8    2    2
		 * [row: 4]    3    2    2    8    4    5    0    8    0    2
		 * [row: 5]    9    3    6    3    5    4    7    7    4    0
		 * [row: 6]    5    8    3    9    9    3    2    3    5    6
		 * [row: 7]    2    3    1    7    6    0    4    6    6    8
		 * [row: 8]    0    5    3    1    3    2    3    0    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 * 
		 * 
		 * 
		 * Original, before rotation:
		 * [row: 0]    6    2    0    2    2    0    6    8    5    5
		 * [row: 1]    3    5    2    2    0    4    5    6    7    8
		 * [row: 2]    4    4    1    8    8    7    3    6    0    9
		 * [row: 3]    8    4    5    4    0    7    2    4    3    0
		 * [row: 4]    2    0    2    3    5    4    3    0    2    4
		 * [row: 5]    9    5    6    0    4    5    9    6    3    0
		 * [row: 6]    8    2    8    7    8    3    9    7    1    1
		 * [row: 7]    9    0    4    8    2    6    3    1    3    9
		 * [row: 8]    3    0    1    2    2    3    8    3    5    0
		 * [row: 9]    3    7    5    5    3    9    5    2    0    9
		 * 
		 * 
		 * End result, after 90 degrees clockwise rotation:
		 * [row: 0]    3    3    9    8    9    2    8    4    3    6
		 * [row: 1]    7    0    0    2    5    0    4    4    5    2
		 * [row: 2]    5    1    4    8    6    2    5    1    2    0
		 * [row: 3]    5    2    8    7    0    3    4    8    2    2
		 * [row: 4]    3    2    2    8    4    5    0    8    0    2
		 * [row: 5]    9    3    6    3    5    4    7    7    4    0
		 * [row: 6]    5    8    3    9    9    3    2    3    5    6
		 * [row: 7]    2    3    1    7    6    0    4    6    6    8
		 * [row: 8]    0    5    3    1    3    2    3    0    7    5
		 * [row: 9]    9    0    9    1    0    4    0    9    8    5
		 * 
		 */
		for(int layer = 0; layer < n / 2; ++layer) {
			int first = layer;
			int last = n - 1 - layer;
			
			for(int i = first; i < last; ++i) {
				int offset = i - first;
				
				// save top
				int top = matrix[first][i];
				
				// left -> top
				matrix[first][i] = matrix[last - offset][first];
				
				// bottom -> left
				matrix[last - offset][first] = matrix[last][last - offset];
				
				// right -> bottom
				matrix[last][last - offset] = matrix[i][last];
				
				// top -> right
				matrix[i][last] = top; // right <- saved top
				
				System.out.println();
				printMatrix(matrix);
			}
		}
	}
	
	/**
	 * Create and populate the matrix elements with random integer values
	 *  
	 * @param M
	 * @param N
	 * @param min
	 * @param max
	 * @return
	 */
	public int[][] randomMatrix(int M, int N, int min, int max) {
		int[][] matrix = new int[M][N];
		
		//System.out.println("matrix[" + M + "][" + N + "]");
		
		for (int rows = 0; rows < M; rows++) {
			//System.out.println("Row " + rows);
			
			for (int cols = 0; cols < N; cols++) {
				matrix[rows][cols] = randomIntInRange(min, max);
				//System.out.println(rows + ", " + cols + " = " + matrix[rows][cols]);
			}
			
			//System.out.println();
		}
		
		return matrix;
	}
	
	/**
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public int randomIntInRange(int min, int max) {
		return randomInt(max + 1 - min) + min;
	}
	
	/**
	 * 
	 * @param n
	 * @return
	 */
	public int randomInt(int n) {
		return (int) (Math.random() * n);
	}
	
	/**
	 * 
	 * @param matrix
	 */
	public void printMatrix(int[][] matrix) {
		for(int rows = 0; rows < matrix.length; rows++) {
			System.out.print("[row: " + rows + "]");
			
			for(int cols = 0; cols < matrix[rows].length; cols++) {
				if(matrix[rows][cols] < 10 && matrix[rows][cols] > -10) {
					System.out.print(" ");
				}
				
				if(matrix[rows][cols] < 100 && matrix[rows][cols] > -100) {
					System.out.print(" ");
				}
				
				if(matrix[rows][cols] >= 0) {
					System.out.print(" ");
				}
				
				System.out.print(" " + matrix[rows][cols]);				
			}
			
			System.out.println();
		}
	}
	
	/**
	 * 
	 * @param agrs
	 */
	public static void main(String[] agrs) {
		ImageRotationAlgorithm imgRotationAlgorithm = new ImageRotationAlgorithm();
		
		int[][] matrix = imgRotationAlgorithm.randomMatrix(10, 10, 0, 9);
		
		System.out.println("\nPrint Matrix before rotation");
		
		imgRotationAlgorithm.printMatrix(matrix);
		imgRotationAlgorithm.rotate(matrix, 10);
		
		//System.out.println("\nPrint Matrix after rotation");
		//imgRotationAlgorithm.printMatrix(matrix);
	}
}