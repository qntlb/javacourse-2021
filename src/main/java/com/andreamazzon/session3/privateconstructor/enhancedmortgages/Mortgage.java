package com.andreamazzon.session3.privateconstructor.enhancedmortgages;

/**
 * This class is strictly related to com.andreamazzon.session2.mortgages.Mortgage, that was an example of a
 * possible use of static fields in order to know the total amount of money we led to clients. We have a static field
 * loansSum whose value is therefore shared by all the objects of Mortgage, and whose value is incremented every time
 * such an object is created. We had printed a warning message as soon as the value of this field was bigger than
 * a maximum. However, we could not find a a way to prevent the possibility to produce more object after that time.
 * A solution is now to have a private constructor, which is called only if loansSum <= budget. This is therefore an
 * application of private constructors.
 *
 * @author Andrea Mazzon
 */
public class Mortgage {

	static double loansSum = 0; // static: shared by all the objects. First equal to zero, for the first object.
	static double budget = 1E6;
	// this field is not meant to be static: it is must be able to vary for every customer
	String name;
	int age; // non static, for the same reason
	double amount; // same thing

	//constructor
	private Mortgage(String name, int age, double amount) {
		this.name = name; // note the use of this
		this.age = age; // note the use of this
		this.amount = amount;

		System.out.println("The name of our new customer is " + name + ". He/she is " + age + " years old."
				+ " We lend him/her " + amount + " euros.");

		// or loansSum = loansSum + amount;

		System.out.println("Sum of all the loans : " + loansSum);
		System.out.println();
	}
	
	/**
	 * It returns an object of type Mortgage if the former value of totalCost plus cost is less or equal than
	 * maximumBudget.
	 *
	 * @param name, the name of the new client
	 * @param age, the age of the new client
	 * @param amount, the amount of money we lend to the new client
	 * @return a reference to the new object
	 */
	/*
	 * Static: its implementation does not depend on non static fields and non static methods of the class
	 * it has to be static because we want to call it in order to construct a new object of the class, and in
	 * order to do that we cannot need an object of the class itself.
	 */
	public static Mortgage constructMortgage(String name, int age, double amount) {
		//your code here
		return null;
	}


}
