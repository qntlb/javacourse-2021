package com.andreamazzon.session1.oophelloworld;

/**
 * The main use of this class is to print a message. It has one field,
 * messageToBePrinted, and two methods, printMessage() and
 * printMessageWithArgument(String message).
 *
 * @author Andrea Mazzon
 */
public class Message {

	String messageToBePrinted = "Standard message: it can be modified";

	// or also:
	// String messageToBePrinted = new String("Standard message: it can be
	// modified");

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
	 * messageToBePrinted, but one string passed through the argument list. These
	 * two methods do the same thing, but in different ways. We will see in some
	 * time how to deal with such a situation
	 */
	void printMessageWithArgument(String message) {
		System.out.println(message);
	}

}