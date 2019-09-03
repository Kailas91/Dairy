package com.uks.jvs.test.ass4;

/**
 * Date:5/07/2019
 * Assignment: 4 Evaluation test
 * Task: sorting data using hashmap
 *
 * @author Kailas
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EmployeeSortedList {


	/*
	 * method sortByEmpCode sorts data by using employee code of employee as a
	 * key
	 *
	 * @ArrayList return type : void
	 */
	public void sortByEmpCode(ArrayList<GeneralEmployee> emps) throws FileNotFoundException {
		Collections.sort(emps, new CustomerSortingByEmpCode());
		new RowPrinter().printRowsFromList(emps);

	}

	class CustomerSortingByEmpCode implements Comparator<GeneralEmployee> {
		public int compare(GeneralEmployee a, GeneralEmployee b) {
			return Integer.parseInt(a.empCode) < Integer.parseInt(b.empCode) ? -1
					: Integer.parseInt(a.empCode) == Integer.parseInt(b.empCode) ? 0 : 1;
		}
	}
}