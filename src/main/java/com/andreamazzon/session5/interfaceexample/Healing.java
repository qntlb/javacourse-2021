package com.andreamazzon.session5.interfaceexample;

/**
 * This class illustrates how upcasting and polymorphism work also
 * with interfaces. it has a method which takes as an argument an object
 * of any class implementing Cure: the right implementation of the method is
 * called at running time via late binding.
 *
 * @author Andrea Mazzon
 *
 */
public class Healing {

	public static void someHealing(Cure c) {//object of any class implementing Cure
		c.diagnose();//the right implementation of the method is called at running time
		//c.aDoctorMethod();//it is not a method common to every class implementing Cure
		/*
		 * I can downcast, it does not complain at compilation time. But it's dangerous:
		 * see what happens when I call the method for an of type Antivirus. This is also 
		 * not a use conform toPolymorphism
		 */
		//((Doctor) c).aDoctorMethod();
	}

	public static void main(String[] args) {
		Antivirus mcAfee = new Antivirus();
		Doctor doctorHouse = new Doctor();
		/*
		 * Note two things here:
		 * 1. You have the same behaviour we have seen with classes: here the only difference is that the general type
		 * is an interface.
		 * 2. someHealing(Cure c) is static, so you don't need to construct objects of its class.
		 * Moreover, you are calling it from the same class wher eit is defined, so you don't even have to
		 * specifiy the name of the class.
		 */
		someHealing(doctorHouse);
		System.out.println();
		someHealing(mcAfee);
		
		System.out.println();
		//it is able to call the class specific method because we gave it a reference to the class
		doctorHouse.aDoctorMethod();
		
		//now let's see what happens when we give the reference to the interface
		Cure doctorCox = new Doctor();
		//same thing for polymorphism, in this case Java does not need to upcast implicitly
		someHealing(doctorCox);
		//but it is not able to call the doctor specific method. We have to downcast
		//doctorCox.aDoctorMethod();
	}
}


