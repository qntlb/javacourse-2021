package com.andreamazzon.session5.abstractclasses.usingsimulators;

import com.andreamazzon.session4.usefulmatrices.UsefulMethodsMatricesVectors;

/**
 * This class has methods to get the paths, the simulated value at a given time
 * and the average value at given time of a general stochastic process S. The
 * implementation of the methods doing this is given, but is based on the
 * generation of the realizations of the process. Since this is based on the
 * specific type of the process, it gets implemented in the derived classes and
 * is therefore abstract.
 *
 * @author Andrea Mazzon
 *
 */
public abstract class StochasticProcessUser implements StochasticProcessUserInterface {

	// realizations of S. The matrix will be filled by the getRealizations() method
	protected double[][] realizations;

	// specific for every process!
	protected abstract void generateRealizations();

	/**
	 * @param time, the time i such that the simulated values of S(i) are returned
	 * @return the simulated values of S at time time.
	 */
	@Override
	public double[] getRealizationsAtGivenTime(int time) {
		// realizations generated only when needed: lazy initialization
		if (realizations == null) {
			generateRealizations();// and only once
		}
		return UsefulMethodsMatricesVectors.getRow(realizations, time);
	}

	/**
	 * It prints the vector of realizations at time time.
	 *
	 * @param time, the time i such that the simulated values of S(i) are printed
	 */
	@Override
	public void printRealizationsAtGivenTime(int time) {
		UsefulMethodsMatricesVectors.printVector(getRealizationsAtGivenTime(time));
	}

	/**
	 * @param simulationIndex, the index of the simulation for which the path is
	 *                         returned
	 * @return the path of S for the specific simulation index
	 */
	@Override
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
	@Override
	public void printPath(int simulationIndex) {
		UsefulMethodsMatricesVectors.printVector(getPath(simulationIndex));
	}

	/**
	 * @param time, the time i such that the simulated values of S(i) are returned
	 * @return the average of S at time time.
	 */
	@Override
	public double getAverageAtGiveTime(int time) {
		return UsefulMethodsMatricesVectors.getAverage(getRealizationsAtGivenTime(time));
	}

}
