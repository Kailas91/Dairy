package com.uks.jvs.day3.ass8;

/**
 * Date:20/06/2019
 * Assignment: Day 3
 * Task: Test class Details
 *
 * @author Kailas
 */
public class TestClassDetail {

	// it contains main method
	public static void main(String args[]) {

		String stringCommand;
		try
		{
			// create ClassDetail object to print call methods
			ClassDetail objClassDetails = new ClassDetail();
			// convert array into string and pass to switch case
			stringCommand = String.join(" ", args[1]);
			// get first argument as a class name for passing to methods


			// get command as a input and call that particular case
			switch (stringCommand) {
			case "F":
				// this method will shows only fields of that class
				objClassDetails.showOnlyFields(args[0]);
				break;

			case "M":
				// this method will shows only methods of that class
				objClassDetails.showOnlyMethods(args[0]);
				break;

			case "All":
				objClassDetails.showAllClassDetails(args[0]);
				break;
			}

		} catch (Exception exception)// this will catch that exception and
										// display
		{
			System.out.println("Error Executing" + exception);
		}
	}
}
