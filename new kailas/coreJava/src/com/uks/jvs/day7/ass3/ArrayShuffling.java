package com.uks.jvs.day7.ass3;

import java.util.Scanner;

/**
 * Date:26/06/2019 Assignment: Day 7 Task: Array shuffling programs
 *
 * @author Kailas
 */

public class ArrayShuffling {

	public static void main(String args[]) {

		String[] items = new String[20];
		// get standard input array from user
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 20 string :");
		for (int j = 0; j < 20; j++) {
			items[j] = scanner.next();
		}
		System.out.print("random array element:" + "\t");
		for (int i = 0; i < 20; i++) {
			// random function is used to get array item
			int rand = (int) (Math.random() * 20);
			System.out.print("\n" + "\t" + items[rand]);
		}
		scanner.close();

	}
}
