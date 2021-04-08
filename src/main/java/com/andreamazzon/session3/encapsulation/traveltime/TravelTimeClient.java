package com.andreamazzon.session3.encapsulation.traveltime;

import static com.andreamazzon.session3.useful.Print.printn;
/**
 * This class illustrates the use of setters, getters and in general of encapsulation: this is the
 * way a client who works with kilometres would use with our TravelTime class.
 *
 * @author Andrea Mazzon
 *
 */
public class TravelTimeClient {
	public static void main(String[] args) {

		double distance = 45;//in km
		double speed = 23.3;//km/h

		TravelTime myTravelTime = new TravelTime();
		//myTravelTime.distance = 10;//in km! no good for us

		myTravelTime.setDistance(distance);//in our class, this is immediately converted to miles
		myTravelTime.setSpeed(speed);//in our class, this is immediately converted to miles

		printn("Expected travel time: " + myTravelTime.getTimeToTravel() + " hours");//use of getter
	}

}
