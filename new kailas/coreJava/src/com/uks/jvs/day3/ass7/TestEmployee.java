package com.uks.jvs.day3.ass7;

/**
 * Assignment: Day 3
 * Task: Inner Class example of employee
 * Date:20/06/2019
 *
 * @author Kailas
 */
public class TestEmployee {

	// main method
	public static void main(String[] args) {
		try {
			// check two argument are present or not
			switch (args.length) {
			case 0: {
				System.out.println("Please enter name and basic salary of employee");
				return;
			}

			case 1: // Employee's name is given
				Employee employee = new Employee(args[0]);
				System.out.println("Employee Name : " + employee.getName());
			}
			Employee objemployee = new Employee(args[0]);

			// create inner class object of SalaryStructure and pass the salary
			// value through command line arguments
			Employee.SalaryStructure salaryStructure = new Employee().new SalaryStructure(
					new Double(args[1]).doubleValue());

			// display all Employee data
			System.out.print("\n Employee Name: " + objemployee.getName() + "\n Employee Basic Salary : "
					+ salaryStructure.getSalary() + "\n Employee HRA : " + salaryStructure.calculateHra()
					+ "\n Employee Total Salary : " + salaryStructure.getTotalSalary());
			// check user will enter salary or any other string
		} catch (NumberFormatException numberFormatException) {

			System.out.println("Invalid Salary. Please enter the salary in numeric value.");
		}
	}

}