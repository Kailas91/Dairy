package com.uks.jvs.day3.ass2;

/**
 * Date:20/06/2019
 * Assignment: Day 3
 * Task: StringTokenizer Program
 * @author Kailas
 */
public class TestStringTokenizer {

	/**
	 * Description : this method will take input as a string array
	 *
	 * @param args
	 */
	public void stringSeperation(String[] args) {

		// convert array argument into string using join() function
		String stringValue = String.join(" ", args[0]);

		String[] stringresult = stringValue.split(",");// split string separated by comma
		for (int x = 0; x < stringresult.length; x++)
			System.out.println(stringresult[x]); // print separated word one column in one line
	}
}
