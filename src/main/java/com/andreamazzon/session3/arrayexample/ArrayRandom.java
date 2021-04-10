package com.andreamazzon.session3.arrayexample;

import java.util.Arrays;
import java.util.Random;

/**
 * This class illustrates some features of arrays in Java by creating an array
 * of random length and filling it with random numbers between 1 and 500
 *
 * @author Andrea Mazzon
 *
 */
public class ArrayRandom {
	public static void main(String[] args){

		Random rand = new Random(); //random numbers generator

		int length = rand.nextInt(20); //(pseudo)random integer between 0 and 19

		int[] a = new int[length];
		//or:
		//int a[] = new int[length]; //the same
		/*
		 * note that I have created an array reference (it is an object) and I have initialized
		 * the array, through new int[length]. The array creation happens at run time
		 * (length is random, so the compiler cannot know it)
		 */
		System.out.println("The array a is " + a); //not so nice!
		// It is initialized with all zeros
		System.out.println(
				"The array a is " + Arrays.toString(a)/* Here is a nice way to print the values of an array */);
		/*
		 * toString(Array a) is a static method of the class Arrays. Note: this is not a method called by the
		 * array (object) a: indeed a is its argument
		 */

		// length field of an array! Of course an array is an object
		System.out.println("The length of the array a is "+ a.length);

		for(int i = 0; i < a.length; i++) { //note: int i=0; i<a.length: the first element is a[0]
			//you cannot go out of bounds: you would get a runtime error
			a[i] = rand.nextInt(500);  //(pseudo)random integer between 0 and 499
		}

		System.out.println("The array a is now " + Arrays.toString(a));

		int[] b;// Creation of the array reference
		
		b = new int[10];//.and then initialization

		int[] c = {1, 2, 3, 4, 5, 6, 7};//another way to initialize an array

		int[] d = c; //pay attention at this assignment!

		System.out.println("c is " + Arrays.toString(c));
		System.out.println("d is " + Arrays.toString(d));

		c[2]=7;//I modify c. Note: c[2] is the THIRD element of the array!

		//arrays are objects! when we write c = d they have the same reference
		System.out.println("c is now " + Arrays.toString(c));
		System.out.println("d is now " + Arrays.toString(d));
		/*
		 * clone() method: creates and returns a copy of the object, with the same
		 * class and with all the fields having the same values, but not with same reference
		 */
		int[] e = c.clone();
		System.out.println("e is " + Arrays.toString(e));
		c[2]=10;
		System.out.println("c is now " + Arrays.toString(c));
		System.out.println("e is still " + Arrays.toString(e));
	}
}

