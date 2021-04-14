package com.andreamazzon.session5.nameclasheswithinterfaces;

/**
 * This file illustrates possible problems due to name clashes when a class
 * implements two interfaces which have two methods with the same name, same
 * argument list but different return types.
 *
 * @author Andrea Mazzon
 *
 */

public class NameClashes implements AnInterface, AnotherInterface {

	// No problem here
	@Override
	public void overloadedMethod(int i) {
		System.out.println("A method whose name conflict is only in the argument creates no problem; "
				+ "its implementation is just overriding");
	}

	// you can of course overload the method
	@Override
	public void overloadedMethod() {
		System.out.println("This is the other implementation");
	}

	/*
	 * here you get an error if you uncomment int methodWithDifferentReturnTypes()
	 * in AnotherInterface
	 */
	@Override
	public void methodWithDifferentReturnTypes() {
		System.out.println("What do I do?");
	}

	// IT DOES NOT WORK! Because the signature is the same.
	// @Override
	// public int methodWithDifferentReturnTypes(){
	// System.out.println("What do I do?");
	// return 1;
	// }
}
