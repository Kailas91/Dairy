package com.uks.jvs.day2.ass3;

/**
 * Date:19/06/2019
 * Assignment: Day 2
 * Task: Program for StringOperation
 * @author Kailas
 */
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOperation {
	/**
	 * Description :this method will get array of arguments from class
	 * StringManipulation.java
	 *
	 * @param args
	 */
	public void doOperationWithRegEx(String args[]) {
		int intLowerCaseletter = 0;
		int intUpperCaseletter = 0;
		int intDigit = 0;
		String stringUpperRegex = "[A-Z]";// UpperRegex this variable store
											// A.B.C......Z
		String stringLowerRegex = "[a-z]";
		String stringNumberRegex = "[0-9]";

		if (args[0].equals("1")) {
			// convert array to string
			String stringOriginal = Arrays.toString(args).substring(3).replace("[", "").replace("]", "");
			// create stringBuilder  object to reverse string
			StringBuilder stringBuilder = new StringBuilder(stringOriginal);

			System.out.println(stringBuilder.reverse().toString());
		} else if (args[0].equals("2")) {
			String stringOriginal = Arrays.toString(args).substring(3).replace("[", "").replace("]", "");
			Pattern pattern = Pattern.compile(stringLowerRegex);
			// match original string with given regular expression
			Matcher matcher = pattern.matcher(stringOriginal);

			while (matcher.find()) {
				intLowerCaseletter++;
			} // pattern class are used to finding pattern on given string
			pattern = Pattern.compile(stringNumberRegex);
			matcher = pattern.matcher(stringOriginal);
			while (matcher.find()) {
				intDigit++;
			}
			pattern = Pattern.compile(stringUpperRegex);
			matcher = pattern.matcher(stringOriginal);
			while (matcher.find()) {
				intUpperCaseletter++;
			} // print count details this output is getting from
				// doOperationwithregex() this method
			System.out.println("Lower case letter: " + intLowerCaseletter);
			System.out.println("Upper case letter: " + intUpperCaseletter);
			System.out.println("Digit: " + intDigit);
		}
	}
}
