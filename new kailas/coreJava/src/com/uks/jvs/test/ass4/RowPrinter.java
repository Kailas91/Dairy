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

public class RowPrinter {

	 /* method printInTabularFormat prints data in tabular format
	  * @String
 * return type : void*/
	public void printInTabularFormat(String filePath) throws FileNotFoundException{
		ArrayList<GeneralEmployee> employees;
		employees = new RowReader().readFile(filePath);
		System.out.println("empCode firstName lastName empType Salary");
		for(GeneralEmployee emp : employees){
				System.out.println("\n"+emp.empCode+"\t"+emp.firstName+"\t"+ emp.lastName
						+ "\t"+emp.empType+"\t"+emp.basicSal);
		}
	}
	 /* method printRowsFromList prints data from the array list provided
	  * @ArrayList
 * return type : void*/
	public void printRowsFromList(ArrayList<GeneralEmployee> emps){
		System.out.println("empCode firstName lastName empType\tSalary");
		for(GeneralEmployee emp : emps){
			System.out.println("\n"+emp.empCode+"\t"+emp.firstName+"\t"+ emp.lastName
					+ "\t"+"\t"+emp.empType+"\t"+emp.basicSal);
	}
	}
}