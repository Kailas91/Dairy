package com.uks.jvs.day5.ass2;

/**
 * Date:24/06/2019
 * Assignment: Day 5
 * Task: TestRowPrinter
 *
 * @author Kailas
 */
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.uks.jvs.day5.ass1.RowPrinter;

public class TestRowPrinter {

	/**
	 *
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String args[]) throws FileNotFoundException {

		// pass command line argument to RowPrinter class method
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter file read Path :");
		String fileToRead = scanner.next();
		new RowPrinter().printRows(fileToRead);
		System.out.println("Enter file write Path :");
		String fileToWrite = scanner.next();
		RowToFileConverter objRowToFileConverter = new RowToFileConverter();
		try{
			objRowToFileConverter.convertToFile(fileToRead, fileToWrite);

		// pass command line argument to RowPrinter class method
		}catch(Exception exception){
			System.out.println("Enetr path of file :"+exception);
			exception.printStackTrace();
		}
		finally{
			scanner.close();
			objRowToFileConverter=null;


		}


	}
}
