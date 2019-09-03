package com.uks.jvs.day5.ass3;

/**
 * Date:24/06/2019
 * Assignment: Day 5
 * Task: to display the result
 *
 * @author Kailas
 */
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class RowPrinter {
	 /* method printRows used to print data from the input file
	  * @String
     * return type : void*/
	public void printRows(String filePath) throws FileNotFoundException{
		ArrayList<GeneralEmployee> employees;
		employees = new RowReader().readFile(filePath);
		int count=1;
		for(GeneralEmployee emp : employees){
			System.out.println("\nEmployee[" + count++ + "]:" + emp.getEmpCode() + "\nName:" + emp.getFirstName() + " "
					+ emp.getLastName() + "" + "\nEmployee Type:" + emp.getEmpType() + "\nSalary:"
					+ emp.getBasicSalary());}
	}
}