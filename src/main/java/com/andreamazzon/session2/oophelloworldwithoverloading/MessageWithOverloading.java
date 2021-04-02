package com.andreamazzon.session2.oophelloworldwithoverloading;

/**
 * The main use of this class is to print a message. It has one field,
 * messageToBePrinted, which has a default value. There is a (default)
 * constructor, whose side effect is to let us know that a new object has been
 * created, and a constructor which takes a string as argument and set the value
 * of messageToBePrinted equal to that String. We then have a method
 * printMessage(), which just prints the value of messageToBePrinted, and an
 * overloaded method printMessage(String message) which prints message.
 *
 * @author Andrea Mazzon
 */
public class MessageWithOverloading {

	String messageToBePrinted = "Default hello message";

	/*
	 * default constructor, because it has no arguments. Note: no return type. This
	 * is different from void, in which the method returns nothing but you still
	 * have the option to make it return something else
	 */
	MessageWithOverloading() {
		// side effect
		System.out.println("A new object is created. messageToBePrinted does not get changed");
	}

	/*
	 * default constructor, because it has no arguments. Note: no return type. This
	 * is different from void, in which the method returns nothing but you still
	 * have the option to make it return something else
	 */
	MessageWithOverloading(String message) {
		// side effect
		System.out.println("A new object is created. messageToBePrinted gets changed");
		messageToBePrinted = message;
	}

	/*
	 * look at the definition of the method: void (it returns no object),name of the
	 * method (first letter not capitalised, Java convention), argument list (in
	 * this case no argument)
	 */
	void printMessage() {// this method prints the message contained in the string messageToBePrinted of
							// the object
		System.out.println(messageToBePrinted);
	}

	/*
	 * this method also prints a string: not the one contained in
	 * messageToBePrinted, but one string passed through the argument list. This two
	 * methods do the same thing, but in different ways. So, we could overload..
	 */
	void printMessage(String message) {
		System.out.println(message);
	}
}
