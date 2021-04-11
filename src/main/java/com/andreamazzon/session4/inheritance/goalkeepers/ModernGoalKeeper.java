package com.andreamazzon.session4.inheritance.goalkeepers;

import static com.andreamazzon.session3.useful.Print.printn;

/**
 * This class illustrates one of the uses of inheritance: having the same methods and fields of the parent
 * class - without having to specify them again - plus possibly new methods or fields typical of the derived
 * class.
 *
 * @author Andrea Mazzon
 *
 */
public class ModernGoalKeeper extends GoalKeeper {

	
	ModernGoalKeeper() { //it automatically calls also the constructor of the base class
		printn("But I have also to play the ball");
		isModern = true;
	}
	

	void playTheBall() { // this is a specific method of the derived class
		printn("First I save");
		save();
		printn("I make a good pass for my mitfielder");
	}	
}