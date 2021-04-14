package com.andreamazzon.session5.nomultipleinheritance;

/**
 * This class has a method public void foo(), so  same name and same argument list as the one of FirstParentClass,
 * with a different implementation. Moreover, it has a field int i which is the same field as in FirstParentClass.
 * Here it gets initialized according to a value passed to the constructor, whereas in FirstParentClass it
 * is 1. This possibility of having conflicts is the main reason why multiple inheritance is not permitted in Java.
 *
 * @author Andrea Mazzon
 *
 */
public class SecondParentClass {

	protected int i;
	
	/*
	 * look at the constructor of the other class, where i is set to be 1: this can bring to a
	 * a conflict!
	 */
	public SecondParentClass(int i) {
		this.i = i;
	}

	//conflict with the method defined and implemented in FirstParentClass
	public void foo() {
		System.out.println("Implementation of the second class");
	}

}
