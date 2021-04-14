package com.andreamazzon.session4.inheritance.modifiedgenerator;

import com.andreamazzon.session3.encapsulation.lazyinitialization.LinearCongruentialGenerator;

/**
 * This class generates pseudo random integers by a linear congruential generator. The difference with
 * LinearCongruentialGenerator is indeed that here we also accept negative numbers. Thus we make this
 * class inherit from LinearCongruentialGenerator, just overriding one method, subtracting modulus from
 * the numbers generated in the method of the parent class. Note that we override the method
 * getRandomNumberSequence() first calling the version of the parent class, and then modifying its output.
 * The call of the version of the parent class is done by super.nameOfTheMethod. 
 * Also note that we don't have not to modify any access modifier of the parent class. It inherits all the
 * other public methods.
 *
 * @author Andrea Mazzon
 *
 */
public class LinearCongruentialGeneratorWithNegativeNumbers extends LinearCongruentialGenerator {

	private int flag = 0;//it gets 1 the first time we subtract modulus from the generated numbers

	//the constructor is just the one of the parent class
	public LinearCongruentialGeneratorWithNegativeNumbers(int numberOfPseudoRandomNumbers, long seed) {
		super(numberOfPseudoRandomNumbers, seed);
	}

	/**
	 * getter method for the sequence of pseudo random integer numbers (they can also be negative).
	 *
	 * @return the sequence of (possibly negative) pseudo random integer numbers
	 */
	@Override
	public long[] getRandomNumberSequence() {
		
		long[] sequence = super.getRandomNumberSequence();//in this way I call the not overloaded method!
		if (flag == 0) { //it has to be done just once
			for (int indexOfInteger = 0; indexOfInteger < getNumberOfPseudoRandomNumbers(); indexOfInteger++) {
				sequence[indexOfInteger] -= getModulus()/2;
			}
			flag = 1;
		}
		return sequence;
	}
}
