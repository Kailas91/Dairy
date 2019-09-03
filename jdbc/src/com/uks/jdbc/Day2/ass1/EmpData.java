package com.uks.jdbc.Day2.ass1;

/**
 * this class is used to get and set the results from the database
 *
 * @author Kailas
 * Date : 23/7/2019
 */
public class EmpData {
	private String employeeId;
	private String name = null;
	private String title = null;
	private String address = null;
	private String homePhone = null;

	/**
	 * Constructor
	 *
	 * @param employeeId2
	 * @param name
	 * @param title
	 * @param address
	 * @param homePhone
	 */
	EmpData(String employeeId, String name, String title, String address,
			String homePhone) {
		this.employeeId = employeeId;
		this.name = name;
		this.title = title;
		this.address = address;
		this.homePhone = homePhone;
	}

	/**
	 * It returns employeeId
	 *
	 * @return int
	 */
	String getemployeeID() {
		return this.employeeId;

	}

	/**
	 * It returns name
	 *
	 * @return String
	 */
	String getname() {
		return this.name;

	}

	/**
	 * It returns title
	 *
	 * @return String
	 */
	String gettitle() {
		return this.title;

	}

	/**
	 * I returns address
	 *
	 * @return String
	 */
	String getaddress() {
		return this.address;

	}

	/**
	 * it returns homePhoneNumber
	 *
	 * @return String
	 */
	String gethomephone() {
		return this.homePhone;

	}

	/**
	 * it returns EmployID
	 *
	 * @return int
	 */

	String getEmpID() {
		return this.employeeId;
	}
}
