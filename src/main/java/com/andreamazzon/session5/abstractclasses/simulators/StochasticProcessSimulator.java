package com.andreamazzon.session5.abstractclasses.simulators;

/**
 * This is an abstract class for the simulation of a general stochastic process, whose realizations
 * are stored in a two-dimensional array: a row i gives the realizations of the process for a fixed time
 * t(i), so it represents a random variable (we will see in some weeks how to implement a random
 * variable in the finmath library) whereas a column j represents the path of the process for a state of
 * the world omega(j).
 * Note that the implementation of the method getRealizations(), returning a double[][], is given: if
 * the protected double[][] field realizations has not been initialized it calls the protected, abstract method
 * generateRealizations() and return the value of  realizations generated in this way, otherwise it directly
 * returns it. The implementation of  generateRealizations() is not given, since it depends on the specific
 * type of the process, and for this reason the method is abstract.
 *
 * @author AndreaMazzon
 *
 */
public abstract class StochasticProcessSimulator implements StochasticProcessSimulatorInterface
{
	/*
	 * the matrix of realizations of S. It is protected, so it can be initialized by the specific implementation
	 * of generateRealizations() in the derived classes.
	 */
	protected double[][] realizations;

	protected double initialValue; //S(0)
	protected int numberOfSimulations; //number of simulated values at every time
	protected int lastTime;

	//the generation of S, depending on the one of the process M of ups and downs
	protected abstract void generateRealizations();

	/**
	 *
	 * @return the matrix of the realization of the process S
	 */
	@Override
	public double[][] getRealizations() {
		//lazy initialization: realizations are generated only when needed, i.e., when we want to get them
		if (realizations == null) {//moreover, we generate them only once
			//implementation of the method which is of course specific of every process, i.e., of every derived class
			generateRealizations();
		}
		return realizations;
	}
}

