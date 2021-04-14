package com.andreamazzon.session5.abstractclasses.simulators;

/**
 * Interface that every class whose goal is to simulate a stochastic process has to implement
 *
 * @author Andrea Mazzon
 *
 */
public interface StochasticProcessSimulatorInterface {
	double[][] getRealizations();
}
