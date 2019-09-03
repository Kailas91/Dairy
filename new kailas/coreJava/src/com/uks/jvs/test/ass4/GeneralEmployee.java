package com.uks.jvs.test.ass4;

/**
 * Date:5/07/2019
 * Assignment: 4 Evaluation test
 * Task: sorting data using hashmap
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
