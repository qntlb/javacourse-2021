package com.andreamazzon.session4.polymorphism.shapes;

import static com.andreamazzon.session3.useful.Print.printn;

/**
 * In this test we show an example of polymorphism. We have an array of shapes and we ask to each member of this
 * array to call the method computing its area. However, until run time we don't know if the members are
 * circles, squares or triangles, as they are selected randomly. However, we are able to do this because
 * the objects of the derived classes get upcasted to the base type when they are created (see the method
 * nextShape() of RandomShapeGenerator). Every object is then treated as a Shape in the array at compilation
 * time, but at run time its special type is recognized and the specific implementation of the method
 * computeArea() is called. This behavior is known as late binding: the code being called isn’t determined
 * until run time
 *
 * @author Andrea Mazzon
 *
 */
public class ShapeAreaTest {

	public static void main(String[] args) {

		double basisOfTriangle = 10;
		double heightOfTriangle = 7;
		double sideOfSquare = 8;
		double radiusOfCircle = 11;

		RandomShapeGenerator generator =new RandomShapeGenerator(basisOfTriangle, heightOfTriangle,
				sideOfSquare, radiusOfCircle);

		Shape[] arrayOfShapes = new Shape[9];

		// Fill up the array with shapes:
		for(int i = 0; i < arrayOfShapes.length; i++) {
			arrayOfShapes[i] = generator.nextShape();  //automatic upcasting
		}

		for(Shape shp : arrayOfShapes)  {//note this way to access the array
			printn("The area is " + shp.computeArea());
			printn();
		}


	}

}
