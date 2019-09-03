package com.uks.jvs.day2.ass1;

/**
 * Date:19/06/2019
 * Assignment: Day 2
 * Task: ArrayPopulation Program
 *
 * @author Kailas
 */
public class ArrayPopulation {
	int[] intResult = new int[10];

	/**
	 * Description : this method get two parameter as input from PopulateArray
	 * Program
	 *
	 * @param firstarr
	 * @param secondarr
	 * @return
	 */
	public int[] populateArray(int firstarr[], int secondarr[]) {
		// to get one by one value of first and second array
		for (int i = 0; i < 10; i++) {
			// check final array position using i%2 means even no logic to
			// populate two array
			if (i % 2 == 0) {
				intResult[i] = secondarr[i / 2]; // getting second array value
													// and store in odd position

			} else {
				// getting first array value and
				// stored in final array even position
				intResult[i] = firstarr[i / 2];

			}
		}
		return intResult; // return array to caller
	}

	// print method to display result getting from populateArray() method
	public void print(int finalArray[]) {
		for (int i = 0; i < 10; i++) {
			System.out.println(" n+n array= " + intResult[i]);
		}
	}
}
