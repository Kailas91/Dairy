package com.uks.jvs.day3.ass2;



/**
 * Date:20/06/2019
 * Assignment: Day 3
 * Task: StringTokenizer Program
 * @author Kailas
 */
public class StringTokenizer {

	// it contains main method
	public static void main(String args[]) {
		try // this will exception in program when any error occurred on opening
			// note pad
		{
			// create TestStringTokenizer object to pass the argument array on
			// stringSeperation() method
			TestStringTokenizer objTestingStringTokenizer = new TestStringTokenizer();
			objTestingStringTokenizer.stringSeperation(args);

		} catch (Exception exception)// this will catch that exception and
										// display
		{
			System.out.println("Error Executing notepad." + exception);
		}
	}
}
