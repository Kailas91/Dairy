package com.uks.jvs.day5.ass4;

/**
 * Date:24/06/2019
 * Assignment: Day 5
 * Task: to display the record use  RowPrinter class
 *
 * @author Kailas
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class RowPrinter {
	 /* method printRows prints data from the input file
	  * @String
 * return type : void*/
	public void printRows(String filePath) throws FileNotFoundException{
		ArrayList<GeneralEmployee> employees;
		employees = new RowReader().readFile(filePath);
		int count=1;
		for(GeneralEmployee emp : employees){
				System.out.println("\nEmployee["+count+++"]:"+emp.empCode+"\nName:"+emp.firstName+" "+ emp.lastName + ""
						+ "\nEmployee Type:"+emp.empType+"\nSalary:"+emp.basicSal);
		}
	}
	 /* method printInTabularFormat prints data in tabular format
	  * @String
 * return type : void*/
	public void printInTabularFormat(String filePath) throws FileNotFoundException{
		ArrayList<GeneralEmployee> employees;
		employees = new RowReader().readFile(filePath);
		System.out.println("empCode\tfirstName\tlastName\tempType\tSalary");
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