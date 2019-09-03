package com.uks.jvs.day4.ass1;

/**
 * Date:21/06/2019
 * Assignment: Day 4
 * Task: Basics of Inheritance
 *
 * @author Kailas
 */
public class Employee {

	public String empFirstName;
	public String empLastName;
	public String empType;
// parameterized constructor to get  employee details
	public Employee(String empFirstName, String empLastName, String empType) {
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empType = empType;
		System.out.println("\n Employee First Name :" + empFirstName + "\n Employee Last Name :" + empLastName
				+ "\n Employee Type :" + empType);
	}
}
// extending the employee class
class ProjectLeader extends Employee {
	public String empFirstName;
	public String empLastName;

	public long empMonumber;
	private String empType = "PL";

	// pass employee details to class employee using super keyword
	public ProjectLeader(String empFirstName, String empLastName, String empType) {
		super(empFirstName, empLastName, empType);

		// TODO Auto-generated constructor stub
	}

	public void showPLdata(String empFirstName, String empLastName, long empMonumber) {
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empMonumber = empMonumber;

		System.out.println("\n Employee First Name :" + empFirstName + "\n Employee Last Name :" + empLastName
				+ "\n Employee Mobile No :" + empMonumber + "\n Employee Type :" + empType);
	}

}
