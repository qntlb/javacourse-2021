package com.andreamazzon.session1.primenumbers;

/**
 * This class is used to check if a number is prime
 *
 * @author: Andrea Mazzon
 */
public class Primes {

	public static void main(String[] args) {
		int n = 19;
		PrimesCheck checker = new PrimesCheck();
		boolean result = checker.checkIfPrime(n);
		System.out.println("Is the number " + n + " prime? " + result);
	}
}
