/**
 * The code in this package gives an example of a combination of inheritance and composition. Indeed,
 * we have an abstract class StochaticProcessUser which provides the implementation of some methods that
 * can be called to to get the paths, the simulated value at a given time and the average value
 * at given time of a general stochastic process. However, all these methods are based on the generation of
 * the specific values of the process, given by a method generateRealizations() whose implementation
 * cannot be given in this base class, but only in classes that extend it. For this reason, this is
 * defined to be abstract.
 * In this way, we have what we want: the classes BinomialModelUser and TrinomialModelUser inheriting
 * from  StochaticProcessUser directly inherit the methods already implemented there, so that we don't
 * have to rewrite them, and they provide the specific implementation of generateRealizations().
 * They do this by composition: they have a field which is an object of a class that generate the
 * realizations of the specific process, i.e., BinomialModelSimulator and TrinomialModelSimulator.
 */
package com.andreamazzon.session5.abstractclasses.usingsimulators;