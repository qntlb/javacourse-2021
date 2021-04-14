package com.andreamazzon.session5.nomultipleinheritance;

/**
 * This class has a method void foo() with a given implementation, and a field i
 * which is initialized to be 1.
 *
 * @author Andrea Mazzon
 *
 */
public class FirstParentClass {

	protected int i;

	public FirstParentClass() {
		this.i = 1;
	}

	public void foo() {
		System.out.println("Implementation of the first class");
	}

}
