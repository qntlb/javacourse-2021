package com.andreamazzon.session4.composition.car;

import static com.andreamazzon.session3.useful.Print.printn;

/**
 * NOT NICE AT ALL SOLUTION!!!!
 *
 * @author Andrea Mazzon
 *
 */
public class DerivedCar extends Engine{
	private int age; //specific field of this class
	private int horsePower; //specific field of this class

	public DerivedCar(int age, int horsePower) {
		this.age = age;
		this.horsePower = horsePower;
	}
	//specific method of Car
	public void turnRight() {
		printn("Turn right");
	}
	//specific method of Car
	public void turnLeft() {
		printn("Turn left");
	}

}
