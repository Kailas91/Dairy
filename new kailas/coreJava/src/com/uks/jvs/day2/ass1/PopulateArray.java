package com.uks.jvs.day2.ass1;

/**
 * Date:19/06/2019
 * Assignment: Day 2
 * Task: PopulateArray Program
 *
 * @author Kailas
 */

public class PopulateArray {

	// it contain main method
	public static void main(String[] args) {
		// create ArrayPopulation object to populate array using populateArray
		// method
		ArrayPopulation objArrayPopulation = new ArrayPopulation();
		int[] firstArray = { 5, 4, 3, 2, 1 };
		int[] secondArray = { 1, 2, 3, 4, 5 };
		int[] finalArray;
		// calling //calling populateArray method from class ArrayPopulation to
		// pass the two argument array
		finalArray = objArrayPopulation.populateArray(firstArray, secondArray);
		// calling print method from class ArrayPopulation to display final array
		objArrayPopulation.print(finalArray);
	}
}