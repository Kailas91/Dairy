package com.uks.jdbc.Day3.ass1;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.WebRowSet;

import Common.CommonConstant;

/**
 * This class is used to display the reslut onto console
 *
 * @author kailas
 * @date 25/7/2019
 */
public class RowSetDisplayer {

	 public RowSetDisplayerMain objRowSetDisplayerMain = null;

	/**
	 * this class takes input from users and calls various method by passing
	 * those inputs
	 *
	 * @param typeOfRowSet
	 * @throws Exception
	 */

	public void DisplayEmpData(String typeOfRowSet) throws Exception {
		@SuppressWarnings("resource")
		Scanner objScanner = new Scanner(System.in);
	 DataFetcher objDataFetcher = null;

		 CachedRowSet objCachedRowSet = null;
		 WebRowSet objWebRowSet = null;
		 FileWriter objFileWriter = null;
		 String input = null;//used to take input from users about the type of file
		try {
			objDataFetcher = new DataFetcher();

			if (typeOfRowSet.equalsIgnoreCase("1")) {
				// connection is made
				objDataFetcher.connect();

				// object of CachedRowSet is taken
				objCachedRowSet = objDataFetcher.executeInCached();

				System.out.printf(CommonConstant.HEADERASS1,
						"EmployeeID", "FirstName", "LastName", "Title",
						"\t\tBirthDate");
				System.out.println("--------------------------------------------------------"
						+ "----------------------------------------------------------------------");


				// object of CachedRowSet is printed
				while (objCachedRowSet.next()) {
					System.out.printf(CommonConstant.HEADERASS1O,
							objCachedRowSet.getInt(1),
							objCachedRowSet.getString(2),
							objCachedRowSet.getString(3),
							objCachedRowSet.getString(4),
							objCachedRowSet.getDate("BirthDate"));
				}
				System.out.println("--------------------------------------------------------"
						+ "----------------------------------------------------------------------");

			} else if (typeOfRowSet.equalsIgnoreCase("2")) {

				// connection is made
				objDataFetcher.connect();

				// object of WebRowSet is taken
				objWebRowSet = objDataFetcher.executeInXML();

				// file object is created
				File file = new File(CommonConstant.PATH);
				//
				objFileWriter = new FileWriter(file);
				System.out.println(CommonConstant.WRITETOFILE
						+ file.getAbsolutePath());
				// writeXml method is used to write object to xml file
				objWebRowSet.writeXml(objFileWriter);

				objFileWriter.flush();
				objFileWriter.close();

			} else {
				System.out.println("\n\tERROR OCCURED\n");
			}

			System.out.println(CommonConstant.EXIT);
			System.out.println(CommonConstant.BACKMENU);
			System.out.println(CommonConstant.CHOICE);
			input = objScanner.next();
			objRowSetDisplayerMain = new RowSetDisplayerMain();
			if (input.equalsIgnoreCase("X")) {
				System.exit(0);
			}
			if (input.equalsIgnoreCase("B")) {
				RowSetDisplayerMain.main(null);
			} else {

			}
		} finally {
			if (objCachedRowSet != null)
				objCachedRowSet = null;
			if (objWebRowSet != null)
				objWebRowSet = null;
			if (objFileWriter != null)
				objFileWriter = null;
		}
	}

}
