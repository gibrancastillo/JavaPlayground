package com.ccc.honeywell.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BalancedSmileys {
	
    static String[] is_balanced(String[] expression) {
        List<String> outputList = new ArrayList<String>();
        
        if(expression == null) {
            return new String[] {"YES"};
        }
        
        for(int arrIndex = 0; arrIndex < expression.length; arrIndex++) {
            outputList.add(solve(expression[arrIndex]) ? "YES" : "NO");
        }
        
        String[] strArr = new String[outputList.size()];
        
        return outputList.toArray(strArr);
    }
    
    static boolean solve(String line) {
		if (line.isEmpty() || (line.indexOf('(') < 0 && line.indexOf(')') < 0))
			return true;

		int matches = 0, smiles = 0, frowns = 0;

		for (int i=0; i<line.length(); i++) {
			char c = line.charAt(i);
			char prev = i > 0 ? line.charAt(i-1) : ' ';

			if (c == '(')
				matches++;

			if (c == ')')
				matches--;

			if (prev == ':' && c == ')')
				smiles++;

			if (prev == ':' && c == '(')
				frowns++;

			if (matches < 0 && smiles < Math.abs(matches))
				return false;
		}

		if (matches > 0 && frowns < matches)
			return false;

		return true;
	}
	
	public static void main(String[] args) {
		String[] expressions = {"start :):)", "(:)", "today (:()", ")(", ":(("};
		String[] output = is_balanced(expressions);
		
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
		
        /*Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw;
        
		try {
			bw = new BufferedWriter(new FileWriter(fileName));
			
			String[] res;
	        
	        int _expression_size = 0;
	        _expression_size = Integer.parseInt(in.nextLine().trim());
	        String[] _expression = new String[_expression_size];
	        String _expression_item;
	        
	        for(int _expression_i = 0; _expression_i < _expression_size; _expression_i++) {
	            try {
	                _expression_item = in.nextLine();
	            } catch (Exception e) {
	                _expression_item = null;
	            }
	            _expression[_expression_i] = _expression_item;
	        }
	        
	        res = is_balanced(_expression);
	        for(int res_i=0; res_i < res.length; res_i++) {
	            bw.write(String.valueOf(res[res_i]));
	            bw.newLine();
	        }
	        
	        bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	}
}