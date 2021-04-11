package com.andreamazzon.session4.polymorphism.amphibians;

/**
 * This class tests overriding, upcasting and polimorphism, see the comments in Amphibian.
 */
public class TestClass {


	public static void main(String[] args) {

		Frog frog = new Frog();
		//or:
		//Amphibian frog = new Frog();
		
		System.out.println();
		
		frog.swimming(); // overridden version are called, that is those of Frog
		frog.walking();
		frog.creaking();
		
		System.out.println();
		
		Frog secondfrog = new Frog();

		System.out.println();

		//when it gets upcasted in this following line, it's like we had written
		//Amphibian secondfrog = new Frog();
		Amphibian.behavior(secondfrog); // Upcasting and methods overridden! Returns a frog behaviour!!
		
		System.out.println();
		
		Amphibian amphibian = new Amphibian();
				
		Amphibian.behavior(amphibian);
	}
}