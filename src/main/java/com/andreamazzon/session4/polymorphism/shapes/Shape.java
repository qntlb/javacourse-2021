package com.andreamazzon.session4.polymorphism.shapes;

/**
 * This is a base class from which the three classes Circle, Square and Triangle inherit. It has a computeArea
 * method which is inherited and implemented from the derived classes.
 */
public class Shape {
	public double computeArea() {
		/*
		 * we have to return a double, even if it does not make sense. On the other hand, the method
		 * is supposed to be called only by classes inheriting from Shape. Next time we will see how
		 * to solve this issue.
		 */
		return -10;
	}
}

