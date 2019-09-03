package com.uks.jvs.day5.ass3;

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



import java.util.HashMap;

public class RowReader {
	private Scanner scanner;

	/*
	 * method readFile is used to read data from input file into array list
	 *
	 * @String return type : ArrayList
	 */
	public ArrayList<GeneralEmployee> readFile(String filePath) throws FileNotFoundException {
		File fin = new File(filePath);
		scanner = new Scanner(fin);
		String[] words;
		ArrayList<GeneralEmployee> employees = new ArrayList<>();
		while (scanner.hasNextLine()) {
	    	try{
		    	words = scanner.nextLine().split(",");
		    	double salary=Double.parseDouble(words[4]);
		    	employees.add(new GeneralEmployee(words[0],words[1],words[2],words[3],salary));
		    }
		    catch(Exception exception){
		    	continue;
		    }
		    }
		    scanner.close();
			return employees;
	}

	/*
	 * method provideDetails puts employee data into hashmap
	 *
	 * @String return type : HashMap
	 */
	public HashMap<Integer, GeneralEmployee> provideDetails(String filePath) throws FileNotFoundException {
		HashMap<Integer, GeneralEmployee> hashMap = new HashMap<>();
		ArrayList<GeneralEmployee> emps = readFile(filePath);
		for (GeneralEmployee e : emps) {
			hashMap.put(Integer.parseInt(e.empCode), e);
		}
		return hashMap;
	}
}