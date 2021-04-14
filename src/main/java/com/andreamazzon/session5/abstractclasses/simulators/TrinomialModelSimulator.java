package com.andreamazzon.session5.abstractclasses.simulators;

import com.andreamazzon.session3.encapsulation.lazyinitialization.LinearCongruentialGenerator;

/**
 * This class is used in order to simulate some paths of a trinomial model:
 * discrete model for a stochastic process S, such that every time i we have
 * S(i+1)=S(i)*M(i), where M(i)=u>1 with probability p_1, M(i) = 1 with
 * probability p_2, M(i)=d<1 with probability 1-p_1-p_2. This is done under a
 * risk neutral measure: it can be seen that the market is not complete, i.e.,
 * infinitely many risk neutral measures exist, with condition p_1 = (1 + r - d
 * - p_2 * (1 - d)) / (u - d) where r is the risk free interest rate. This
 * serves as an example of composition combined to inheritance: the class has an
 * object of type LinearCongruentialGenerator, which is used to generate the
 * realizations M(i), and inherits from the abstract class
 * StochasticProcessSimulator, where the implementation of getRealizations() is
 * given. The realizations of a row are realizations of a random variable. We
 * will see how it is implemented in the Finmath library.
 *
 * @author AndreaMazzon
 *
 */

//S[i][j]=S(i,omega(j))
public class TrinomialModelSimulator extends StochasticProcessSimulator {
	private double initialValue; // S(0)
	private double increaseIfUp; // this is u>1
	private double decreaseIfDown; // this is d<1
	private double riskNeutralProbabilityUp;
	/*
	 * it is (1 + interestRate - decreaseIfDown - probabilityStayTheSame * (1 -
	 * decreaseIfDown))/(increaseIfUp - decreaseIfDown)
	 */
	private double probabilityStayTheSame; // probability that S(i+1) = S(i)
	private double[][] movements; // the matrix of realizations of M

	// composition! We will use this object to simulate the values of M
	private LinearCongruentialGenerator randomGenerator;

	public TrinomialModelSimulator(double initialValue, double increaseIfUp, double decreaseIfDown, double interestRate,
			double probabilityStayTheSame, int seed, int lastTime, int numberOfSimulations) {
		this.initialValue = initialValue;
		this.increaseIfUp = increaseIfUp;
		this.decreaseIfDown = decreaseIfDown;
		this.probabilityStayTheSame = probabilityStayTheSame;
		riskNeutralProbabilityUp = (1 + interestRate - decreaseIfDown - probabilityStayTheSame * (1 - decreaseIfDown))
				/ (increaseIfUp - decreaseIfDown);
		this.lastTime = lastTime;// the field is inherited from the abstract class
		this.numberOfSimulations = numberOfSimulations;// the field is inherited from the abstract class
		randomGenerator = new LinearCongruentialGenerator(lastTime * numberOfSimulations, seed);
	}

	// overloaded constructor: if not specified, the interest rate is zero. Note the
	// use of this!
	public TrinomialModelSimulator(double initialValue, double increaseIfUp, double decreaseIfDown,
			double probabilityStayTheSame, int seed, int lastTime, int numberOfSimulations) {
		this(initialValue, increaseIfUp, decreaseIfDown, 0, probabilityStayTheSame, seed, lastTime,
				numberOfSimulations);
	}

	// overloaded constructor: if not specified, the seed is 1897
	public TrinomialModelSimulator(double initialValue, double increaseIfUp, double decreaseIfDown,
			double probabilityStayTheSame, int lastTime, int numberOfSimulations) {
		this(initialValue, increaseIfUp, decreaseIfDown, 0, probabilityStayTheSame, 1897, lastTime,
				numberOfSimulations);
	}

	/*
	 * we have to convert the probability, which is a double, into a condition that
	 * can be applied to random natural numbers: we round the multiplication of the
	 * probability to have an upper movement by the maximum number that can be
	 * simulated. Thus, for a given time and a given simulation, if the simulated
	 * number is less that this we will return an up
	 */
	private double convertProbabilityUp() {
		// modulus is private, but we have the getter
		return riskNeutralProbabilityUp * randomGenerator.getModulus();
	}

	/*
	 * here we consider the probability to have an up OR stay the same. Same thing
	 * as before, but we multiply riskNeutralProbabilityUp + probabilityStayTheSame
	 */
	private double convertProbabilityNotDown() {
		// modulus is private, but we have the getter
		return (riskNeutralProbabilityUp + probabilityStayTheSame) * randomGenerator.getModulus();
	}

	/*
	 * Generation of the process of ups and downs, i.e., M such that S(i+1) =
	 * S(i)*M(i). We have upsAndDowns[i][j]=M(i,omega(j)). In particular,
	 * upsAndDowns[i][j] = u ifrandomGenerator.getNextInteger() < thresholdUp,
	 * upsAndDowns[i][j] = 1 if thresholdUp <=randomGenerator.getNextInteger() <=
	 * thresholdDown, upsAndDowns[i][j] = d if randomGenerator.getNextInteger() >
	 * thresholdDown. We ask randomGenerator to generate a sequence of random
	 * numbers whose length is equal to finalTime*numerbOfSimulations.
	 */
	private double[][] generateMovements() {
		// rows are simulation at given time, columns paths
		movements = new double[lastTime][numberOfSimulations];
		// when the simulated number is smaller than this, we have an up movement
		double thresholdUp = convertProbabilityUp();
		// when the simulated number is bigger than this, we have a down movement
		double thresholdNotDown = convertProbabilityNotDown();
		// double for loop, time and simulations
		for (int timeIndex = 0; timeIndex < lastTime; timeIndex++) {
			for (int simulationIndex = 0; simulationIndex < numberOfSimulations; simulationIndex++) {
				double nextRandomNumber = randomGenerator.getNextInteger();
				// the way we convert the probability into a condition on the generated numbers
				if (nextRandomNumber < thresholdUp) {
					movements[timeIndex][simulationIndex] = increaseIfUp;
				} else if (nextRandomNumber > thresholdNotDown) {// note else if!
					movements[timeIndex][simulationIndex] = decreaseIfDown;
				} else {
					movements[timeIndex][simulationIndex] = 1;
				}
			}
		}
		return movements;
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
	@Override
	protected void generateRealizations() {
		// lastTime + 1 rows because the first hosts the initial value
		realizations = new double[lastTime + 1][numberOfSimulations];
		generateMovements();// will be called only once
		// a first for loop the fill the first row
		for (int simulationIndex = 0; simulationIndex < numberOfSimulations; simulationIndex++) {
			realizations[0][simulationIndex] = initialValue;
		}
		// double for loop for the realizations. We start from time 1
		for (int timeIndex = 1; timeIndex <= lastTime; timeIndex++) {
			for (int simulationIndex = 0; simulationIndex < numberOfSimulations; simulationIndex++) {
				realizations[timeIndex][simulationIndex] = realizations[timeIndex - 1][simulationIndex]
						* movements[timeIndex - 1][simulationIndex];
			}
		}
	}
}
