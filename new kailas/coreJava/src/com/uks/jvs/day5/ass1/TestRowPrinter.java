package com.uks.jvs.day5.ass1;

/**
 * Date:24/06/2019
 * Assignment: Day 5
 * Task: TestRowPrinter
 *
 * @author Kailas
 */
import java.io.FileNotFoundException;


public class TestRowPrinter {

	/**
	 *
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String args[]) throws FileNotFoundException {
		RowPrinter objRowPrinter = new RowPrinter();
		try{
			objRowPrinter.printRows(args[0]);
			
		// pass command line argument to RowPrinter class method
		}catch(Exception exception){
			System.out.println("Enetr correct text file path To commandline argument :");
		}
		finally{
			objRowPrinter = null;
		}

	}
}
