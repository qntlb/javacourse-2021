package com.andreamazzon.session4.testingprotection;

import static com.andreamazzon.session3.useful.Print.printn;

import com.andreamazzon.session4.protectedotherpackage.ParentClassOtherPackage;

/**
 * This class extends a class which is in another package. The base class
 * contains a protected field and a protected method. We observe that methods of
 * the derived class can access the protected fields and call the protected
 * methods of the base class, which they inherit.
 *
 * @author Andrea Mazzon
 *
 */
public class DerivedClass extends ParentClassOtherPackage {

	public DerivedClass(int i) {
		/*
		 * i gets inherited from the base class: it is defined in the base class.
		 * However, its value can be set from outside the package of the class where it
		 * is defined because it is protected. Try to go in ProtectedOtherPackage and
		 * make it with just package access. You see hat now you get an error here.
		 */
		this.i = i;
	}

	/**
	 * It computes and prints the value of the fields i 
	 */
	public void printField() {
		printn(i);// i here is a field of the base class!
	}

	/**
	 * It computes and prints the value of the sin of 2i 
	 */
	public void computeSinOfDouble() {
		/*
		 * computeDouble() gets inherited from the base class: it is defined in the base
		 * class. However, it can be called from outside the package of the class where
		 * it is defined because it is protected. Try to go in ProtectedOtherPackage and
		 * make it with just package access. You see hat now you get an error here.
		 */
		computeDouble();
		printn("The sin of 2i is " + Math.sin(i));
	}

	/**
	 * It computes and prints the value of sin(i/2)
	 */
	public void computeSinOfHalf() {
		// you can't call makeHalf() because it is not protected!
		// computeHalf();
		//printn(Math.sin(i));
	}
}
