package com.uks.jvs.day3.ass7;

/**
 * Assignment: Day 3
 * Task: Inner Class example of employee
 * Date:20/06/2019
 *
 * @author Kailas
 */
public class Employee {

	private String _name; // Emplyee's name must be private

	public Employee() {
	} // Default Constructor used when creating inner object

	public Employee(String name) {
		this._name = name;
	}

	public void setName(String name) {
		this._name = name;
	}

	public String getName() {
		return this._name;
	}
	// Inner class

	class SalaryStructure {
		private double basicSal; // Employee's Basic Salary
		private double hra; // Employee's HRA

		public SalaryStructure(double salary) {
			this.basicSal = salary;
		}

		public void setSalary(long salary) {
			this.basicSal = salary;
		}

		public double getSalary() {
			return this.basicSal;
		}

		public double calculateHra() {
			this.hra = (this.basicSal * 12.5) / 100;
			return this.hra;
		}

		public double getTotalSalary() {
			return (this.basicSal + this.hra);
		}
	}

}
