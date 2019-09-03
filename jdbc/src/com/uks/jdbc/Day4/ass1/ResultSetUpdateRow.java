package com.uks.jdbc.Day4.ass1;
/**
 * this class is used to Update data in to data base
 *
 *  @author Kailas
 * @date 29/7/2019
 **/

import java.sql.Connection;

/**
 * this class is used to connect database and insert data into database
 *
 *  @author Kailas
 * @date 26/7/2019
 **/

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Common.CommonConstant;

public class ResultSetUpdateRow {
	Statement objstatement = null;
	ResultSet rs = null;
	ResultSet rs2 = null;
	ResultSet rsForDisplay = null;
	Scanner scanner = null;
	/**
	 * this method is used to insert data in result set
	 */
	public void insertRow(Connection objconnection) {



		try {

			scanner = new Scanner(System.in);
			// Create a Statement for scrollable ResultSet
			objstatement = objconnection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
			// Catch the ResultSet object
			rs = objstatement.executeQuery(CommonConstant.DaythreeQuerytwo);
			System.out.println(CommonConstant.BEFORE_Update + "\n");
			dispalysRecords();
			// Move the cursor to the insert row
			System.out.println(CommonConstant.GETID);
			//rs.absolute(scanner.nextInt());
			rs2 = objstatement.executeQuery(CommonConstant.QUERYFORID+scanner.nextInt());
			rs2.first();
			System.out.println(CommonConstant.UPDATE);
			System.out.println(CommonConstant.IP_COMPANY_NAME);
			// update string
			rs2.updateString(CommonConstant.COMPANY_NAME,scanner.next());
			System.out.println(CommonConstant.IP_CONTACT_NAME);

			rs2.updateString(CommonConstant.CONTACTNAME, scanner.next());
			System.out.println(CommonConstant.IP_CONTACT_TITLE);
			rs2.updateString(CommonConstant.CONTACTTITLE, scanner.next());
			// Store the data into database
			rs2.updateRow();
			// Move the cursor back to the current row
			//rs.moveToCurrentRow();
			System.out.println("\n" + CommonConstant.ROW_INSERT + "\n");
			System.out.println(CommonConstant.AFTER_Update + "\n");
			rs = objstatement.executeQuery(CommonConstant.DaythreeQuerytwo);
			dispalysRecords();
			// Close ResultSet and Statement
			//rs.close();
			objstatement.close();

		} catch (Exception e) {
			System.err.println(CommonConstant.Exception + e.getMessage());
			e.printStackTrace();

		} finally {
			if (rs != null) {
				rs = null;
			}
			if (objstatement != null) {
				objstatement = null;
			}

		}
	}

	/**
	 * This is used to execute query and prints
	 */
	public void dispalysRecords() {

		String id = null;
		String companyName = null;
		String contactName = null;
		String contactTitle = null;
		String address = null;
		String city = null;
		try {

			System.out.printf(CommonConstant.SUPPLIERS, "id", "companyName", "contactName", " contactTitle",
					"FullAddress", "city");
			System.out.println("--------------------------------------------------------------------"
					+ "----------------------------------------------------------------------------------------------------");
			// loop will execute when all rows print
			while (rs.next()) {
				id = rs.getString(1);
				companyName = rs.getString(2);
				contactName = rs.getString(3);
				contactTitle = rs.getString(4);
				address = rs.getString(5);
				city = rs.getString(6);
				if (companyName == null) {
					companyName = "-";
				}
				if (contactName == null) {
					contactName = "-";
				}
				if (contactTitle == null) {
					contactTitle = "-";
				}
				if (address == null) {
					address = "-";
				}
				if (city == null) {
					city = "-";
				}
				// Printing data
				System.out.format(CommonConstant.SUPPLIERSHEADERFORMAT, id, companyName, contactName, contactTitle,
						address, city);
			}
			System.out.println("--------------------------------------------------------------------"
					+ "----------------------------------------------------------------------------------------------------");

			System.out.println();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
