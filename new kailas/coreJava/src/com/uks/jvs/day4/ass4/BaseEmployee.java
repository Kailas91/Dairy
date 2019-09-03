package com.uks.jvs.day4.ass4;

/**
 * Date:21/06/2019
 * Assignment: Day 4
 * Task: using interfaces
 *
 * @author Kailas
 */

interface IWork {

	public default void doWork() {

	}
}

/**
 * @description - IReport is an interface
 * @author - Kailas
 */


public class BaseEmployee implements IWork {
	String firstName = null;
	String lastName = null;
	String empType = null;
	/**
	 * Description : doWork method is abstract means it has no method definition
	 *
	 */

	@SuppressWarnings("unused")
	private String basicSalary;

	// // parameterized constructor to get employee details
	public BaseEmployee(String firstName, String lastName, String empType, String basicSalary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.empType = empType;
		this.setBasicSalary(basicSalary);

		// display all data of employee
		System.out.println("\n Employee First Name :" + firstName + "\n Employee Last Name :" + lastName
				+ "\n Employee Type :" + empType + "\n Basic Salary :" + basicSalary);
	}

	public void setBasicSalary(String basicSalary2) {
		// TODO Auto-generated method stub

	}

	// getter method to get employee name
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	public void doWork() {
		// TODO Auto-generated method stub

	}



}
