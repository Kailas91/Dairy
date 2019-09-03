package com.uks.jvs.day4.ass3;


/**
 * Date:21/06/2019
 * Assignment: Day 4
 * Task: Abstract class & overriding
 *
 * @author Kailas
 */
public abstract class BaseEmployee {

	public String firstName = null;
	public String lastName = null;
	protected String basicSalary = null;
	private String empType = null;

	/**
	 * Description : doWork method is abstract means it has no method definition
	 *
	 */
	abstract void doWork();

	// // parameterized constructor to get employee details
	public BaseEmployee(String firstName, String lastName, String empType, String basicSalary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.setEmpType(empType);
		this.basicSalary = basicSalary;

		// display all data of employee
		System.out.println("\n Employee First Name :" + firstName + "\n Employee Last Name :" + lastName
				+ "\n Employee Type :" + empType + "\n Basic Salary :" + basicSalary);
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


}
