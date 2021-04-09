package com.andreamazzon.session3.encapsulation.complexes;

import static com.andreamazzon.session3.useful.Print.print;
import static com.andreamazzon.session3.useful.Print.printn;

/**
 * This class illustrates some uses of Encapsulation and some of the things we have seen up to now.
 * We want to perform operations with complex numbers for an user who only understands Cartesian coordinates.
 * However, we think that some of the operations are more easily implemented by using the Polar representation.
 * We then work with polar coordinates, hiding the conversions from Cartesian to polar coordinates and vice-versa.
 */

public class ComplexNumber {

	/*
	 * there's no need for the user to directly access these fields; not only, the user does not even
	 * know their meaning
	 */
	private double r;
	private double theta;

	/*
	 * private constructor! Does not have to be known by the front end user, it just gets called from inside the class
	 * when we want to construct an object of this type (i.e., with polar coordinates) from the cartesian coordinates
	 * the user gives.
	 */
	private  ComplexNumber(double r, double theta) { //Constructor for internal use
		this.r=r;
		this.theta=theta;
	}

	/*
	 * Setter the user wants: he/she only understands Cartesian representation. However, these coordinates
	 * are then immediately converted into polar ones, and an object representing a complex number
	 * in polar coordinates is returned.  
	 */
	/**
	 * It sets and returns a complex number from Cartesian coordinates
	 * @param realPart
	 * @param imaginaryPart
	 * @return the complex number in Polar coordinates
	 */
	public static ComplexNumber setComplexNumber(double realPart, double imaginaryPart) {
		double radius = Math.sqrt(realPart*realPart+imaginaryPart*imaginaryPart);
		double angle = Math.atan2(imaginaryPart,realPart);
		return new ComplexNumber(radius, angle);//the private constructor gets called
	}

	/*
	 * We translate from the polar coordinates of the object which is calling the method to cartesian ones
	 * (in order to give back the coordinates that the user knows or in order to perform operations which
	 * are simpler in cartesian coordinates). These methods are public because maybe the user wants to 
	 * get the real and imaginary part of a complex number. However, they can also be used internally.
	 */
	/**
	 * It returns the real part of a complex number
	 * @return the real part of the complex number
	 */
	public double getRealPart() {//public because the user might want to work with the real part
		return r*Math.cos(theta);
	}

	/**
	 * It returns the imaginary part of a complex number
	 * @return the imaginary part of the complex number
	 */
	public double getImaginaryPart() {//public because the user might want to work with the imaginary part
		return r*Math.sin(theta);
	}


	/*
	 * From now on, we perform the operations on our complex numbers. We return a complex
	 * number is polar coordinates and the user only understands cartesians, but in order to
	 * visualize these number, the user has to call the methods show() and showWithNewLine(),
	 * which print a number in cartesian coordinates
	 */
	/**
	 * @return the conjugate of the complex number represented by the object calling the method
	 */
	public ComplexNumber conjugate(){
		return new ComplexNumber(r,-theta);//very simple!
	}

	/**
	 * @return the absolute value of the complex number represented by the object calling  the method
	 */
	public double abs(){
		return r;
	}

	/**
	 * @param c complex number
	 * @return the sum of the complex number represented by the object calling the method and the complex number
	 * given as an argument
	 */
	public ComplexNumber sum(ComplexNumber complexNumber){
		/*
		 * the sum is more conveniently computed in Cartesian coordinates. We get the real and imaginary part of both the
		 * numbers and sum
		 */
		return setComplexNumber(complexNumber.getRealPart() + getRealPart(),
				complexNumber.getImaginaryPart() + getImaginaryPart());
	}

	/**
	 * @param c complex number in cartesian coordinates
	 * @return the product of c and the complex number represented by the object calling the method
	 */
	public ComplexNumber product(ComplexNumber complexNumber){
		//the product is more efficiently computed in polar coordinates!
		return new ComplexNumber(r * complexNumber.r,theta + complexNumber.theta);
	}

	/**
	 * @return the sign of the imaginary part of the complex number represented by the object
	 * calling the method
	 */
	private String imaginarySign () {
		return (getImaginaryPart() >=0) ?  "+ ": "- ";
	}

	/*
	 * Here we have methods that the user calls in order to visualize the complex number
	 * in cartesian coordinates. 
	 */
	/**
	 * prints a complex number in cartesian coordinates
	 */
	public void show(){//a + b i
		if (getImaginaryPart() !=0.0){
			print(getRealPart() + " " + imaginarySign() //gets the right sign  BEFORE the imaginary unit!
			+ Math.abs(getImaginaryPart()) + " i ");
		}
		else {
			print(getRealPart()); //removes "i 0"
		}
	}


	/**
	 * prints a complex number in cartesian coordinates followed by new line
	 */
	public void showWithNewLine(){
		if (getImaginaryPart() !=0.0){
			printn(getRealPart() + " " + imaginarySign() //gets the right sign  BEFORE the imaginary unit!
			+ Math.abs(getImaginaryPart())+ " i ");
		}
		else {
			printn(getRealPart()); //removes "i 0"
		}
	}
}


