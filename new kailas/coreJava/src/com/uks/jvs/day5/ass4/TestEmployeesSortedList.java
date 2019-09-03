package com.uks.jvs.day5.ass4;


/**
 * Date:24/06/2019
 * Assignment: Day 5
 * Task: Main class to  TestEmployeeSortedList
 *
 * @author Kailas
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.uks.jvs.day5.ass1.RowPrinter;
import com.uks.jvs.day5.ass2.RowToFileConverter;
import com.uks.jvs.day5.ass3.EmployeeSearch;

public class TestEmployeesSortedList {

	static private void takeInput() {
		System.out.println(
				"\n *************************************************************************************************");
		System.out.println("please enter your choice 1,2,3,4,5 only for demonstrate the Program 1 - 4 Assignment");
		System.out.println("1 for show Employee details...");
		System.out.println("2 for display employee details on console as well as save the file to another file 2");
		System.out.println("3 for serach an employee details in by its lastname...");
		System.out.println("4 for display data in sorted order tabuler format");

	}

	public static void main(String[] args) throws FileNotFoundException {

		Scanner scanner = new Scanner(System.in);

		EmployeeSortedList empSortedList = new EmployeeSortedList();
		EmployeeSearch employeeSearch = new EmployeeSearch();
		// new EmployeeSortedList().sortByColumn("lastName");

		ArrayList<GeneralEmployee> emps = new RowReader().readFile("C:/Users/Kailas/Desktop/Employees.txt");
		takeInput();
		try{


		System.out.println("Enetr your choice :");
		int choice = scanner.nextInt();
		switch (choice) {

		case 1:
			System.out.println("Enetr file path :");
			String stringpath = scanner.next();
			new RowPrinter().printRows(stringpath);
			break;
		case 2:
			System.out.println("Enetr input file path :");
			String inputpath = scanner.next();
			System.out.println("Enetr output file path :");
			String outputpath = scanner.next();
			new RowPrinter().printRows(inputpath);
			new RowToFileConverter().convertToFile(inputpath, outputpath);
			break;
		case 3:
			System.out.println("Enetr last Name or First Name to Search Record :");
			String stringName = scanner.next();
			employeeSearch.setFilePath("C:/Users/Kailas/Desktop/Employees.txt");
			employeeSearch.searchEmployee(stringName);
			break;
		case 4:
			
			System.out.println("Enetr Coloum name like firstName ,lastName, salary, empType which you want to sort");
			String colName = scanner.next();
			switch (colName) {
			case "firstName":
				empSortedList.sortByFirstName(emps);
				break;
			case "lastName":
				empSortedList.sortByLastName(emps);
				break;
			case "empType":
				empSortedList.sortByEmpType(emps);
				break;
			case "salary":
				empSortedList.sortBySalary(emps);
				break;
			default:
				System.out.println("By DEfault it will sort data with employee code \n");
				empSortedList.sortByEmpCode(emps);
				break;

			}
			scanner.close();
		}

		}catch(Exception e){
			System.out.println("enter valid number");
		}finally{
			employeeSearch = null;
			empSortedList = null;
		}

	}

}
