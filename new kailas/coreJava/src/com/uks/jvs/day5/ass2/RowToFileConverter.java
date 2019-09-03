package com.uks.jvs.day5.ass2;

/**
 * Date:24/06/2019
 * Assignment: Day 5
 * Task:RowToFileConverter
 *
 * @author Kailas
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
public class RowToFileConverter {

	private PrintWriter printWriter;

	/*
	 * method convertToFile converts input array list data into output file by
	 * using file writing
	 *
	 * @String
	 *
	 * @String return type : void
	 */
	public void convertToFile(String inputFilePath, String outputFilePath) throws FileNotFoundException {
		ArrayList<GeneralEmployee> employees;
		employees = new RowReader().readFile(inputFilePath);
		File outputFile = new File(outputFilePath);
		printWriter = new PrintWriter(outputFile);
		int count = 1;
		for (GeneralEmployee emp : employees) {
			printWriter.println("\nEmployee["+count+++"]:"+emp.getEmpCode()+"\nName:"+emp.getFirstName()+" "+ emp.getLastName() + ""
					+ "\nEmployee Type:"+emp.getEmpType()+"\nSalary:"+emp.getBasicSalary());



		}
		System.out.println("data successfully write to the specified location of output file ");
		printWriter.close();
	}
}