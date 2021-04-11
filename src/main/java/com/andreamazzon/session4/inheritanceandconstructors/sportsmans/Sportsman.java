package com.andreamazzon.session4.inheritanceandconstructors.sportsmans;

import static com.andreamazzon.session3.useful.Print.printn;

/**
 * Parent (or base) class: it has two constructors with different arguments
 *
 * @author Andrea Mazzon
 *
 */
public class Sportsman {

	/*
	 * Without defining a default constructor in the base class, we have to
	 * explicitly call a constructor of the base class, giving it the arguments it
	 * needs. This would have been the same if Sportsman had only one constructor
	 * with arguments and no default constructor.
	 */
	Sportsman(String name) {
		printn("I am a sportsman. My name is " + name);
	}

	Sportsman(String name, String team) {
		printn("I am a sportsman. My name is " + name + " and my team is " + team);
	}

	/*
	 * try to uncomment it: if you do so, you don't need to explicitly call the
	 * super constructor in the derived class
	 */
	// Sportsman() {
	// }
}
