package com.uks.jvs.day5.ass2;

/**
 * Date:24/06/2019
 * Assignment: Day 5
 * Task: to display the result
 *
 * @author Kailas
 */
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class RowPrinter {
	/**
	 * @description - print all employee details in normal form
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void printRows(String filePath) throws FileNotFoundException{

		// create array list and pass the value using GeneralEmployee object
		ArrayList<GeneralEmployee> employees = new RowReader().readFile(filePath);
		int count=1;
		// for each loop is used for get the values of base class into derived class using parameterized constructor
		for(GeneralEmployee emp : employees){

			// call method using derived class object
				System.out.println("\nEmployee["+count+++"]:"+emp.getEmpCode()+"\nName:"+emp.getFirstName()+" "+ emp.getLastName() + ""
						+ "\nEmployee Type:"+emp.getEmpType()+"\nSalary:"+emp.getBasicSalary());

		}
	}

}

