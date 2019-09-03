package com.uks.jvs.day5.ass2;

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
	public ArrayList<GeneralEmployee> readFile(String filePath) throws FileNotFoundException{

		File fileinput = new File(filePath);
		scanner = new Scanner(fileinput);
		    String[] words;
		    ArrayList<GeneralEmployee> employees = new ArrayList<>();
		    while(scanner.hasNextLine()){
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

}



