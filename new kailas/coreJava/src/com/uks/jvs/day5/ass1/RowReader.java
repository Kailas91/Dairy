package com.uks.jvs.day5.ass1;

/**
 * Date:24/06/2019
 * Assignment: Day 5
 * Task: Read the input and pass to GeneralEmployee object
 *
 * @author Kailas
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RowReader {
	Scanner scanner;

	/**
	 *
	 * @param filePath
	 * @return
	 * @throws FileNotFoundException
	 */
	public ArrayList<GeneralEmployee> readFile(String filePath) throws FileNotFoundException {
		ArrayList<GeneralEmployee> employees = null;
		File fileinput = new File(filePath);

		if (fileinput.isFile() && fileinput.getName().endsWith(".txt")) {

			if (fileinput.isFile()) {

				long size = fileinput.length();
				if (size != 0) {
					scanner = new Scanner(fileinput);
					String[] words = null;
					employees = new ArrayList<>();
					while (scanner.hasNextLine()) {

						try {
							    words = scanner.next().split(",");
								//double salary = Double.parseDouble(words[4]);
						}catch (Exception e) {
									continue;
							}
							    try{
								employees.add(new GeneralEmployee(words[0], words[1], words[2], words[3],Double.parseDouble(words[4])));

						} catch (Exception e) {
							System.out.println("Invalid file format");
						}
					}
				} else {
					System.out.println("Empty file or Invalid file");
				}
			}
		} else {
			System.out.println("It is not a text file ");
		}
		scanner.close();
		return employees;
	}

}
