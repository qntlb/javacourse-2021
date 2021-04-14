package com.andreamazzon.session5.abstractclasses.usingsimulators;

import com.andreamazzon.session5.abstractclasses.simulators.TrinomialModelSimulator;

/**
 * This class inherits from StochasticProcessUser, which provides methods to get
 * the paths, the simulated value at a given time and the average value at given
 * time of a general stochastic process. Here we consider a trinomial model,
 * i.e., discrete model for a stochastic process S, such that every time i we
 * have S(i+1)=S(i)*M(i), where M(i)=u>1 with probability p_1, M(i) = 1 with
 * probability p_2, M(i)=d<1 with probability 1-p_1-p_2. This is done under A
 * risk neutral measure: it can be seen that the market is not complete, i.e.,
 * infinitely many risk neutral measures exist, with condition p_1 = (1 + r - d
 * - p_2 * (1 - d)) / (u - d) where r is the risk free interest rate. Note that
 * thanks to inheritance we just have to give the implementation of the method
 * generateRealizations(), since the one of the methods returning the paths, the
 * simulated value at a given time and the average value at given time, is
 * already given in the base class. This is also an example of composition,
 * because the class has a field of type BinomialModelSimulator which simulates
 * the value of S.
 *
 * @author Andrea Mazzon
 *
 */
public class TrinomialModelUser extends StochasticProcessUser {
	private TrinomialModelSimulator trinomialModelSimulator;// to simulate the values of S

	// constructor: based on the one of TrinomialModelSimulator.
	public TrinomialModelUser(double initialValue, double increaseIfUp, double decreaseIfDown, double interestRate,
			double probabilityStayTheSame, int seed, int lastTime, int numberOfSimulations) {

		trinomialModelSimulator = new TrinomialModelSimulator(initialValue, increaseIfUp, decreaseIfDown, interestRate,
				probabilityStayTheSame, seed, lastTime, numberOfSimulations);
	}

	// overloaded constructor: if not specified, the interest rate is zero. Note the
	// use of this!
	public TrinomialModelUser(double initialValue, double increaseIfUp, double decreaseIfDown,
			double probabilityStayTheSame, int seed, int lastTime, int numberOfSimulations) {
		this(initialValue, increaseIfUp, decreaseIfDown, 0, probabilityStayTheSame, seed, lastTime,
				numberOfSimulations);
	}

	// overloaded constructor: if not specified, the seed is 1897. Note the use of
	// this!
	public TrinomialModelUser(double initialValue, double increaseIfUp, double decreaseIfDown,
			double probabilityStayTheSame, int lastTime, int numberOfSimulations) {
		this(initialValue, increaseIfUp, decreaseIfDown, 0, probabilityStayTheSame, 1897, lastTime,
				numberOfSimulations);
	}

	// the realizations are generated with DELEGATION to the method of
	// trinomialModelSimulator
	@Override
	protected void generateRealizations() {
		realizations = trinomialModelSimulator.getRealizations();
	}
}