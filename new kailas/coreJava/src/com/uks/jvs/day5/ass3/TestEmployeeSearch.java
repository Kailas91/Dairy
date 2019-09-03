package com.uks.jvs.day5.ass3;

/**
 * Date:24/06/2019
 * Assignment: Day 5
 * Task: Searching the record
 *
 * @author Kailas
 */

import java.io.FileNotFoundException;


public class TestEmployeeSearch {
	public static void main(String[] args) throws FileNotFoundException {
		EmployeeSearch employeeSearch = new EmployeeSearch();
		employeeSearch.setFilePath("C:/Users/Kailas/Desktop/Employees.txt");

		// type first name as well as last name to display record

		try{

			employeeSearch.searchEmployee(args[0]);
		// pass command line argument to RowPrinter class method
		}catch(Exception exception){
			System.out.println("Enetr file path To commandline argument :");

		}
		finally{
			employeeSearch = null;
		}
	}
}