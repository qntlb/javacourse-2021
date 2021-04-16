package com.andreamazzon.session6.exceptions.divisions;

/**
 * The main method in this class shows you the syntax you use when calling a
 * method that can throw one or more exceptions.
 *
 * @author Andrea Mazzon
 *
 */
public class ExceptionChecker {

	public static void main(String[] args) {
		double maxValue = Double.MAX_VALUE;
		double minValue = 0;
		double firstDividend = 1;
		double divisor = 0.1;
		// you cannot call it in this way, because of possible exceptions
		try {
			Divider.divide(firstDividend, divisor, minValue, maxValue);
		} catch (DivideByZeroException | UnderflowException | OverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/*
		 * The code from which exceptions can derive is surrounded by brackets, after
		 * "try"
		 */
		try {
			Divider.divide(firstDividend, divisor, minValue, maxValue);
		}
		/*
		 * List of the possible exceptions: you have to catch them or throw them as we
		 * did in the class Divider
		 */
		catch (UnderflowException underflowException) {
			/*
			 * you catch the object thrown and you ask it to call the method
			 * printExceptionMessage()
			 */
			underflowException.printExceptionMessage();
		} catch (OverflowException overflowException) {
			overflowException.printExceptionMessage();
		} catch (DivideByZeroException divideByZeroException) {
			divideByZeroException.printExceptionMessage();
		}
	}
}
