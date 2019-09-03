package com.uks.jvs.day5.ass4;

/**
 * Date:24/06/2019
 * Assignment: Day 5
 * Task: General Employee class extends in base class
 *
 * @author Kailas
 */
public class GeneralEmployee extends BaseEmployee {

	public double basicSal;

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
		//String[] n = name.split(" ");
		this.firstName = firstName;	this.lastName=lastName; this.empType=empType;this.empCode= empCode;
		this.basicSal =basicSalary;
	}

}
