package com.uks.jvs.day3.ass5;


/**
 * Date:20/06/2019
 * Assignment: Day 3
 * Task: Add the given number to the specified
 * date and show the result.
 *
 * @author Kailas
 */
public class TestDateAdd {
	// it contains main method
	public static void main(String args[]) throws NumberFormatException, Exception {

		// create DateAdd class object to invoked addDate method
		DateAdd objDateAdd = new DateAdd();
		objDateAdd.addDate(args[0],args[1],Integer.parseInt(args[2]));

	}

}
