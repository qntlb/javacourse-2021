package com.andreamazzon.session5.abstractclasses.simulators;

import com.andreamazzon.session3.encapsulation.lazyinitialization.LinearCongruentialGenerator;

/**
 * This class is used in order to simulate some paths of a binomial model:
 * discrete model for a stochastic process S, such that every time i we have
 * S(i+1)=S(i)*M(i), where M(i)=u>1 with probability p and M(i)=d<1 with
 * probability 1-p. This is done under the risk neutral measure: it can be seen
 * that it must hold p=(1 + r - d)/(u - d), where r is the risk free interest
 * rate. This serves as an example of composition combined to inheritance: the
 * class has an object of type LinearCongruentialGenerator, which is used to
 * generate the realizations M(i), and inherits from the abstract class
 * StochasticProcessSimulator, where the implementation of getRealizations() is
 * given. The realizations of a row are realizations of a random variable. We
 * will see how it is implemented in the Finmath library.
 *
 * @author AndreaMazzon
 *
 */

//S[i][j]=S(i,omega(j))
public class BinomialModelSimulator extends StochasticProcessSimulator {

	private double increaseIfUp; // this is u>1
	private double decreaseIfDown; // this is d<1
	private double riskNeutralProbabilityUp; // will be equal to (1 + interestRate - decreaseIfDown)/(increaseIfUp -
												// decreaseIfDown)
	private double[][] upsAndDowns; // the matrix of realizations of M

	// imported!
	private LinearCongruentialGenerator randomGenerator; // composition! We will use this object to simulate the values
															// of M

	public BinomialModelSimulator(double initialValue, double increaseIfUp, double decreaseIfDown, double interestRate,
			int seed, int lastTime, int numberOfSimulations) {
		this.initialValue = initialValue;
		this.increaseIfUp = increaseIfUp;
		this.decreaseIfDown = decreaseIfDown;
		riskNeutralProbabilityUp = (1 + interestRate - decreaseIfDown) / (increaseIfUp - decreaseIfDown);
		this.lastTime = lastTime;// this field is inherited from the abstract class
		this.numberOfSimulations = numberOfSimulations;// this field is inherited from the abstract class
		randomGenerator = new LinearCongruentialGenerator(lastTime * numberOfSimulations, seed);
	}

	// overloaded constructor: if not specified, the interest rate is zero. Note the use of this!
	public BinomialModelSimulator(double initialValue, double increaseIfUp, double decreaseIfDown, int seed,
			int lastTime, int numberOfSimulations) {
		this(initialValue, increaseIfUp, decreaseIfDown, 0, seed, lastTime, numberOfSimulations);
	}

	// overloaded constructor: if not specified, the seed is 1897
	public BinomialModelSimulator(double initialValue, double increaseIfUp, double decreaseIfDown, int lastTime,
			int numberOfSimulations) {
		this(initialValue, increaseIfUp, decreaseIfDown, 0, 1897, lastTime, numberOfSimulations);
	}

	/*
	 * We have to convert the probability, which is a double, into a condition that
	 * can be applied to random natural numbers: we round the multiplication of the
	 * probability to have an upper movement by the maximum number that can be
	 * simulated. Thus, for a given time and a given simulation, if the simulated
	 * number is less that this we will return an up, otherwise a down
	 */
	private double convert() {
		// modulus is private, but we have the getter
		return riskNeutralProbabilityUp * randomGenerator.getModulus();
	}

	/*
	 * Generation of the process of ups and downs, i.e., M such that S(i+1) =
	 * S(i)*M(i). We have upsAndDowns[i][j]=M(i,omega(j)). upsAndDowns[i][j] = u if
	 * randomGenerator.getNextInteger() < threshold, = d if
	 * randomGenerator.getNextInteger() >= threshold. We ask indeed randomGenerator
	 * to generate a sequence of random numbers whose length is equal to
	 * finalTime*numerbOfSimulations.
	 */
	private double[][] generateUpsAndDowns() {
		// rows are simulation at given time, columns paths
		upsAndDowns = new double[lastTime][numberOfSimulations];
		double threshold = convert();// when the simulated number is less than this, we have up
		// double for loop, time and simulations
		for (int timeIndex = 0; timeIndex < lastTime; timeIndex++) {
			for (int simulationIndex = 0; simulationIndex < numberOfSimulations; simulationIndex++) {
				long randomNumber = randomGenerator.getNextInteger();
				// the way we convert the probability into a condition on the generated numbers
				if (randomNumber < threshold) {
					upsAndDowns[timeIndex][simulationIndex] = increaseIfUp;
				} else {
					upsAndDowns[timeIndex][simulationIndex] = decreaseIfDown;
				}
			}
		}
		return upsAndDowns;
	}

	/**
	 * It generates the realizations of the process S, depending on the one of the
	 * process M of ups and downs.
	 */
	/*
	 * Note that the implementation is the same as in BinomialModel. One could then
	 * define another abstract class MultinomialModelSimulator, extending
	 * StochasticProcessSimulator, where the implementation of this method is given.
	 * Then TrinomialModelGenerator and BinomialModelGenerator inherit from that.
	 * Exercise?
	 */
	@Override // it overrides the abstract method of the base class! It gives its specific implementation
	protected void generateRealizations() {
		// lastTime + 1 rows because the first hosts the initial value
		realizations = new double[lastTime + 1][numberOfSimulations];
		generateUpsAndDowns();// will be called only once
		// a first for loop the fill the first row
		for (int simulationIndex = 0; simulationIndex < numberOfSimulations; simulationIndex++) {
			realizations[0][simulationIndex] = initialValue;
		}
		// double for loop for the realizations. We start from time 1
		for (int timeIndex = 1; timeIndex <= lastTime; timeIndex++) {
			for (int simulationIndex = 0; simulationIndex < numberOfSimulations; simulationIndex++) {
				realizations[timeIndex][simulationIndex] = realizations[timeIndex - 1][simulationIndex]
						* upsAndDowns[timeIndex - 1][simulationIndex];
			}
		}
	}
}