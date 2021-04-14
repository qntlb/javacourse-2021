package com.andreamazzon.session5.nameclasheswithinterfaces;

/**
 * This interface has two methods, methodWithDifferentReturnTypes() and
 * overloadedMethod(int i). In particular, overloadedMethod() returns no objects
 * whereas methodWithDifferentReturnTypes() returns an int. The point is that: -
 * overloadedMethod(int i) is overloaded in AnotherInterface, there you have
 * indeed void overloadedMethod(). So the two are treated as two different
 * methods, and a class implementing both the interfaces must implement the two
 * methods. - In AnInterface a method void methodWithDifferentReturnTypes() is
 * defined. Since the signature (name plus argument list) is the same as the one
 * of void methodWithDifferentReturnTypes(), the two are treated as one method
 * once a class tries to implement both of them, so that an error is returned.
 * On the other hand, if a class implements only one of them another error is
 * returned because the return type is not compatible with the other one.
 *
 * @author Andrea Mazzon
 *
 */
public interface AnotherInterface {

	void overloadedMethod();

	// Same name and same argument list as in AnInterface!
	// int methodWithDifferentReturnTypes();

}
