package com.andreamazzon.session3.encapsulation.traveltime;

/**
 * This class illustrates an example of encapsulation.
 * We imagine that a client gives us a distance that has to travel and an expected speed,
 * and we have to give back an expected time of travel. Suppose that our first version had
 * everything in km, but that for some reasons we have now to pass to miles. However, we don't
 * want that our client has to change the code. Therefore we need to implement a transformation
 * method that translates from km to miles and vice versa.
 * Then getters and setters are implemented through this method: in this way, with respect to before
 * we only need to change getters and setters and to define the conversion method, keeping the same
 * the rest of the code.
 *
 * @author Andrea Mazzon
 */
public class TravelTime {

	/*
	 * We don't want our client to be able to directly set the values of these fields, as we want them to be
	 * expressed in miles.
	 */
	private double distance;// miles
	private double speed;// miles/time

	//static: the same value is shared for every object, and final: cannot be changed
	private final static double conversion = 1.60934;

	//conversion from km to miles: private, the client doesn't need to see it
	private double kmToMiles(double distanceInKm) {
		return distanceInKm/conversion;
	}

	//conversion from miles to km: private, the client doesn't need to see it
	private double milesToKm(double distanceInMiles) {
		return distanceInMiles*conversion;
	}

	public void setDistance(double distanceInKm){
		//the client sets the distance in km, but we have to convert it in miles
		distance=kmToMiles(distanceInKm);
	}

	public void setSpeed(double speedInKm){
		//the client sets the speed in km, but we have to convert it in miles
		speed=kmToMiles(speedInKm);
	}


	// getter of the distance: the conversion from miles to km has to be performed
	public double getDistance(){
		return milesToKm(distance);//the client expects to have back a distance in km
	}

	public double getTimeToTravel() {
		//we don't even have to convert it back: we have converted both speed and distance
		return distance/speed;
	}


}
