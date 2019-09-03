package com.uks.jvs.day5.ass4;


/**
 * Date:24/06/2019
 * Assignment: Day 5
 * Task: Output will stored on file
 *
 * @author Kailas
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import  com.uks.jvs.day5.ass4.GeneralEmployee;
import  com.uks.jvs.day5.ass4.RowReader;

public class RowToFileConverter {
	private PrintWriter printWriter;
	 /* method convertToFile converts input data into output file
	  * @String
	  * @String
 * return type : void*/
	public void convertToFile(String inputFilePath,String outputFilePath) throws FileNotFoundException{
		ArrayList<GeneralEmployee> employees;
		employees = new RowReader().readFile(inputFilePath);
		File outputFile = new File(outputFilePath);
		printWriter = new PrintWriter(outputFile);
		for(GeneralEmployee emp : employees){
			printWriter.println(emp.empCode+","+emp.firstName+","+ emp.lastName + ","
					+emp.empType+","+emp.basicSal);
		}
		printWriter.close();
	}
	 /* method convertToFile converts input data into output file
	  * @ArrayList
	  * @String
 * return type : void*/
	public void convertToFile(ArrayList<GeneralEmployee> emps,String outputFilePath) throws FileNotFoundException{
		File outputFile = new File(outputFilePath);
		PrintWriter printWriter = new PrintWriter(outputFile);
		for (GeneralEmployee emp : emps){

			printWriter.println(emp.empCode+","+emp.firstName+","+ emp.lastName + ","
					+emp.empType+","+emp.basicSal);
		}
		printWriter.close();
	}
}
