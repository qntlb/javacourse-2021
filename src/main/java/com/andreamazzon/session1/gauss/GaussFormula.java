package com.andreamazzon.session1.gauss;

/**
 * In this class we check if the sum of the first n natural numbers computed by the class SumOfIntegers
 * is equal to the Gauss Formula.
 *
 * @author Andrea Mazzon
 */
public class GaussFormula {

	public static void main (String[] args) {

		SumOfIntegers sumOfIntegers = new SumOfIntegers();//new object of type SumOfIntegers

		int lastNumber = 31;
		int sum = sumOfIntegers.sumUpToNumber(lastNumber);//call of the method
		int gaussSum = lastNumber * (lastNumber + 1) / 2;

		System.out.println("\n");
		System.out.println("The sum of the first " + lastNumber + " numbers is " + sum);
		System.out.println("Sum according to Gauss formula: " + gaussSum);
	}
}
