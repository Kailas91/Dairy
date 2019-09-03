package com.uks.jvs.day2.ass3;

/**
 * Date:19/06/2019
 * Assignment: Day 2
 * Task: Program for StringManipulation
 *
 * @author Kailas
 */
public class StringManipulation {
	// this main method throws Exception
	public static void main(String[] args) {
		try {// for check argument is present or not
				// StringOperation object is created for doOperationWithRegEx()
				// methods
			StringOperation objStringOperation = new StringOperation();
			objStringOperation.doOperationWithRegEx(args);

		} catch (Exception exception) { // any exception occurred then catch
										// will print this
			System.out.println("Enter any Valid argument...!" + exception);
		}
	}
}
