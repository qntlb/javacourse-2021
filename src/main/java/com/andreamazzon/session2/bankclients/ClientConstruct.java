package com.andreamazzon.session2.bankclients;

/**
 * This class shows as an example with the use of Builder pattern and multiple
 * methods calling. In this example, it makes possible to call a constructor for
 * an object with many fields, as this would open quite a lot of possibilities
 * of mistakes. Builder pattern is here possible due to the use of "this" to
 * return a reference to the same object calling a method. Also note the use of
 * the static method createNewClient.
 *
 * @author Andrea Mazzon
 *
 */
public class ClientConstruct {

	public static void main(String[] args) {

		/*
		 * note that the reference of the object calling all the methods is always the
		 * same! It is basically the one returned by the static method createNewClient.
		 * Then we can perform multiple calling.
		 */
		Client cristiano = Client.createNewClient("00011100").name("Cristiano Ronaldo").advisor("Smith")
				.nationality("Portoguese").cityOfResidence("Turin").age(36).riskAversionIndex(0.0).sumInvested(1E7)
				.hasInsurance(true);

		cristiano.printName();
		cristiano.printNationality();
		
	}

}
