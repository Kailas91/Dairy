package com.uks.jvs.day5.ass1;

/**
 * Date:24/06/2019
 * Assignment: Day 5
 * Task: File Stream & List in Java
 *
 * @author Kailas
 */
public class GeneralEmployee extends BaseEmployee {

	public String basicSal;

	/**
	 * @param empCode
	 * @param firstName
	 * @param lastName
	 * @param empType
	 * @param basicSalary
	 */

	// parameterized constructor that pass value to base class
	public GeneralEmployee(String empCode, String firstName, String lastName, String empType, double basicSalary) {
		super(empCode, firstName, lastName, empType, basicSalary);
	}

}
