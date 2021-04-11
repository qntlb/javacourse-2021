package com.andreamazzon.session4.inheritance.goalkeepers;

import static com.andreamazzon.session3.useful.Print.printn;

/**
 * The main method of this class illustrates the basic features of inheritance
 *
 * @author Andrea Mazzon
 *
 */
public class TestClass {
	public static void main(String[] args) {

		printn("First the base class:");
		printn();

		GoalKeeper buffon = new GoalKeeper();
		printn();
		buffon.save();
		printn();
		buffon.checkIfModern();
		printn();
		printn();
		//buffon.playTheBall();//error! this is a method of the derived class only

		printn("Then the derived class:");
		printn();

		ModernGoalKeeper neuer = new ModernGoalKeeper();
		printn();
		neuer.save();
		printn();
		neuer.playTheBall(); //he can
		printn();
		neuer.checkIfModern();
		printn();
		printn();
		
		
		printn("Then reference to the base class, constructor of the derived class");
		printn();

		/*
		 * See what happens if we construct an object with the constructor of the
		 * derived class but giving it a reference to the base class: essentially we are assigning
		 * a derived class object to a parent class reference. This is possible. The object created in
		 * this way cannot call the methods which are specific of the new class. However, it calls
		 * the constructor of the derived class: look at the value of the field isModern, and to the
		 * messages printed in the constructor. 
		 * Note that which constructor to call (i.e., how to call the method constructor) is something
		 * which is resolved at running time.
		 */
		GoalKeeper newGoalKeeper = new ModernGoalKeeper();
		printn();
		newGoalKeeper.save();
		printn();
		//newGoalKeeper.playTheBall(); //he cannot
		newGoalKeeper.checkIfModern();

	}
}
