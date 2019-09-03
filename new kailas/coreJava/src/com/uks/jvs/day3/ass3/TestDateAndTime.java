package com.uks.jvs.day3.ass3;

import java.text.ParseException;


/**
 * Date:20/06/2019 Assignment: Day 3 Task: Date and Time Program
 *
 * @author Kailas
 */
public class TestDateAndTime {

	// it contains main method
	public static void main(String args[]) throws ParseException {
		DateAndTime objDateAndTime = new DateAndTime();

		// check second argument is present or not
		boolean status = checkForDateAndTime(args);

		if (args.length == 1) {
			System.err.println("you are not enter second argument thats why display todays date");
			objDateAndTime.todaysDate(args[0]);
		}
		if (status == false) {
			objDateAndTime.dateFormater(args[0], args[1]);
		}
	}

	/**
	 *
	 * @param input
	 * @return
	 */
	public static boolean checkForDateAndTime(String[] input) {
		boolean check = false;
		if (input.length == 1) {
			check = true;
		}
		if (input.length > 2) {
			System.err.println("you enetr more than two argument t");
			check = true;
		}
		if (input.length < 1) {
			System.err.println("please enetr argument");
			check = true;
		}
		return check;
	}

}
