package com.uks.jdbc.Day2.ass1;

/**
 * this class is used display results from the database
 *
 * @author Kailas
 * Date : 23/7/2019
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import Common.CommonConstant;

/**
 * this class is used to get and set the results from the database
 *
 * @author Kailas Date : 23/7/2019
 */
public class DisplayUI {

	static int numberOfColumns;
	static ResultSet objResultSet = null;
	static ArrayList<EmpData> list = new ArrayList<EmpData>();
	static RowsFetcher objRowsFetcher = null;
	private int rowsPerPage = 5;
	Statement objstatement = null;
	String employeeId = null;
	String name = null;
	String title = null;
	String address = null;
	String homePhone = null;
	int counter = 0;

	/**
	 * this methed takes result from "getRowsPerPage" method of Rowsfetcher and
	 * displays it
	 *
	 * @param objRowsFetcher
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public void displayRowsPerPage(String userInput) throws ClassNotFoundException, SQLException, IOException {
		try {
			if (userInput.equalsIgnoreCase("N")) {
				if (objResultSet.getRow() == 0) { // fetch the records and
													// display if result set
													// pointer is on row = 0
					list = objRowsFetcher.getRowsPerPage(userInput);
					display(list);
					checkinput();
				}

				if ((objResultSet.getRow() % 7) == 0) {// fetch the records and
														// display if result set
														// pointer is on row is
														// divisible by 7
					list = objRowsFetcher.getRowsPerPage(userInput);
					display(list);

					if (objResultSet.getRow() == numberOfColumns || objResultSet.getRow() == (numberOfColumns - 1)) {
						checkinputSecond();
					} else {
						checkinputFirst();
					}
				}
				if (objResultSet.getRow() == numberOfColumns) {

					checkinputSecond();
				}
			}
			if (userInput.equalsIgnoreCase("X")) {
				System.exit(0);
			}

			if (userInput.equalsIgnoreCase("P")) {
				if ((objResultSet.getRow() % 7) == 0) {
					list = objRowsFetcher.getRowsPerPage(userInput);
					display(list);

					if ((objResultSet.getRow() != 0) && objResultSet.getRow() < numberOfColumns) {
						if (objResultSet.getRow() == numberOfColumns
								|| objResultSet.getRow() == (numberOfColumns - 1)) {
							checkinputSecond();
						} else {
							checkinputFirst();
						}

					}
					if (objResultSet.getRow() == 0 || objResultSet.getRow() == 7) {
						checkinput();
					} else {
						checkinputFirst();
					}

				}
				if (objResultSet.getRow() == numberOfColumns) {
					list = objRowsFetcher.getRowsPerPage(userInput);
					display(list);
					checkinput();
				}
			}

		} finally {
		}
	}

	/**
	 * this method is used to takes object of resultset and object ofRowsFetcher
	 *
	 * @param objRowsFetcher1
	 * @param rs1
	 * @throws SQLException
	 */
	public void pass(RowsFetcher objRowsFetcherone, ResultSet objResultSet1) throws SQLException {
		objRowsFetcher = objRowsFetcherone;
		objResultSet = objResultSet1;
		objResultSet.last();
		numberOfColumns = objResultSet.getRow();
		objResultSet.beforeFirst();
	}

	/**
	 * this method is used to take input from user
	 *
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void checkinput() throws SQLException, ClassNotFoundException, IOException {
		Scanner objscanner = null;
		String inputtwo = null;
		DisplayUI objDisplayUI = new DisplayUI();
		try {

			objscanner = new Scanner(System.in);
			System.out.println(CommonConstant.NEXT);
			System.out.println(CommonConstant.EXIT);
			System.out.print(CommonConstant.CHOICE);
			inputtwo = objscanner.next();

			if (inputtwo.equalsIgnoreCase("N") || inputtwo.equalsIgnoreCase("X")) {
				objDisplayUI.displayRowsPerPage(inputtwo);
			} else {
				System.out.println(CommonConstant.INVALIDCHOICE);
				checkinput();
			}

		} finally {
			objscanner = null;
			inputtwo = null;
		}
	}

	/**
	 * * this method is used to take input from user
	 *
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void checkinputFirst() throws SQLException, ClassNotFoundException, IOException {
		Scanner objscanner = null;
		String inputtwo = null;
		DisplayUI objDisplayUI = new DisplayUI();
		try {
			objscanner = new Scanner(System.in);

			System.out.println(CommonConstant.BACK);
			System.out.println(CommonConstant.NEXT);
			System.out.println(CommonConstant.EXIT);
			System.out.print(CommonConstant.CHOICE);
			inputtwo = objscanner.next();

			if (inputtwo.equalsIgnoreCase("N") || inputtwo.equalsIgnoreCase("P") || inputtwo.equalsIgnoreCase("X")) {

				objDisplayUI.displayRowsPerPage(inputtwo);

			} else {
				System.out.println(CommonConstant.INVALIDCHOICE);
				checkinputFirst();
			}

		} finally {
			objscanner = null;
			inputtwo = null;
		}
	}

	/**
	 * this method is used to take input from user
	 *
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void checkinputSecond() throws SQLException, ClassNotFoundException, IOException {
		Scanner objscanner = null;
		String inputtwo = null;
		DisplayUI objDisplayUI = new DisplayUI();

		try {
			objscanner = new Scanner(System.in);

			System.out.println(CommonConstant.BACK);
			System.out.println(CommonConstant.EXIT);
			System.out.print(CommonConstant.CHOICE);
			inputtwo = objscanner.next();

			if (inputtwo.equalsIgnoreCase("P") || inputtwo.equalsIgnoreCase("X")) {
				objDisplayUI.displayRowsPerPage(inputtwo);
			} else {
				System.out.println(CommonConstant.INVALIDCHOICE);
				checkinputSecond();
			}

		} finally {
			objscanner = null;
			inputtwo = null;
		}
	}

	/**
	 * this method is used to display the results when entering page number
	 *
	 * @param list
	 * @return null
	 */

	public void dispalysRecords(Connection objconnection, int pageno) {
		int totalPage = 0;
		int totalRows = 0;

		try {
			objstatement = objconnection.createStatement();
			// fire query and store result in resultSet
			// for formatting of the Headers

			if ((pageno == 0)) {
				System.out.println(CommonConstant.ZERO);
			} else {
				int startp = 5 * pageno - 5;

				ResultSet rs = objstatement.executeQuery(CommonConstant.QUERYDAY2);
				rs.last();
				totalRows = rs.getRow();
				// calculating totalPages based on no of rows
				totalPage = totalRows / rowsPerPage;

				System.out.println(CommonConstant.TOTALPAGE+totalPage);

				rs.absolute(startp);
				if (pageno<=totalPage) {
					System.out.printf(CommonConstant.HEADERFORMATSTARTING, "EmployeeID", "EmployeeName", "Title",
							"FullAddress", "HomePhone");

					System.out.println("------------------------------------------------------"
							+ "----------------------------------------------------------------------------------------------------------");
					// loop will execute when all rows print
					int count=0;
					while (rs.next()) {
						count++;
						employeeId = rs.getString(1);
						name = rs.getString(2);
						title = rs.getString(3);
						address = rs.getString(4);
						homePhone = rs.getString(5);
						if (employeeId == null) {
							employeeId = "-";
						}
						if (name == null) {
							name = "-";
						}
						if (title == null) {
							title = "-";
						}
						if (address == null) {
							address = "-";
						}
						if (homePhone == null) {
							homePhone = "-";
						}

						// Printing data
						System.out.format(CommonConstant.HEADERFORMAT, employeeId, name, title, address, homePhone);
						if(count==5){
							break;
						}
						counter++;
					}
					System.out.println("------------------------------------------------------"
							+ "----------------------------------------------------------------------------------------------------------");


					if (counter == 0) {
						System.out.println(CommonConstant.NOFOUND);
						return;
					}

				} else {
					System.out.println(CommonConstant.NOFOUND);
				}
			}

		} catch (SQLException e) {

		}

	}

	/**
	 * this method is used to display the results when pressing next and
	 * previous
	 *
	 * @param list
	 * @return null
	 */

	public void display(List<EmpData> listone) {
		EmpData objEmpData = null;
		ListIterator<EmpData> objListIterator = null;
		try {
			objListIterator = listone.listIterator();
			System.out.printf(CommonConstant.HEADERFORMATSTARTING, "EmployeeID", "EmployeeName", "Title", "FullAddress",
					"HomePhone");
			System.out.println("------------------------------------------------------"
					+ "----------------------------------------------------------------------------------------------------------");
			while (objListIterator.hasNext()) {
				objEmpData = objListIterator.next();

				employeeId = objEmpData.getEmpID();
				name = objEmpData.getname();
				title = objEmpData.gettitle();
				address = objEmpData.getaddress();
				homePhone = objEmpData.gethomephone();
				if (employeeId == null) {
					employeeId = "-";
				}
				if (name == null) {
					name = "-";
				}
				if (title == null) {
					title = "-";
				}
				if (address == null) {
					address = "-";
				}
				if (homePhone == null) {
					homePhone = "-";
				}
				System.out.format(CommonConstant.HEADERFORMAT, employeeId, name, title, address, homePhone);

				objListIterator.remove();
			}

			System.out.println("------------------------------------------------------"
					+ "----------------------------------------------------------------------------------------------------------");

		} finally {
			objEmpData = null;
			objListIterator = null;
		}
	}

}