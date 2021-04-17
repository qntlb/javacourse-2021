package com.andreamazzon.session5.abstractclasses.simulators;

/**
 * This class tests the features of the class BinomialModelSimulator, which is
 * an example of the use of composition and delegation.
 *
 * @author Andrea Mazzon
 *
 */
public class UserTester {

	public static void main(String[] args) {

		// model related parameters
		double initialValue = 100;
		double increaseIfUp = 2;
		double decreaseIfDown = 0.5;
		double interestRate = 0.3;
		double probabilityStayTheSame = 0.3;

		// simulation related parameters
		int seed = 10;
		int lastTime = 10;
		int numberOfSimulations = 100000;

		/*
		 * Used in order to print the discounted average: we want to check that the
		 * discounted process is a martingale
		 */
		double discountFactor = Math.pow(1 + interestRate, -lastTime);

		// the path we want to print
		int simulationIndex = 10;

		// first the analysis for the binomial model

		BinomialModelSimulator binomialTester = new BinomialModelSimulator(initialValue, increaseIfUp, decreaseIfDown,
				interestRate, seed, lastTime, numberOfSimulations);

		System.out.println("Path for simulation " + simulationIndex + " for the binomial model:");
		System.out.println();
		binomialTester.printPath(simulationIndex);
		System.out.println();

		double finalAverageBinomial = binomialTester.getAverageAtGiveTime(lastTime);
		double discountedAverageBinomial = discountFactor * finalAverageBinomial;

		System.out.println("Discounted average of the process at time " + lastTime + ": " + discountedAverageBinomial);

		// then the analysis for the trinomial model

		TrinomialModelSimulator trinomialTester = new TrinomialModelSimulator(initialValue, increaseIfUp,
				decreaseIfDown, interestRate, probabilityStayTheSame, seed, lastTime, numberOfSimulations);

		System.out.println("Path for simulation " + simulationIndex + " for the trinomial model:");
		System.out.println();
		trinomialTester.printPath(simulationIndex);
		System.out.println();

		double finalAverageTrinomial = trinomialTester.getAverageAtGiveTime(lastTime);
		double discountedAverageTrinomial = discountFactor * finalAverageTrinomial;

		System.out.println("Discounted average of the trinomial model process at time " + lastTime + ": "
				+ discountedAverageTrinomial);

	}
}
