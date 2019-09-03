package com.uks.jvs.day4.ass5;

/**
 * Date:21/06/2019
 * Assignment: Day 4
 * Task: Java Map Collections & Autoboxing Testing
 *
 * @author Kailas
 */
public class TestFrequencyChecker {

	public static void main(String args[]) {

		try {
			// create FrequencyChecker object to call occurenceCheck(args); method to pass array of words
			FrequencyChecker objFrequencyChecker = new FrequencyChecker();
			System.out.println("Using Hash Map method");
			objFrequencyChecker.occurenceCheck(args);
			// Using tree map
			System.out.println("Using Tree Map method");
			objFrequencyChecker.countFrequencies(args);
		} catch (Exception exceptin) {
			System.out.println("Enter the Valid Input....!!!");
		}
	}
}
