package com.andreamazzon.session3.privateconstructor.bicycleenhanced;

/**
 * This class is strictly related to com.andreamazzon.session2.bicycles.Bicycle, that was an example of a
 * possible use of static fields in order to know the total cost of our bikes' production. We have a static field
 * costSum whose value is therefore shared by all the objects of Bicycle, and whose value is incremented every time
 * such an object is created. We had printed a warning message as soon as the value of this field was bigger than
 * a maximum. However, we could not find a a way to prevent the possibility to produce more object after that time.
 * A solution is now to have a private constructor, which is called only if costSum <= maximum. This is therefore an
 * application of private constructors.
 *
 * @author Andrea Mazzon
 *
 */
public class Bicycle {

	static double costSum = 0; //static: shared by all the objects. First equal to zero, for the first object.
	static double maximumBudget; //also static, for the same reason

	/*
	 * private fields, they are set only via the (private) constructor. General rule: "always make fields as
	 * private as possible"
	 */
	private int gearsNumber;//this field is not meant to be static: it is must be able to vary for every bike
	private String color; //not static, for the same reason
	private double cost; //same thing


	/*
	 * PRIVATE constructor! We don't want anybody to be able to call it directly. It is called indirectly by
	 * constructBicycle if costSum <= maximumBudget.
	 */
	private Bicycle(int gearsNumber, double cost, String color){
		this.color = color; //note the use of this
		this.gearsNumber = gearsNumber; //note the use of this
		this.cost = cost;

		System.out.println("This is a " + color + " bycicle, with " + gearsNumber + " gears. It costs us " + cost + " euros ");;
		System.out.println("Total cost: " + costSum);

		System.out.println();
	}

	/**
	 * It returns an object of type Bicycle if the former value of totalCost plus cost is less or equal than
	 * maximumBudget.
	 *
	 * @param gearsNumber, the number of gears of the new bike
	 * @param cost, the cost of the new bike
	 * @param color, the color of the new bike
	 * @return a reference to the new object
	 */
	//Static: its implementation does not depend on non static fields and non static methods of the class
	public static Bicycle constructBicycle(int gearsNumber, double cost, String color) {
		costSum += cost; //the field is immediately incremented, and is the same for every Bicycle object
		//or costSum = costSum + cost;
		if (costSum <= maximumBudget) {
			//the private constructor is called, from inside the class: fine
			Bicycle newBike = new Bicycle(gearsNumber, cost, color);
			return newBike;
		}
		System.out.println("Enough, no more money!");
		costSum -= cost;
		//we have to return an object of type Bicycle, but we don't want to construct any! A solution is to return null
		return null;
	}
}
