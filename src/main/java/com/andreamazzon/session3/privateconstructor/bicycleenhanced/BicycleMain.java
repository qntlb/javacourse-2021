package com.andreamazzon.session3.privateconstructor.bicycleenhanced;


/**
 * In the main method of this class we construct some objects of type Bycicle (i.e., instances of the class
 * Bycicle) as long as the total cost does not exceed a maximum budget. This is to show you how the value of
 * a static field is shared among all objects of the class, and how this can be used to set a "counter"
 * (in this case, the total cost of production). Moreover, a possible use of private constructors is presented.
 *
 * @author Andrea Mazzon
 *
 */
public class BicycleMain {
	public static void main(String[] args){
		Bicycle.maximumBudget = 10000; //static fields can be set just by writing the name of the class, like static methods
		Bicycle firstBike = Bicycle.constructBicycle(3, 1500, "red");
		Bicycle secondBike = Bicycle.constructBicycle(5, 3000, "blue");
		Bicycle thirdBike = Bicycle.constructBicycle(1, 2000, "black");
		Bicycle fourthBike = Bicycle.constructBicycle(7, 3000, "white");
		Bicycle fifthBike = Bicycle.constructBicycle(7, 3000, "white");
	}
}

