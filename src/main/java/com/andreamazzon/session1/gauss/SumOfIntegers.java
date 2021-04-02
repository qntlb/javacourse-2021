package com.andreamazzon.session1.gauss;

/**
 * This class uses a simple for loop in order to compute the sum of natural numbers from 1 to a given number
 *
 * @author Andrea Mazzon
 */
public class SumOfIntegers {

	/**
	 * Compute the sum of natural numbers form 1 to lastNumber. As an extra, it also prints all those numbers.
	 *
	 * @param lastNumber: final number of the sum
	 * @return the sum from 1 to lastNumber
	 */
	public int sumUpToNumber(int lastNumber) {
		int sum = 0;
		System.out.println("Looping...");
		for (int i = 0; i <= lastNumber; i++) {
			System.out.print(i + " "); //We use print instead of println: We do not want line breaks!
			sum += i; //sum = sum + i;
		}
		return sum;
	}
}
