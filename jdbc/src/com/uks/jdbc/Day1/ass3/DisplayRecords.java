package com.uks.jdbc.Day1.ass3;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Common.CommonConstant;

public class DisplayRecords {

	public void dispalysRecords(java.sql.Connection objconnection) {
		try {
			Statement stmt = objconnection.createStatement();
			// fire query and store result in resultSet
			ResultSet rs = stmt.executeQuery(CommonConstant.QUERY);
			// for formatting of the Headers
			System.out.printf("%5s %15s %30s %40s %45s \n", "EmployeeID", "EmployeeName", "Title", "FullAddress",
					"HomePhone");

			// loop will execute when all rows print
			while (rs.next()) {
				// Printing data
				System.out.format("%-20s %-30s %-30s %-50s %-25s \n", rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5));
			}
			System.out.println();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
