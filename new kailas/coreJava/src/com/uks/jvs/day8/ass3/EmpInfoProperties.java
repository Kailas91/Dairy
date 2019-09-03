package com.uks.jvs.day8.ass3;

/**
 * Date:27/06/2019
 * Assignment: Day 8
 * Task:Test Thread in Java
 *
 * @author Kailas
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class EmpInfoProperties extends Thread {

	String path = null;
	String mode = null;

	/**
	 * Description : this is a parameterized constructor
	 * @param id = name or address
	 * @param mode = read or write
	 * @param path = output file path
	 */
	public EmpInfoProperties(String id, String mode, String path) {
		super(id);
		this.mode = mode;
		this.path = path;
	}

	private static StringBuilder sharedvariable = new StringBuilder();
	static int count = 0;

	private BufferedWriter objbufferedWriter;
	private BufferedReader objbufferedReader;
	private BufferedReader objbufferedReader2;

	public synchronized void writeToResource(String path) throws Exception {
		// method for write data in shared resource

		objbufferedReader = new BufferedReader(new FileReader(path));
		String line = null;
		try {

			while ((line = objbufferedReader.readLine()) != null) {
				
				if (currentThread().getName().equals("thread_1")) {
					System.out.println("reading now ");

					sharedvariable.append(line + System.getProperty("line.separator"));
					currentThread();
					Thread.sleep(500);

				} else if (currentThread().getName().equals("thread_2")) {
					System.out.println("writing now");
					sharedvariable.append(line + System.getProperty("line.separator"));
					currentThread();
					Thread.sleep(500);
				}

				// Thread.sleep(1000);
			}

		} catch (Exception exception) {
			System.out.println("Error in opration...");
		}

	}
	

	public void writeToFile(String path) throws Exception {
		// method for write data into file
		try {
			File file = new File(path);
			file.createNewFile();
			objbufferedWriter = new BufferedWriter(new FileWriter(file, true));
			objbufferedWriter.flush();
			objbufferedWriter.append(sharedvariable);
			objbufferedWriter.flush();
			this.path = path;

			sharedvariable = null;

			Thread.sleep(1000);
			objbufferedWriter.flush();
		} catch (Exception exception) {
		}

	}

	public synchronized void run() {
		System.out.println("Process " + currentThread().getName());
		if (mode.equalsIgnoreCase("READ")) {
			try {
				writeToResource(path);

			} catch (Exception exception) {
			}
		} else if (mode.equalsIgnoreCase("WRITE")) {
			if (sharedvariable.length() <= 0) {
				System.out.println("Shared resource is empty");
			} else {
				try {
					writeToFile(path);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	public void printAll() {
		// prints all resource data
		int i = 0;
		try {

			Thread.sleep(3000);
			objbufferedReader2 = new BufferedReader(new FileReader(path));
			String line = objbufferedReader2.readLine();
			while (line != null) {
				System.out.println(line);
				line = objbufferedReader2.readLine();
				i++;
			}
			System.out.println(i + " Rows Write sucessfully");
		} catch (Exception exception) {

		}
	}

	public StringBuilder getResource() {
		System.out.println(sharedvariable);
		return sharedvariable;
	}
}
