package com.uks.jvs.day4.ass3;


/**
 * Date:21/06/2019
 * Assignment: Day 4
 * Task: Testing Data Abstraction and
 *
 * @author Kailas
 */
public class TestEmployee {

	/**
	 * @description - main method is used to call the methods overriding
	 */
	public static void main(String[] args) {

		// create PlEmployee class object to pass the employee data using parameterized constructor
		PLEmployee objPLEmployee = new PLEmployee("Alex", "Richard", "Employee", "35000");

		// calling this method in extended class to display employee data
		objPLEmployee.showPLdata("Alex", "Richard", "35000", "9673970569");
		// this is Abstract method create in base class BaseEnployee
		objPLEmployee.doWork();
	}

}
