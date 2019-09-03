package com.uks.jvs.day3.ass6;

import java.text.ParseException;


/**
 * Assignment: Day 3
 * Task: Formatted number program
 * Date:20/06/2019
 *
 * @author Kailas
 */
public class FormattedNumber {

	// it contains main method throws exception
	public static void main(String[] args) throws ParseException {

		// Enter value in command line argument first is output number format
		// and second is number

		String stringNumberType = args[0];
		double anyNumber = Double.parseDouble(args[1]);

		// get string Number type and call that case
		switch (stringNumberType) {
		case "int":
			System.out.println("formatted int no is :" + (int) anyNumber); // print
																			// converted
																			// result
			break;

		case "float":
			System.out.println("formatted float no is :" + (float) anyNumber);
			break;

		case "long":
			System.out.println("formatted long no is :" + (long) anyNumber);
			break;
		case "double":
			System.out.println("formatted double no is :" + (double) anyNumber);
			break;
		}

	}

}
