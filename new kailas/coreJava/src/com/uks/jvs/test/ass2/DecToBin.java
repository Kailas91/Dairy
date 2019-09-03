package com.uks.jvs.test.ass2;

/**
 * Date:5/07/2019
 * Assignment: 2 Evaluation test
 * Task: Decimal to binary conversion
 *
 * @author Kailas
 */
public class DecToBin {
	static void desToBin(String number) {
		int dec = Integer.parseInt(number);

		// check number have only three digit
		if (dec>= 0 && dec <=999 ) {
			String bin = Integer.toBinaryString(dec);
			System.out.println("binary no of : " + dec + ": is  :" + bin);
		}
		else{
			System.out.println("please enetr only three digit number");
		}
	}

	public static void main(String args[]) {

		try {
			desToBin(args[0]);
		} catch (Exception e) {
			System.out.println("Enetr maximum 3 digit number only");
		}
	}
}
