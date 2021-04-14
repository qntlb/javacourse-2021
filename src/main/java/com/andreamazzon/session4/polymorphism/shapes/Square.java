package com.andreamazzon.session4.polymorphism.shapes;

/**
 * Particular kind of shape, for which we know how to compute the area, i.e., how to implement the method
 * computeArea().
 *
 * @author Andrea Mazzon
 *
 */
public class Square extends Shape {
	//your implementation of the class here

	private double lengthSide;
	public Square(double lengthSide) {
		this.lengthSide= lengthSide;
	}
	
	/*
	 * Note the @Override annotation: if we use it, we get an error if our method is not overriding a method
	 * of the parent class. This is useful to avoid mistakes (for example we are accidentally changing the name
	 * of the method)
	 */
	@Override
	public double computeArea() {
		System.out.println("Computing the area of this square..");
		return lengthSide*lengthSide;
	}

}
