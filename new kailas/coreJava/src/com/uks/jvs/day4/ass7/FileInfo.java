package com.uks.jvs.day4.ass7;

/**
 * Date:21/06/2019
 * Assignment: Day 4
 * Task: Getting File info
 *
 * @author Kailas
 */
import java.io.File;
import java.util.Arrays;

public class FileInfo {

	/**
	 * @description - show file information like file , directory exists
	 * @param args
	 */
	void getDetails(String args[]) {

		// convert array into String format
		String stringPath = Arrays.toString(args).substring(1).replace("[", "").replace("]", "");
		System.out.println(stringPath);
		File file = new File(stringPath);

		// this function will file is present or not
		boolean isExists = file.exists();
		// this function will check this file or directory
		boolean isDir = file.isDirectory();
		// this function will check this file or not
		boolean isFile = file.isFile();

		System.out.println("File Is Avilable: " + isExists);
		System.out.println("Is Directory/Folder: " + isDir);
		System.out.println("Is file: " + isFile);
		System.out.println("Size: " + file.length());
	}
}
