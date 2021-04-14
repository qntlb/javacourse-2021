/**
 * Here you can see an example of why abstract classes can be useful: look at com.andreamazzon.session4.polymorphism.shapes.Shape
 * Here we had to give a dummy implementation to the method computeArea(), which is overridden in the derived classes
 * Circle, Triangle and Square. This method should be abstract, as it is now, and thus the Shape class must be abstract
 * as well. Note again an example of polymorphism in ShapeTest: we know that we cannot create object whose
 * specific type is Shape, since Shape is abstract, but still we can create an array of Shape objects and make them call
 * the method computeArea(): their specific type will be determined only at running time.
 */
package com.andreamazzon.session5.abstractclasses.shapes;