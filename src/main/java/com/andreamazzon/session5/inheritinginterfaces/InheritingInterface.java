package com.andreamazzon.session5.inheritinginterfaces;

/**
 * Inheritance is also possible for interfaces. Also multiple inheritance is
 * possible. This is indeed an interface extending two interfaces.
 *
 * @author Andrea Mazzon
 *
 */
public interface InheritingInterface extends FirstInterface, SecondInterface {
	void thirdMethod();
}
