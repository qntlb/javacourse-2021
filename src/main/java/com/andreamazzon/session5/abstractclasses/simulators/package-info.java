/**
 * The classes in this package give a more complex example of inheritance in combination with
 * composition: an abstract class StochasticProcessSimulator is defined, whose aim is the
 * simulation of a general stochastic process. Two classes inherit from this, BinomialModelGenerator
 * and TrinomialModelGenerator. Having an abstract class StochasticProcessSimulator is nice because the
 * implementation of generateRealizations() is theoretically specific of the particular process,
 * so abstract in the base class, whereas the implementation of getRealizations() is general and given
 * in the base class, with no need to rewrite it again.
 * Note however that the implementation of generateRealizations() is the same for BinomialProcessSimulator
 * and TrinomialProcessSimulator, since it only depends on generateMovements().
 * This is actually the same for every discrete process of the same type, i.e., with
 * S(i+1)=M(i)S(i) for some process M.
 * One could then think to create another subclass of this type, extending StochasticProcessSimulator, from
 * which BinomialProcessSimulator TrinomialProcessSimulator inherit. This is a possible exercise.
 */
package com.andreamazzon.session5.abstractclasses.simulators;