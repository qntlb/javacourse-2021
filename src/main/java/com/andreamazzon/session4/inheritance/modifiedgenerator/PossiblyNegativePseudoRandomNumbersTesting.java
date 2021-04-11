package com.andreamazzon.session4.inheritance.modifiedgenerator;


import static com.andreamazzon.session3.useful.Print.printn;

import java.util.Arrays;

/**
 * This class tests the derived class LinearCongruentialGeneratorWithNegativeNumbers, which is a
 * linear congruential generator allowing for negative numbers, and inheriting from
 * LinearCongruentialGenerator.
 *
 * @author Andrea Mazzon
 *
 */

public class PossiblyNegativePseudoRandomNumbersTesting {
	public static void main(String[] args) {

		long firstSeed = 1897;//the seed is the first entry of the sequence of pseudo random numbers
		int numberOfPseudoRandomNumbers = 5;

		LinearCongruentialGeneratorWithNegativeNumbers firstGenerator =
				new LinearCongruentialGeneratorWithNegativeNumbers(numberOfPseudoRandomNumbers, firstSeed);

		long[] sequenceGeneratedByTheFirstObject = firstGenerator.getRandomNumberSequence();

		printn("Simulation of " + numberOfPseudoRandomNumbers + " integers with seed " + firstSeed
				+ " : " + Arrays.toString(sequenceGeneratedByTheFirstObject));

		printn();

		printn("First four numbers of the random sequence, excluded the seed:");
		//maybe the user is not interested to have all the sequence, but only in the first numbers
		for (int i = 0; i < numberOfPseudoRandomNumbers - 1; i ++) {
			printn(firstGenerator.getNextInteger());
		}

		printn();

		long secondSeed = 8L;

		LinearCongruentialGeneratorWithNegativeNumbers secondGenerator =
				new LinearCongruentialGeneratorWithNegativeNumbers(numberOfPseudoRandomNumbers, secondSeed);

		long[] sequenceGeneratedByTheSecondObject = secondGenerator.getRandomNumberSequence();

		printn("Simulation of " + numberOfPseudoRandomNumbers + " integers with seed " + secondSeed
				+ " : " + Arrays.toString(sequenceGeneratedByTheSecondObject));
	}
}

