package com.uks.jvs.day5.ass1;

/**
 * Date:24/06/2019
 * Assignment: Day 5
 * Task: File Stream & List in Java
 *
 * @author Kailas
 */
public class BaseEmployee {
	String empCode;
	String firstName;
	String lastName;
	String empType;
	private double basicSalary;

	/**
	 * @description - constructor
	 * @param empCode
	 * @param firstName
	 * @param lastName
	 * @param empType
	 * @param basicSalary
	 */
	public BaseEmployee(String empCode, String firstName, String lastName, String empType, double basicSalary) {
		this.empCode = empCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.empType = empType;
		this.basicSalary = basicSalary;

	}

	/**
	 * @description - get empCode
	 * @return
	 */
	public String getEmpCode() {
		return empCode;
	}

	/**
	 * @description - set empCode
	 * @return
	 */
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}

	/**
	 * @description - get empFirstName
	 * @return
	 */

	public String getFirstName() {
		return firstName;
	}

	/**
	 * @description - set empFirstName
	 * @return
	 */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @description - set empLastName
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @description - get empLastName
	 * @return
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @description - get empType
	 * @return
	 */
	public String getEmpType() {
		return empType;
	}

	/**
	 * @description - set empType
	 * @return
	 */
	public void setEmpType(String empType) {
		this.empType = empType;
	}

	/**
	 * @description - get empBasicSalary
	 * @return
	 */
	public double getBasicSalary() {
		return basicSalary;
	}

	/**
	 * @description - set empBasicSalary
	 * @return
	 */
	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
}
