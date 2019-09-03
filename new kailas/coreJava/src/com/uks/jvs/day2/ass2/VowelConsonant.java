package com.uks.jvs.day2.ass2;

/**
 * Date:19/06/2019
 * Assignment: Day 2
 * Task: Program for VowelConsonant
 *
 * @author Kailas
 */
public class VowelConsonant {
	boolean isVowel = false;

	/**
	 * Description : this method will get single character from CheckForVowel
	 * class to find vowel and consonant
	 *
	 * @param charvar
	 */
	public void checkChar(String charvar) {
		// Switch statement get single character as a input from checkChar()
		// method
		switch (charvar) {
		case "a":
		case "e":
		case "i":
		case "o":
		case "u":
		case "A":
		case "E":
		case "I":
		case "O":
		case "U":
			isVowel = true; // any case will call then isVowel=true
		}
		// this if condition are used check which is vowel or which is consonant
		if (isVowel == true) {
			System.out.println(charvar + " is  a Vowel");
		} else {

			System.out.println(charvar + " is a Consonant");
		}

	}
}
