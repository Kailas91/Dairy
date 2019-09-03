package com.uks.jvs.day2.ass4;

/**
 * Date:19/06/2019
 * Assignment: Day 2
 * Task: Program for StringOperation
 * @author Kailas
 */
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringOperationTwo {

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
		// UpperRegex this variable store A.B.C......Z
		String stringUpperRegex = "[A-Z]";
		String stringLowerRegex = "[a-z]";
		String stringNumberRegex = "[0-9]";
		if (args[0].equals("1")) {
			// convert array to string
			String stringOriginal = Arrays.toString(args).substring(3).replace("[", "").replace("]", "");
			// create stringBuilder object to reverse string
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
			// matcher class are used tom match that pattern to the given string
			matcher = pattern.matcher(stringOriginal);
			// if match pattern is find number then intDigit incremented by 1
			while (matcher.find()) {
				intDigit++;
			}
			pattern = Pattern.compile(stringUpperRegex);
			matcher = pattern.matcher(stringOriginal);
			while (matcher.find()) {
				intUpperCaseletter++;
			}
			System.out.println("Lower case letter: " + intLowerCaseletter);
			System.out.println("Upper case letter: " + intUpperCaseletter);
			System.out.println("Digit: " + intDigit);
		}

	}

	// method for counting upper and lower letter without using regular
	// expression
	public void doOperationwithoutregex(String input[]) {
		char charCurrentCharacter;
		int intLowerCaseletter = 0;
		int intUpperCaseletter = 0;
		int intDigit = 0;
		if (input[0].equals("1")) {
			// convert array to string
			String stringOriginal = Arrays.toString(input).substring(3).replace("[", "").replace("]", "");
			// getBytes() method to convert string
			// into bytes[].
			byte[] strAsByteArray = stringOriginal.getBytes();
			byte[] result = new byte[strAsByteArray.length];
			// Store result in reverse order into the
			// result byte[]
			for (int i = 0; i < strAsByteArray.length; i++)
				result[i] = strAsByteArray[strAsByteArray.length - i - 1];
			System.out.println(new String(result));
		}
		// this else if used when input equals to 2 then counting vowel ,digit
		// and consonant
		else if (input[0].equals("2")) {
			String stringOriginal = Arrays.toString(input).substring(3).replace("[", "").replace("]", ""); // convert
																											// array
																											// to
																											// string
			for (int i = 0; i < stringOriginal.length(); i++) {
				charCurrentCharacter = stringOriginal.charAt(i);
				// check input value is digit or not
				if (Character.isDigit(charCurrentCharacter)) {

					intDigit++;
				} else if (Character.isUpperCase(charCurrentCharacter)) {
					intUpperCaseletter++;
				} else if (Character.isLowerCase(charCurrentCharacter)) {
					intLowerCaseletter++;

				}

			}
			// print count details this output is getting from
			// doOperationwithoutregex() this method

			System.out.println("Lower case letter count : " + intLowerCaseletter);
			System.out.println("Upper case letter count: " + intUpperCaseletter);
			System.out.println("Digit count: " + intDigit);
		}

	}
}
