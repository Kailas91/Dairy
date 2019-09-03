package com.uks.jvs.day5.ass5;

/**
 * Date:24/06/2019
 * Assignment: Day 5
 * Task: Directory Listing Program
 *
 * @author Kailas
 */
import java.io.File;
import java.util.Scanner;

public class DirectoryListing {
	/**
	 * This method is used to take input from keyboard and send it to Recursion
	 * class
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		String ext="";
		Scanner S = new Scanner(System.in);
		try{

		Boolean isRecursive = true;
		System.out.println("Enter the Directory:");
		String dir = S.nextLine();
		System.out.println("Enter the file extesion:");
			ext = S.nextLine();
		System.out.println("Enter the recursion");
		String Stringcheck = S.next();
		if (Stringcheck.equalsIgnoreCase("T") || Stringcheck.equals("1")) {
			isRecursive = true;
		} else if (Stringcheck.equalsIgnoreCase("F") || Stringcheck.equals("0")) {
			isRecursive = false;
		}

		// call listOutFile method by passing path , file extension and recursive is true or false
		listOutFile(dir, ext, isRecursive);
	}
	catch(Exception exception){
		System.out.println("Enter valid input");
	}
		finally{
			S.close();
		}
	}
	/**
	 * Description : listOutFile method will display list of files and directories in given path
	 * @param path
	 * @param ext
	 * @param rec
	 */
	public static void listOutFile(String path, String ext, Boolean rec) {

		// to get path as a file
		File file = new File(path);
		if (file.isDirectory()) {
			File[] listoffiles = file.listFiles();
			for (File file1 : listoffiles) {
				if (file1.isFile()) {
					String filename = file1.getName();

					// extension is * means display all files and directories in given path
					if (ext.equals("*")) {
						System.out.println("Filename" + filename);
					} else {

						String strext = filename.substring(
								filename.indexOf(".") + 1, filename.length());
						if (ext.contains(strext)) {
							System.out.println("path:"
									+ file1.getAbsolutePath() + "filename:"
									+ filename);
						}
					}
				} else if (rec) {
					listOutFile(file1.getAbsolutePath(), ext, rec);
				}
			}
		} else {
			// validate directory is present or not
			System.out.println("not found");
		}
	}
}
