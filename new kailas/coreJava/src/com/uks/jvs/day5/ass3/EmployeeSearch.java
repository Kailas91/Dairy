package com.uks.jvs.day5.ass3;

/**
 * Date:24/06/2019
 * Assignment: Day 5
 * Task: Searching the record
 *
 * @author Kailas
 */
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class EmployeeSearch {
	String filePath;

	/*
	 * method searchEmployee searches input data and returns resultant rows
	 * matched
	 *
	 * @String return type : void
	 */
	public void searchEmployee(String lastName) throws FileNotFoundException {
		HashMap<Integer, GeneralEmployee> hashMap = new RowReader().provideDetails(this.filePath);
		TreeMap<Integer, GeneralEmployee> treeMap = new TreeMap<>();
		treeMap.putAll(hashMap);
		// using for-each loop for iteration over Map.entrySet()
		int count = 1;
		for (Entry<Integer, GeneralEmployee> entry : treeMap.entrySet()) {
			if (entry.getValue().lastName.equalsIgnoreCase(lastName)||entry.getValue().firstName.equalsIgnoreCase(lastName)) {
				System.out.println("\nEmployee[" + count++ + "]:" + entry.getValue().empCode + "\nName:"
						+ entry.getValue().firstName + " " + entry.getValue().lastName + "" + "\nEmployee Type:"
						+ entry.getValue().empType + "\nSalary:" + entry.getValue().basicSal);
			}
		}
	}



	/*
	 * method setFilePath used to set the filepath return type : void
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}