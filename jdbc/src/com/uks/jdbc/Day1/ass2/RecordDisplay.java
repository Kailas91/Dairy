package com.uks.jdbc.Day1.ass2;

/**
 * @description : this class is used to fetch data from database and to display
 *              on console and filtered by using employee id
 * @author Kailas
 * Date : 2019/7/22
 *
 */
import java.sql.*;
import java.util.Scanner;

import Common.CommonConstant;

public class RecordDisplay {

	/**
	 * @param args
	 */
	// initializing the object of connection
	Statement objstatement = null;
	Statement stmt = null;
	ResultSet rs = null;
	String employeeId = null;
	String name = null;
	String title = null;
	String address = null;
	String homePhone = null;
	int counter = 0;

	// For Display the details of the employee class
	public void displayRecords(Connection objConnection) throws SQLException {
		try {
			stmt = objConnection.createStatement();
			// fire query and store result in resultSet
			ResultSet rs = stmt.executeQuery(CommonConstant.QUERY);
			// for formatting of the Headers

			System.out.printf("%5s %15s %30s %40s %45s \n", "EmployeeID", "EmployeeName", "Title", "FullAddress",
					"HomePhone");
			// loop will execute when all rows print
			while (rs.next()) {
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
				System.out.format("%-20s %-30s %-30s %-50s %-25s\n", employeeId, name, title, address, homePhone);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
	}

	// filter employee using employee id
	public void filterData(Connection objConnection) throws SQLException {
		stmt = objConnection.createStatement();
		System.out.println("Enter Employee ID to be filtered");
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int id = scan.nextInt();
		rs = stmt.executeQuery(CommonConstant.QUERY_ASS2 + id);

		if (!(id == 0)) {
			// is executed until no more rows is there
			display(rs);

			if (counter == 0) {
				System.out.println(" No Record Found");
				return;
			}

		}

	}

	// to display the records
	public void display(ResultSet rs) throws SQLException {
		while (rs.next()) {
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
			System.out.println("\n");
			// first displaying headers in data
			System.out.printf("%5s %15s %30s %40s %45s \n", "EmployeeID", "EmployeeName", "Title", "FullAddress",
					"HomePhone");
			System.out.println("\n");
			// Printing data
			System.out.format("%-20s %-30s %-30s %-50s %-25s\n", employeeId, name, title, address, homePhone);
			counter++;
		}
	}
}
