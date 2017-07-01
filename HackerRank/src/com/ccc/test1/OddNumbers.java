package com.ccc.test1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OddNumbers {

    static int[] oddNumbers(int l, int r) {
        boolean flag = false;
        List<Integer> oddNumList = new ArrayList<Integer>();
        
        for(int i = l; i <= r; i++) {
            for(int j = 2; j < i; j++) {
                if(i % j == 0) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
            
            if(flag) {
                oddNumList.add(i);
            }
        }
        
        return oddNumList.stream().mapToInt(i -> i).toArray();
    }
    
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(fileName));
			
			int[] res;
			int _l;
			_l = Integer.parseInt(in.nextLine().trim());
			
			int _r;
			_r = Integer.parseInt(in.nextLine().trim());
			
			res = oddNumbers(_l, _r);
			
			for(int res_i=0; res_i < res.length; res_i++) {
				bw.write(String.valueOf(res[res_i]));
				bw.newLine();
			}
			
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
