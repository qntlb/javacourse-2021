package com.andreamazzon.session5.abstractclasses.usingsimulators;

import com.andreamazzon.session5.abstractclasses.simulators.BinomialModelSimulator;

/**
 * This class inherits from StochasticProcessUser, which provides methods to get
 * the paths, the simulated value at a given time and the average value at given
 * time of a general stochastic process. Here we consider a binomial model,
 * i.e., discrete model for a stochastic process S, such that for every time i
 * we have S(i+1)=S(i)*M(i), where M(i)=u>1 with probability p and M(i)=d<1 with
 * probability 1-p. This is done under the risk neutral measure: it can be seen
 * that it must hold p=(1 + r - d)/(u - d), where r is the risk free interest
 * rate. Note that thanks to inheritance we just have to give the implementation
 * of the method generateRealizations(), since the one of the methods returning
 * the paths, the simulated value at a given time and the average value at given
 * time, is already given in the base class. This is also an example of
 * composition, because the class has a field of type BinomialModelSimulator
 * which simulates the value of S.
 *
 * @author Andrea Mazzon
 *
 */
public class BinomialModelUser extends StochasticProcessUser {
	private BinomialModelSimulator binomialModelSimulator;// to simulate the values of S

	// constructor: based on the one of BinomialModelSimulator.
	public BinomialModelUser(double initialValue, double increaseIfUp, double decreaseIfDown, double interestRate,
			int seed, int lastTime, int numberOfSimulations) {

		binomialModelSimulator = new BinomialModelSimulator(initialValue, increaseIfUp, decreaseIfDown, interestRate,
				seed, lastTime, numberOfSimulations);
	}

	// overloaded constructor: if not specified, the interest rate is zero. Note the
	// use of this!
	public BinomialModelUser(double initialValue, double increaseIfUp, double decreaseIfDown, int seed, int lastTime,
			int numberOfSimulations) {
		this(initialValue, increaseIfUp, decreaseIfDown, 0, seed, lastTime, numberOfSimulations);
	}

	// overloaded constructor: if not specified, the seed is 1897. Note the use of
	// this!
	public BinomialModelUser(double initialValue, double increaseIfUp, double decreaseIfDown, int lastTime,
			int numberOfSimulations) {
		this(initialValue, increaseIfUp, decreaseIfDown, 0, 1897, lastTime, numberOfSimulations);
	}

	// the realizations are generated with DELEGATION to the method of
	// binomialModelSimulator
	@Override
	protected void generateRealizations() {
		realizations = binomialModelSimulator.getRealizations();
	}
}