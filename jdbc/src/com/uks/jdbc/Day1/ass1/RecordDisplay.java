package com.uks.jdbc.Day1.ass1;

/**
 * @description : this class is used to fetch data from database and to display
 *              on console
 * @author Kailas
 * Date : 2019/7/22
 *
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Common.CommonConstant;
import Common.CommonDBLogic;;
public class RecordDisplay {


	Statement objstatement = null;

	CommonDBLogic objCommonDBLogic =null;
	/**
	 * This method is used to register and provide connection with database
	 */


	/**
	 * This is used to execute query and prints
	 */
	public void dispalysRecords(Connection objConnection) {
		String employeeId = null;
		String name = null;
		String title = null;
		String address = null;
		String homePhone = null;
		try {
			objstatement = objConnection.createStatement();
			// fire query and store result in resultSet
			ResultSet rs = objstatement.executeQuery(CommonConstant.QUERY);
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
			System.out.println();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
