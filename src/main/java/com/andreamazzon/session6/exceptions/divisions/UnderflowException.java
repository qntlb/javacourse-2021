package com.andreamazzon.session6.exceptions.divisions;

//Exception is a class, when you write an Exception you extend it

/**
 * Exception writing an exception message: called when an underflow is
 * encountered
 *
 * @author Andrea Mazzon
 *
 */
public class UnderflowException extends Exception { // not an important warning
	public void printExceptionMessage() {// method you want to call when you catch the exception
		System.out.println("I catched an underflow exception");
	}
}
