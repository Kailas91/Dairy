package com.uks.jvs.day5.ass4;

/**
 * Date:24/06/2019
 * Assignment: Day 5
 * Task: Sorting  the record
 *
 * @author Kailas
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeSortedList {

	/*
	 * method sortByFirstName sorts data by using first name of employee as a
	 * key
	 *
	 * @ArrayList return type : void
	 */
	public void sortByFirstName(ArrayList<GeneralEmployee> emps) throws FileNotFoundException {
		Collections.sort(emps, new SortingByFirstName());
		new RowPrinter().printRowsFromList(emps);
		new RowToFileConverter().convertToFile(emps, "SortedEmployees.txt");
	}

	/*
	 * method sortByLastName sorts data by using last name of employee as a key
	 *
	 * @ArrayList return type : void
	 */
	public void sortByLastName(ArrayList<GeneralEmployee> emps) throws FileNotFoundException {
		Collections.sort(emps, new SortingByLastName());
		new RowPrinter().printRowsFromList(emps);
		new RowToFileConverter().convertToFile(emps, "SortedEmployees.txt");
	}

	/*
	 * method sortByEmpType sorts data by using employee type of employee as a
	 * key
	 *
	 * @ArrayList return type : void
	 */
	public void sortByEmpType(ArrayList<GeneralEmployee> emps) throws FileNotFoundException {
		Collections.sort(emps, new SortingByEmpType());
		new RowPrinter().printRowsFromList(emps);
		new RowToFileConverter().convertToFile(emps, "SortedEmployees.txt");
	}

	/*
	 * method sortBySalary sorts data by using employee salary of employee as a
	 * key
	 *
	 * @ArrayList return type : void
	 */
	public void sortBySalary(ArrayList<GeneralEmployee> emps) throws FileNotFoundException {
		Collections.sort(emps, new SortingBySalary());
		new RowPrinter().printRowsFromList(emps);
		new RowToFileConverter().convertToFile(emps, "SortedEmployees.txt");
	}

	/*
	 * method sortByEmpCode sorts data by using employee code of employee as a
	 * key
	 *
	 * @ArrayList return type : void
	 */
	public void sortByEmpCode(ArrayList<GeneralEmployee> emps) throws FileNotFoundException {
		Collections.sort(emps, new CustomerSortingByEmpCode());
		new RowPrinter().printRowsFromList(emps);
		new RowToFileConverter().convertToFile(emps, "SortedEmployees.txt");
	}

	class SortingByFirstName implements Comparator<GeneralEmployee> {
		public int compare(GeneralEmployee a, GeneralEmployee b) {
			return a.firstName.compareToIgnoreCase(b.firstName);
		}
	}

	class SortingByLastName implements Comparator<GeneralEmployee> {
		public int compare(GeneralEmployee a, GeneralEmployee b) {
			return a.lastName.compareToIgnoreCase(b.lastName);
		}
	}

	class SortingByEmpType implements Comparator<GeneralEmployee> {
		public int compare(GeneralEmployee a, GeneralEmployee b) {
			return a.empType.compareToIgnoreCase(b.empType);
		}
	}

	class SortingBySalary implements Comparator<GeneralEmployee> {
		public int compare(GeneralEmployee a, GeneralEmployee b) {
			return a.basicSal < b.basicSal ? -1 : a.basicSal == b.basicSal ? 0 : 1;
		}
	}

	class CustomerSortingByEmpCode implements Comparator<GeneralEmployee> {
		public int compare(GeneralEmployee a, GeneralEmployee b) {
			return Integer.parseInt(a.empCode) < Integer.parseInt(b.empCode) ? -1
					: Integer.parseInt(a.empCode) == Integer.parseInt(b.empCode) ? 0 : 1;
		}
	}
}