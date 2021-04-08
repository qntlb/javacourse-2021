package com.andreamazzon.session3.useful;

/*
 * import static: allows members (fields and methods) which have been "defined" as public static,
 * to be used without specifying the class in which the field has been defined.
 */
import static com.andreamazzon.session3.useful.Print.print;

/**
 * This class illustrates the use of "print static" and is defined in order to show what does it
 * happen when we import two packages that have a class with the same name
 * (see com.andreamazzon.packageimporting.Imports).
 *
 * @author: Andrea Mazzon
 */
public class Vector{
	public Vector(){
		print("Vector, my definition");
	}
}
