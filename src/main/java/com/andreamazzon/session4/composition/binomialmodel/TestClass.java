package com.andreamazzon.session4.composition.binomialmodel;

/**
 * This class tests the features of the class BinomialModelUser, which is an example of the use of
 * composition and delegation.
 *
 * @author Andrea Mazzon
 *
 */
public class TestClass {

	public static void main(String[] args) {
		double initialValue = 100;
		double increaseIfUp = 2;
		double decreaseIfDown = 0.5;
		double interestRate = 0;

		int seed = 1897;
		int lastTime = 10;
		int numberOfSimulations = 1000000;
		int simulationIndex = 10;

		BinomialModelUser tester = new BinomialModelUser(initialValue, increaseIfUp, decreaseIfDown, interestRate, seed,
				lastTime, numberOfSimulations);

		System.out.println("Path for simulation " + simulationIndex + ":");
		tester.printPath(simulationIndex);

		double finalAverage = tester.getAverageAtGiveTime(lastTime);

		System.out.println("Average of the process at time " + lastTime + ": " + finalAverage);

	}
}
