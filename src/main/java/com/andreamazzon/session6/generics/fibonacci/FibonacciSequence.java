package com.andreamazzon.session6.generics.fibonacci;

import com.andreamazzon.session6.generics.genericinterfaces.GenericNext;

/**
 * This class implements the generic interface GenericPointer, for type Integer:
 * for objects of this class, the next() method returns and Integer. If called
 * iteratively, this method helps returning the first numbers of a Fibonacci
 * sequence.
 *
 * @author Andrea Mazzon
 *
 */
public class FibonacciSequence implements GenericNext<Integer> {// I give the type of the type returned in next()
	private int count = 1;

	/**
	 * It returns the Fibonacci number F_k, k=count where count is a field of the
	 * class, and set count = count + 1.
	 */
	@Override
	public Integer next() {
		return computeFibonacci(count++);
	}

	/*
	 * This method computes and return the Fibonacci number F_n=F_{n-1}+F_{n-2}, if
	 * n>2, or 1 when n<= 2
	 */
	private int computeFibonacci(int n) {
		if (n < 3) {
			return 1;
		}
		return computeFibonacci(n - 2) + computeFibonacci(n - 1);
	}

}
