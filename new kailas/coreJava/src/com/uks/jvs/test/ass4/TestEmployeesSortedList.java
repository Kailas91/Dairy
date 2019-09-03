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

public class TestEmployeesSortedList {

	public static void main(String[] args) throws FileNotFoundException {

		String path = "C:/Users/Kailas/Desktop/Employes.txt";
		EmployeeSortedList empSortedList;
		RowPrinter objRowPrinter = new RowPrinter();
		try {
			 empSortedList = new EmployeeSortedList();
			ArrayList<GeneralEmployee> emps = new RowReader().readFile(path);
			System.out.println("Before sort data with employee code \n");
			objRowPrinter.printInTabularFormat(path);
			System.out.println("\n ------------------------------------------------------------- \n");
			System.out.println("After sort data with employee code \n");
			empSortedList.sortByEmpCode(emps);

		} catch (Exception e) {
			System.out.println("file path is not valid");
		} finally {

			empSortedList = null;
		}

	}

}
