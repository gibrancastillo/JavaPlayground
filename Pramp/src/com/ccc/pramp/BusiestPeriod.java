package com.ccc.pramp;

public class BusiestPeriod {

	static int findBusiestPeriod(int[][] data) {
		// your code goes here
		// O(N) time complexity and O(1) 
		int currMax = 0, num_of_people=0, busiestPeriod = 0;
		
		for(int i = 0; i < data.length; i++) {
			if(data[i][2] == 1)
				num_of_people += data[i][1];
			else if(data[i][2] == 0)
				num_of_people -= data[i][1];
			
			if(num_of_people > currMax) {
				currMax = num_of_people;
				busiestPeriod = data[i][0];
			}
		}
		
		return busiestPeriod;
	}
	
	public static void main(String[] args) {
		int[][] input = { {1487799425, 14, 1}, 
				          {1487799425, 4,  0},
				          {1487799425, 2,  0},
				          {1487800378, 10, 1},
				          {1487801478, 18, 0},
				          {1487801478, 18, 1},
				          {1487901013, 1,  0},
				          {1487901211, 7,  1},
				          {1487901211, 7,  0} };
		
		System.out.println("" + findBusiestPeriod(input));
	}
}

/*
		data[][]

		ttimestamp count isExit
		[1487799425, 14, 1]

		0= exit
		1= entrance


		                 [1487799425, 14, 1],  X = 14
		                 [1487799425, 4,  0],  X = 14-4 --> 10
		                 [1487799425, 2,  0],  x = 10-2 --> 8
		                 [1487800378, 10, 1],  X = 8+10 --> 18  // *** // 
		                 [1487801478, 18, 0],  X = 18-18 --> 0
		                 [1487801478, 18, 1],  X = 0 + 18 --> 18   <--
		                 [1487901013, 1,  0],  X = 18 - 1 --> 17
		                 [1487901211, 7,  1],  X = 17 + 7 --> 24
		                 [1487901211, 7,  0]   X = 17 - 7 --> 10

 */