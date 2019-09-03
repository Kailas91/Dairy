package com.uks.jvs.day7.ass4;

/**
 * Date:26/06/2019
 * Assignment: Day 7
 * Task: Serialization and Deserialization program
 *
 * @author Kailas
 */
public class EmployeeDetail implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public String name;
	public Integer age;
	public Double salary;

	EmployeeDetail(String name, Integer age, Double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
}
