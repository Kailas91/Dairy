package com.uks.jvs.day2.ass2;

/**
 * Date:19/06/2019
 * Assignment: Day 2
 * Task: Program for CheckVowel
 *
 * @author Kailas
 */
public class CheckForVowel {
	// it contains main method
	public static void main(String[] args) {
		// this try block will used to add exception when user enter invalid
		// arguments
		try {
			char a = args[0].charAt(0);// to get single value convert string to
										// char
			// create object to call checkChar() nnethod
			VowelConsonant objVowelConsonant = new VowelConsonant();


			objVowelConsonant.checkChar(Character.toString(a));
		} catch (Exception exception) { // to catch the occurred exception and
										// print
			System.out.println("Enter any Valid argument...!" + exception);
		}
	}

}
