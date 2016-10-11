package com.ccc.threads;

public class ProcessExecution {
	
	public int sumOnlyOddNumbers(int ... numbers) {
	    int oddTotal = 0;
	    for(int num : numbers) {
	        if(num % 2 != 0) {
	        	//oddTotal = oddTotal + num;
	            oddTotal =+ num;
	        }
	    }
	    
	    return oddTotal;
	}
	
	public void testMethod() {
		for(int i = 1; i <= 10; i++) {
			System.out.println("i value: " + i);
		}
	}
	
	public static void main(String[] args) {
		ProcessExecution pe1 = new ProcessExecution();
		//pe1.testMethod();
		//pe1.testMethod();
		//pe1.testMethod();
		
		int total1 = pe1.sumOnlyOddNumbers(1, 2, 7, 30, 5, 13, 22);
		int total2 = pe1.sumOnlyOddNumbers(3, 20, 77, 4);
		
		System.out.println("total1 = " + total1 + "  total2 = " + total2);
		//List<String> list = new ArrayList<String>();
		//list.add(new Integer(2));
	}
}