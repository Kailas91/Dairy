package com.uks.jvs.day2.ass4;

/**
 * Date:19/06/2019
 * Assignment: Day 2
 * Task: Program for StringManipulation
 *
 * @author Kailas
 */
public class StringManipulationTwo {
	// it contains main method
	public static void main(String[] args) {
		try {// for check argument is present or not and user enter any invalid
				// arguments then display that exception
				// StringOperation object is created for doOperationWithRegEx
				// and doOperationwithoutregex() methods
			StringOperationTwo objStringOperation = new StringOperationTwo();
			objStringOperation.doOperationWithRegEx(args);
			System.out.println("without using regular expression");
			objStringOperation.doOperationwithoutregex(args);

		} catch (Exception exception) { // any exception occurred then catch
										// will print this
			System.out.println("Enter any Valid argument...!" + exception);
		}
	}
}
