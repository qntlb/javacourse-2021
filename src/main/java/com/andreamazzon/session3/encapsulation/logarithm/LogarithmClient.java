package com.andreamazzon.session3.encapsulation.logarithm;

import static com.andreamazzon.session3.useful.Print.printn;

/**
 * In the main method of this class we see how encapsulation works, preventing the user to obtain
 * unwanted results when computing the logarithm of a number.
 *
 * @author Andrea Mazzon
 *
 */
public class LogarithmClient {

	public static void main(String[] args) {

		LogarithmCalculator logarithmExample = new LogarithmCalculator();
		double inputNumber = -3;
		//logarithmExample.number = inputNumber; //private field!
		logarithmExample.setNumber(inputNumber); //use of setter
		/*
		 * look at was does it happen if inputNUmber is negative: in this case, logarithmExample.number is
		 * not set. However, it is 0.0: this happens because double variables are automatically initialized
		 * to zero when an object of the class is created.
		 */
		printn("Your input number is " + logarithmExample.getNumber()); //use of getter
		printn("The logarithm of " + logarithmExample.getNumber() + " is " +logarithmExample.computeLogarithm());
	}
}