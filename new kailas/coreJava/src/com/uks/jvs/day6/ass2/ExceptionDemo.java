package com.uks.jvs.day6.ass2;

/**
 * Date:25/06/2019
 * Assignment: Day 6
 * Task: Class TestExceptionDemo tests the ExceptionDemo class
 *
 * @author Kailas
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class ExceptionDemo {


	public void generateException() {
		// generating divide by zero exception
		try {
			int a = 1 / 0;
			System.out.println(a);
		} catch (Exception e) {
			System.out.println("Exception thrown");
			e.printStackTrace();
		}
	}
	
	/*
	 * method generateFileNotFoundException generates exception
	 * return type:void
	 *
	 *
	 */

	public void generateFileNotFoundException(String fileName) {
		  Writer writer;
			File file = new File(fileName);
		        writer = null;

		        try
		        {
		            writer = new FileWriter(fileName);
		            writer.write('a');
		        }
		        catch(final IOException ex)
		        {
		            System.err.println("error opening file: " + file.getAbsolutePath());
		        }
	}
	/*
	 * method generateIOException generates IO exception
	 * return type : void
	 */
	public void generateIOException() {

		try {
			File file = new File("kdl.txt");
			Scanner sc = new Scanner(file);
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
		} catch (IOException e) {
			System.out.println("IO Exception Thrown");
			e.printStackTrace();
		}
	}
	/*
	 * method generateException generates the exception
	 * return type : void
	 */


}
