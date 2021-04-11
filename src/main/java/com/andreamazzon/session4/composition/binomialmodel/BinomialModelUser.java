package com.andreamazzon.session4.composition.binomialmodel;

import com.andreamazzon.session4.usefulmatrices.UsefulMethodsMatricesVectors;

/**
 * This class has methods to get the paths, the simulated value at a given time
 * and the average value at given time of a binomial model: discrete model for a
 * stochastic process S, such that every time i we have S(i+1)=S(i)*M(i), where
 * M(i)=u>1 with probability p and M(i)=d<1 with probability 1-p. This is done
 * under the risk neutral measure: it can be seen that it must hold 
 * p=(1 + r - d)/(u - d), 
 * where r is the risk free interest rate. This is also an example of composition,
 * because the class has a field of type BinomialModelSimulator which simulates
 * the value of S.
 *
 * @author Andrea Mazzon
 *
 */
public class BinomialModelUser {
	private BinomialModelSimulator binomialModelSimulator;// to simulate the values of S

	/*
	 * realizations of S. The matrix will be filled by the getRealizations() method
	 * of binomialModelSimulator
	 */
	private double[][] realizations;

	// constructor: based on the one of BinomialModelSimulator.
	public BinomialModelUser(double initialValue, double increaseIfUp, double decreaseIfDown, double interestRate, int seed,
			int lastTime, int numberOfSimulations) {

		binomialModelSimulator = new BinomialModelSimulator(initialValue, increaseIfUp, decreaseIfDown, interestRate,
				seed, lastTime, numberOfSimulations);
	}

	// overloaded constructor: if not specified, the interest rate is zero. Note the use of this!
	public BinomialModelUser(double initialValue, double increaseIfUp, double decreaseIfDown, int seed, int lastTime,
			int numberOfSimulations) {
		this(initialValue, increaseIfUp, decreaseIfDown, 0, seed, lastTime, numberOfSimulations);
	}

	// overloaded constructor: if not specified, the seed is 1897. Note the use of this!
	public BinomialModelUser(double initialValue, double increaseIfUp, double decreaseIfDown, int lastTime,
			int numberOfSimulations) {
		this(initialValue, increaseIfUp, decreaseIfDown, 0, 1897, lastTime, numberOfSimulations);
	}

	// the realizations are generated with DELEGATION to the method of binomialModelSimulator
	private void generateRealizations() {
		if (realizations == null) {// generated only once!
			realizations = binomialModelSimulator.getRealizations();
		}
	}

	/**
	 * @param time, the time i such that the simulated values of S(i) are returned
	 * @return the simulated values of S at time time.
	 */
	public double[] getRealizationsAtGivenTime(int time) {
		generateRealizations();// realizations generated only when needed: lazy initialization
		return UsefulMethodsMatricesVectors.getRow(realizations, time);
	}

	/**
	 * It prints the vector of realizations at time time.
	 *
	 * @param time, the time i such that the simulated values of S(i) are printed
	 */
	public void printRealizationsAtGivenTime(int time) {
		UsefulMethodsMatricesVectors.printVector(getRealizationsAtGivenTime(time));
	}

	/**
	 * @param simulationIndex, the index of the simulation for which the path is
	 *                         returned
	 * @return the path of S for the specific simulation index
	 */
	public double[] getPath(int simulationIndex) {
		generateRealizations();// realizations generated only when needed: lazy initialization
		return UsefulMethodsMatricesVectors.getColumn(realizations, simulationIndex);
	}

	/**
	 * it prints the path of S for the specific simulation index
	 *
	 * @param simulationIndex, the index of the simulation for which the path is
	 *                         returned
	 */
	public void printPath(int simulationIndex) {
		UsefulMethodsMatricesVectors.printVector(getPath(simulationIndex));
	}

	/**
	 * @param time, the time i such that the simulated values of S(i) are returned
	 * @return the average of S at time time.
	 */
	public double getAverageAtGiveTime(int time) {
		return UsefulMethodsMatricesVectors.getAverage(getRealizationsAtGivenTime(time));
	}

}