package com.andreamazzon.session5.abstractclasses.usingsimulators;

/**
 * Interface to get the paths, the simulated value at a given time and the average value
 * at given time of a general stochastic process S.
 *
 * @author Andrea Mazzon
 *
 */
public interface StochasticProcessUserInterface {
	/**
	 * @param time, the time i such that the simulated values of S(i) are returned
	 * @return the simulated values of S at time time.
	 */
	public double[] getRealizationsAtGivenTime(int time);

	/**
	 * It prints the vector of realizations at time time.
	 * @param time, the time i such that the simulated values of S(i) are printed
	 */
	public void printRealizationsAtGivenTime(int time);

	/**
	 * @param simulationIndex, the index of the simulation for which the path is returned
	 * @return the path of S for the specific simulation index
	 */
	double[] getPath(int simulationIndex);

	/**
	 * it prints the path of S for the specific simulation index
	 * @param simulationIndex, the index of the simulation for which the path is returned
	 */
	void printPath(int simulationIndex);

	/**
	 * @param time, the time i such that the simulated values of S(i) are returned
	 * @return the average of S at time time.
	 */
	double getAverageAtGiveTime(int time);
}
