package com.andreamazzon.session4.inheritance.goalkeepers;

import static com.andreamazzon.session3.useful.Print.printn;

/**
 * Base class: two fields and one method, which will be inherited from the derived class
 *
 * @author Andrea Mazzon
 *
 */
public class GoalKeeper {

	protected boolean isModern = false;
	
	GoalKeeper() { //constructor: it will be called by the constructor of the derived class
		printn("My task is to prevent the opponent to score");
		//isModern = false;
	}

	//this method will be inherited from the derived class
	protected void save() {
		printn("You will not score");
	}
	
	//this method will be inherited from the derived class
	protected void checkIfModern() {
		printn("Value of the field isModern: " + isModern);
	}

}
