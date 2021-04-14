package com.andreamazzon.session5.abstractclasses.usingsimulators;

/**
 * This class tests the features of the class BinomialModelUser, which is an
 * example of the use of composition and delegation.
 *
 * @author Andrea Mazzon
 *
 */
public class UserTester {

	public static void main(String[] args) {
		double initialValue = 100;
		double increaseIfUp = 1.1;
		double decreaseIfDown = 0.5;
		double interestRate = 0;
		double probabilityStayTheSame = 0.3;

		int seed = 1897;
		int lastTime = 10;
		int numberOfSimulations = 100;
		int simulationIndex = 10;

		BinomialModelUser binomialTester = new BinomialModelUser(initialValue, increaseIfUp, decreaseIfDown,
				interestRate, seed, lastTime, numberOfSimulations);

		System.out.println("Path for simulation " + simulationIndex + " for the binomial model:");
		binomialTester.printPath(simulationIndex);

		double finalAverageBinomial = binomialTester.getAverageAtGiveTime(lastTime);

		System.out.println("Average of the binomial model process at time " + lastTime + ": " + finalAverageBinomial);

		TrinomialModelUser trinomialTester = new TrinomialModelUser(initialValue, increaseIfUp, decreaseIfDown,
				interestRate, probabilityStayTheSame, seed, lastTime, numberOfSimulations);

		System.out.println("Path for simulation " + simulationIndex + " for the trinomial model:");
		trinomialTester.printPath(simulationIndex);

		double finalAverageTrinomial = trinomialTester.getAverageAtGiveTime(lastTime);

		System.out.println("Average of the trinomial model process at time " + lastTime + ": " + finalAverageTrinomial);

	}
}
