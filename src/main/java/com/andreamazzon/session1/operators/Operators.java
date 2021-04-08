package com.andreamazzon.session1.operators;

/**
 * Examples of operators: an operator takes one or more arguments and produces a
 * new value
 *
 * @author Andrea Mazzon
 */
public class Operators {

	public static void main(String[] args) {

		// note: type declaration, and then variable assignment, through the operator
		// "=".
		int a = 5; // Since it is a primitive, a will contain the actual value and not the
		// reference to an object.
		System.out.println("The value of a is " + a);
		int b = a; // if you say a = b for primitives, then the contents of b are copied into a
		System.out.println("The value of b is " + b);
		b = 6; // you can modify b
		System.out.println("The value of a is " + a);// and this does not affect a
		System.out.println("The value of b is " + b);
		/*
		 * remember: this is not the same for objects which are not primitives: Whenever
		 * you manipulate an object, what you’re manipulating is the reference, so when
		 * you assign “from one object to another” you’re actually copying a reference
		 * from one place to another. See the code in com.andreamazzon.session1.tank to
		 * see what happens
		 */

		System.out.println();// we print an empty line, just to separate things

		int c = a + b;
		System.out.println("The sum of " + a + " and " + b + " is " + c);
		int d = a - b;
		System.out.println("The difference between " + a + " and " + b + " is " + d);
		int e = a * b;
		System.out.println("The product of " + a + " and " + b + " is " + e);
		double f = a / b; // result is 0
		System.out.println("The ratio of " + a + " and " + b + " is not " + f + ";");
		// Note: Integer division truncates, rather than rounds, the result.
		double g = a / (double) b; // a gets "upcasted", i.e., it is considered to be a double.
		// We will see more on the concept of "upcasting" in the next sessions
		System.out.println("The ratio of " + a + "" + " and " + b + " is " + g);
		int g1 = (int) g; // "downcasting"
		System.out.println("Which I remind you, is not " + g1);

		System.out.println();

		// More types
		String s = "string!"; // or String s= new String("string!")
		System.out.println(s);
		char x = 'A'; // note the single quotation marks
		System.out.println(x + " " + s);// example of the string operator "+"

		System.out.println();

		/*
		 * a boolean takes values true or false. Used with relational operators: >, >=,
		 * <, <=, ==; !=
		 */
		boolean bool1 = (b == 6);
		System.out.println("b == 6 is " + bool1);
		boolean bool2 = (b != 6);
		System.out.println("b != 6 is " + bool2);

		System.out.println();

		// Logical operators
		System.out.println("True || false: " + (bool1 || bool2));
		System.out.println("True & false: " + (bool1 & bool2));
		System.out.println("a < 10 and b > 30: " + (a < 10 & b > 30));
		System.out.println("a < 10 or b > 30: " + (a < 10 || b > 30));

		System.out.println();

		// Increments and decrements
		System.out.println("c: " + c);
		System.out.println("e: " + e);
		// an operator can change the value of an operand. This is called a side effect
		System.out.println("++c: " + ++c);
		System.out.println("--e: " + --e);

		// c and e are equal to 12 and 29
		System.out.println("c++: " + c++);
		System.out.println("e--: " + e--);

		// It appears to have stayed the same...but they are now 13 and 28

		System.out.println("++c :" + ++c);
		System.out.println("--e :" + --e);
	}
}
