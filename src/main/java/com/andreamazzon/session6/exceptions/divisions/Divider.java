package com.andreamazzon.session6.exceptions.divisions;

import java.util.ArrayList;

/**
 * This class has a static void Divide method which serves as an example of how
 * exceptions are handled and thrown: you start by dividing a double
 * firstDividend by a double divisor. If divisor is zero, you get an exception.
 * Otherwise, you get the result and divide it by divisor and so on, until you
 * reach a number smaller then minResult (and you get an underFlowException) or
 * bigger then maxResult (and you get an overFlowException). Note: with
 * ArrayList you can create an array without fixing its length (you avoid
 * possible exceptions). ArrayList is a generic class.
 *
 * @author Andrea Mazzon
 *
 */
public class Divider {

	static void divide(double firstDividend, double divisor, double minResult, double maxResult)
			throws DivideByZeroException, UnderflowException, OverflowException

	/*
	 * You have to specify the exception than can be thrown: this is part of method
	 * declaration
	 */
	{
		if (divisor == 0) {
			throw new DivideByZeroException();// you create a new object of type DivideByZeroException
		}
		/*
		 * This is a list of Doubles, and as such it does not work with primitive types.
		 * ArrayList works with generics! It is a kind of array, but for example you
		 * don't have to give its length in advance
		 */
		ArrayList<Double> dividends = new ArrayList<Double>();
		/*
		 * add method of ArrayList: it inserts an object of the type specified at the
		 * end of the array
		 */
		dividends.add(firstDividend);
		int i = 0;
		while (true) {// a way to say that it continues indefinitely (true always true)
			// get(i) gets the element of the array in position i (starting from 0!)
			Double result = (dividends.get(i)) / divisor; // you divide the previous number

			if (result <= minResult) { // underFlow!
				throw new UnderflowException();// you create a new object of type UnderFlowException
			}

			if (result >= maxResult) {// overFlow!
				throw new OverflowException();// you create a new object of type OverFlowException
			}

			dividends.add(result); // you insert the result in your array, in the last position (i.e., i+1)
			System.out.println(result);

			i++;
		}
	}
}
