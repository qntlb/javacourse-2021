package com.andreamazzon.session2.oophelloworldwithconstructor;

/**
 * The main use of this class is to print a message. It has one field,
 * messageToBePrinted, one (default) constructor, whose side effect is to print
 * a message, and two methods, printMessage() and
 * printMessageWithArgument(String message).
 *
 * @author Andrea Mazzon
 */
public class MessageWithConstructor {

	String messageToBePrinted = "Standard message: it can be modified";

	// default constructor, because it has no arguments. Note: no return type
	// (different from void!)
	MessageWithConstructor() {
		//side effect: a message is printed
		System.out.println("A new object is created");
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
	 * methods do the same thing, but in different ways. We will see in some time
	 * how to deal with this situation
	 */
	void printMessageWithArgument(String message) {
		System.out.println(message);
	}
}
