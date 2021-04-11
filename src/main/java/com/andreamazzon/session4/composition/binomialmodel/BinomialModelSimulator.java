package com.andreamazzon.session4.composition.binomialmodel;

import com.andreamazzon.session3.encapsulation.lazyinitialization.LinearCongruentialGenerator;

/**
 * This class is used in order to simulate some paths of a binomial model:
 * discrete model for a stochastic process S, such that every time i we have
 * S(i+1)=S(i)*M(i), where M(i)=u>1 with probability p and M(i)=d<1 with
 * probability 1-p. This is done under the risk neutral measure: it can be seen
 * that it must hold p=(1 + r - d)/(u - d), where r is the risk free interest
 * rate. This serves as an example of composition: the class has an object of
 * type LinearCongruentialGenerator, which is used to generate the realizations
 * M(i). Also note that everything is private except the method
 * getRealizations(), which returns a matrix whose rows are all the simulation
 * for a fixed time and the columns are the paths for a given simulation. The
 * realizations of a row are realizations of a random variable. We will see how
 * a random variable can be implemented in the Finmath library.
 *
 */
//S[i][j]=S(i,omega(j))
public class BinomialModelSimulator {
	private double initialValue; // S(0)
	private double increaseIfUp; // this is u>1
	private double decreaseIfDown; // this is d<1
	// it will be equal to (1 + interestRate - decreaseIfDown)/(increaseIfUp - decreaseIfDown)
	private double riskNeutralProbabilityUp; 
	private double[][] realizations; // the matrix of realizations of S
	private double[][] upsAndDowns; // the matrix of realizations of M

	private int lastTime; // last time of the paths
	private int numberOfSimulations; // number of simulated values at every time
	
	// composition! We will use this object to simulate the values of M
	private LinearCongruentialGenerator randomGenerator; 

	public BinomialModelSimulator(double initialValue, double increaseIfUp, double decreaseIfDown, double interestRate,
			int seed, int lastTime, int numberOfSimulations) {
		this.initialValue = initialValue;
		this.increaseIfUp = increaseIfUp;
		this.decreaseIfDown = decreaseIfDown;
		riskNeutralProbabilityUp = (1 + interestRate - decreaseIfDown) / (increaseIfUp - decreaseIfDown);
		this.lastTime = lastTime;
		this.numberOfSimulations = numberOfSimulations;
		randomGenerator = new LinearCongruentialGenerator(lastTime * numberOfSimulations, seed);
	}

	// overloaded constructor: if not specified, the interest rate is zero. Note the use of this!
	public BinomialModelSimulator(double initialValue, double increaseIfUp, double decreaseIfDown, int seed, int lastTime,
			int numberOfSimulations) {
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
	 * simulated. Thus, if the simulated number is less that this we will return an
	 * up, otherwise a down
	 */
	private double convert() {
		// modulus is private, but we have the getter
		return riskNeutralProbabilityUp * (randomGenerator.getModulus() - 1);
	}

	/*
	 * generation of the process of ups and downs, i.e., M such that S(i+1) =
	 * S(i)*M(i)
	 */
	// upsAndDowns[i][j]=M(i,omega(j))
	private void generateUpsAndDowns() {
		// rows are simulation at given time, columns paths
		upsAndDowns = new double[lastTime][numberOfSimulations];
		double threshold = convert();// if the simulated number is less than this, we have up
		// double for loop, time and simulations
		for (int timeIndex = 0; timeIndex < lastTime; timeIndex++) {
			for (int simulationIndex = 0; simulationIndex < numberOfSimulations; simulationIndex++) {
				// the way we convert the probability into a condition on the generated numbers
				if (randomGenerator.getNextInteger() < threshold) {
					upsAndDowns[timeIndex][simulationIndex] = increaseIfUp;
				} else {
					upsAndDowns[timeIndex][simulationIndex] = decreaseIfDown;
				}
			}
		}
	}

	// the generation of S, depending on the one of the process M of ups and downs
	private void generateRealizations() {
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
				// S(i+1)=S(i)M(I)
			}
		}
	}

	/**
	 *
	 * @return the matrix of the realizations of the process S
	 */
	public double[][] getRealizations() {
		
		 // lazy initialization: realizations are generated only when needed, i.e., when
		if (realizations == null) {// moreover, we generate them only once
			generateRealizations();
		}
		return realizations;
	}
}
