package com.andreamazzon.session4.inheritanceandconstructors.sportsmans;

/**
 * This class tests how inheritance works when the base class has more than one
 * constructor. Note which constructors are called.
 *
 * @author Andrea Mazzon
 *
 */

public class TestConstructors {

	public static void main(String[] args) {

		Sportsman messi = new Sportsman("Leo", "FC Barcelona");// just call the constructor of the base class
		Tennisplayer federer = new Tennisplayer("Roger");

	}
}