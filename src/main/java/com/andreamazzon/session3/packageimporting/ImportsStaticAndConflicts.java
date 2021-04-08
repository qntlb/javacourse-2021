package com.andreamazzon.session3.packageimporting;

/*
 * import static: allows members (fields and methods) which have been "defined" as public static,
 * to be used without specifying the class in which the field has been defined.
 */
import static com.andreamazzon.session3.useful.Print.printn;
import static java.lang.Math.sqrt;

import java.util.Vector;
//try to comment it out: it returns an error becuase of a conflict
//import com.andreamazzon.session3.useful.Vector;

/**
 * This class illustrates the way we can import classes from other packages. Main things to
 * note:
 * - through "import static" you can avoid to specify the name of a class for a static
 * method or field
 * - you cannot import two packages which have a class with the same name.
 * - if you really want to use classes with same name from different packages, you can import one
 * and then mention the class of the other writing its package as well (see row 35)
 *
 * @author: Andrea Mazzon
 */

public class ImportsStaticAndConflicts {

	public static void main(String[] args) {

		printn("Enough with System.out.println()!!");
		double n=3;
		printn("Enough with Math.sqrt(" + n + ")=" + sqrt(n) + "!");// import static!

		//if I write it in this way, I can avoid the import. It knows that I need our class so no collision
		com.andreamazzon.session3.useful.Vector v2 = new com.andreamazzon.session3.useful.Vector();//mine here

		Vector v1 = new Vector(); //it knows this is the Java class (imported)

	}

}