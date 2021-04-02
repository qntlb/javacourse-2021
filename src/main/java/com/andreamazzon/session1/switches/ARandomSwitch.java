package com.andreamazzon.session1.switches;

import java.util.Random;

/**
 * Examples of switch statement: it selects among pieces of codes based on the
 * value of an integral expression, i.e., an expression whose result is an
 * integer or a char
 *
 * @author Andrea Mazzon
 */
public class ARandomSwitch {

	public static void main(String[] args) {
		Random randomNumberGenerator = new Random(); // current time as a seed for the random number generator
		int switchValue = randomNumberGenerator.nextInt(7);
		switch (switchValue /* integer between 0 and 6 */ ) {
		/*
		 * The switch compares now the value of switchValue to each value listed below.
		 * If it finds a match, the corresponding statement executes. If no match
		 * occurs, the default statement executes.
		 */
		case 0:
			System.out.println("The selected number is " + 0);
			break; // the break causes execution to jump to the end of the switch body.
		// eliminate breaks: see what happens

		case 2:
			System.out.println("The selected number is " + 2);
			break;

		case 4:
			System.out.println("The selected number is " + 4);
			break;

		case 6:
			System.out.println("The selected number is " + 6);
			break;

		default: // if no match occurs
			System.out.println("The selected number is odd ");
			/*
			 * the last statement, following the default, doesn’t have a break because the
			 * execution just falls through to where the break would have taken it anyway.
			 * You could put a break at the end of the default statement with no harm if you
			 * considered it important for style’s sake.
			 */

		}
	}
}
