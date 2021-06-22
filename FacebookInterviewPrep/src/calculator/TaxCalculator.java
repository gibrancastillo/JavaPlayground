package calculator;

/*
Given an income and a set of tax brackets, calculate the amount of tax owed.

Example:

brackets = [ 
    [5000, 0],    remaining $50,000    $0
    [10000, 0.1], remaining $40,000    $1,000
    [20000, 0.2], remaining $20,000    $4,000
    [10000, 0.3], remaining $10,000    $3,000
    [null, 0.4],  remaining $0         $4,000
]                 Total tax            $12,000


Indicates that:

* The first $5K is untaxed
* The next $10K is taxed at 10%
* The next $20K is taxed at 20%
* The next $10K is taxed at 30%
* All income above this is taxed at 40%

So, for an income of $55K, the tax would be $0K + $1K + $4K + $3K + $4K = $12K.
*/
public class TaxCalculator {

	public static void main(String[] args) {
		double income = 55000.00;
		Double[][] brackets = { { Double.valueOf(5000),  Double.valueOf(0)   }, 
				                { Double.valueOf(10000), Double.valueOf(0.1) }, 
				                { Double.valueOf(20000), Double.valueOf(0.2) }, 
				                { Double.valueOf(10000), Double.valueOf(0.3) }, 
				                { null,                  Double.valueOf(0.4) }
				              };
		
		double taxOwed = calculateTaxOwed(income, brackets);
		System.out.println("\nWith an income of $" + income);
		System.out.println("The amount of tax owed is $" + taxOwed);
	}
	
	private static double calculateTaxOwed(double income, Double[][] brackets) {
		double tax = 0;
		double remainingIncome = 0;
		double remainingAmount = 0;
		
		if(brackets.length == 1) {
			//tax = income * brackets[0][1];
			tax = (income >= 5000.01) ? ((income - 5000) * brackets[0][1]) : 0.0;
		} else {
			remainingIncome = income;
			for(int row = 0; row < brackets.length; row++) {
				if(brackets[row][0] == null) {
					remainingAmount = remainingIncome;
					tax += remainingAmount * brackets[row][1];
					System.out.println("The remaining income of $" + remainingIncome + " is taxed at " + (brackets[row][1] * 100) + "% which yields a tax of $" + remainingAmount * brackets[row][1]);
				} else if(brackets[row][0] <= 5000.00) {
					remainingIncome -= brackets[row][0];
					tax = brackets[row][0] * brackets[row][1];
					System.out.println("The first $" + brackets[row][0] + " is untaxed because is taxed at " + (brackets[row][1] * 100) + "% which yields a tax owe of $" + tax);
				} else {
					remainingIncome -= brackets[row][0];
					tax += brackets[row][0] * brackets[row][1];
					System.out.println("The next $" + brackets[row][0] + " is taxed at " + (brackets[row][1] * 100) + "% which yields a tax owe of $" + brackets[row][0] * brackets[row][1]);
				}
			}
		}
		
		return tax;
	}
}
