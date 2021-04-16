package com.andreamazzon.session6.generics.fibonacci;

/**
 * This class has a main method when we generate the first n numbers of the
 * Fibonacci sequence. This is done with the help of the next() method of the
 * class FibonacciSequence: for objects of this class, next() returns an Integer
 *
 * @author Andrea Mazzon
 *
 */
public class FibonacciTester {
	public static void main(String[] args) {
		int n = 10;// we want to compute and print the first n numbers of the Fibonacci sequence
		FibonacciSequence fibonacci = new FibonacciSequence();
		System.out.println("First " + n + " numbers of the Fibonacci sequence: ");
		for (int i = 0; i <= n; i++) {
			System.out.println(fibonacci.next() + " ");
		}
	}
}
