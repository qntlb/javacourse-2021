package com.andreamazzon.session4.usefulmatrices;

/**
 * Exception is a class, when you write an Exception you extend it. This
 * exception is thrown if two arrays have different length when an operation
 * between them is performed.
 *
 * @author Andrea Mazzon
 */
@SuppressWarnings("serial")
public class DifferentLengthException extends Exception {
	public void print() {
		System.out.println("The arrays have different length");
		// System.exit(0);
	}
}
