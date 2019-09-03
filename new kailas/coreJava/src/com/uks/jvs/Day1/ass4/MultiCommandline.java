package com.uks.jvs.Day1.ass4;
/**
 * Date:18/06/2019
 * Assignment: Day 1
 * Task: MultiCommand line Argument in java
 * @author Kailas
 *
 */
public class MultiCommandline {
	public void doOperation(String[] args) {// this method contain string array getting from class TEstCommandline.java
		if (args[0].equals("1")) {// If first argument value is "1", Add all the numbers given in the next argument elements and display the result.
			int addition = 0;
			for (int i = 1; i < args.length; i++) {
				try {// try catch for validating strings or numbers
					addition = addition + Integer.parseInt(args[i]);
				} catch (NumberFormatException exception) {
					continue; // it will display error when user enter string in second argument
				}
			}//here we will display argument addition result this is getting from doOperation() method
			System.out.println("all argument addition = " + addition);
		}
		if (args[0].equals("2")) {//If first argument value is "2", Change the case to lower case of all the words given in the next argument elements and display the resulted values.
			String addition = "";
			for (int i = 1; i < args.length; i++) {
				try {// try catch for validating strings or numbers
					addition = addition + args[i];
				} catch (NumberFormatException exception) {// convert String to integer
					Integer.parseInt(args[i]);
					continue; // ignoring if it is number
				}
			}
			System.out.println("all argument in lower case = " + addition.toLowerCase());// here we will display argument in to lower case this output is getting from doOperation() method
		}
	}
}
