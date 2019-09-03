package com.uks.jdbc.Day2.ass2;

/**
 * this class is used to fetch data from data base
 *
 * @author Kailas
 * @date 24/7/2019
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Common.CommonConstant;

public class SalesByCategoryRunner {

	public String rowsPerPage = "5";
	public Connection connection = null;
	public ResultSet rs = null;
	public ResultSet rsForPage = null;
	public int numberOfColumns;

	Statement objstatement = null;
	String totalPrice = null;
	String productName = null;
	int counter = 0;
	public ArrayList<SalesByCatData> list = new ArrayList<SalesByCatData>();

	/**
	 * Constructor
	 *
	 * @param connection
	 */
	public SalesByCategoryRunner(Connection connection) {
		this.connection = connection;
	}

	/**
	 * this method calls Stored Procedures and return list
	 *
	 * @param categoryname
	 * @param orderyear
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<SalesByCatData> fetchRecords(String categoryname, String orderyear) throws SQLException {
		CallableStatement objCallableStatement = null;
		try {

			// this will call stored procedure from database and get data into
			// result set
			objCallableStatement = connection.prepareCall("{call northwind_kailas.SalesByCategory(?,?)}",
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			// pass string category name and order year to stored procedure
			objCallableStatement.setString(1, categoryname);
			objCallableStatement.setString(2, orderyear);

			rs = objCallableStatement.executeQuery();
			rs.last();
			numberOfColumns = rs.getRow();
			System.out.println("No of Result:" + rs.getRow());
			rs.beforeFirst();

			// get till result set is empty
			while (rs.next()) {
				list.add(new SalesByCatData(rs.getString(1), rs.getDouble(2)));

				if (rs.getRow() % 7 == 0) {
					break;
				}
				if (rs.getRow() >= numberOfColumns) {
					rs.beforeFirst();
					break;
				}
			}
		} finally {
			objCallableStatement = null;
			connection = null;
		}
		return list;

	}

	public void dispalysRecords(Connection objconnection,int pageno,String categoryname, String orderyear) {
		CallableStatement objCallableStatement = null;
		int totalPage = 0;
		int totalRows = 0;


		try {

			objCallableStatement = objconnection.prepareCall(CommonConstant.QUERYASS2,
					ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

			// pass string category name and order year to stored procedure
			objCallableStatement.setString(1, categoryname);
			objCallableStatement.setString(2, orderyear);
			rsForPage= objCallableStatement.executeQuery();

			// fire query and store result in resultSet
			// for formatting of the Headers
			rsForPage.last();
				totalRows = rsForPage.getRow();
				totalPage = totalRows / 5;
				rsForPage.beforeFirst();
				System.out.println(CommonConstant.TOTALPAGE+totalPage);

			if ((pageno == 0)) {
				System.out.println(CommonConstant.ZERO);
			} else {


				int startp = 5 * pageno-5;
				// calculating totalPages based on no of rows
				rsForPage.absolute(startp);
				if (pageno<=totalPage) {
					System.out.println("\n");
					System.out.printf(CommonConstant.HEADERF, "Product Name", "TotalPrise");
					System.out.println("------------------------------------------------------");
					int count=0;
					// loop will execute when all rows print
					while (rsForPage.next()) {
						//System.out.println("main loop");
						productName = rsForPage.getString(1);
						totalPrice = rsForPage.getString(2);
						count++;
						if (productName == null) {
							productName = "-";
						}
						if (totalPrice == null) {
							totalPrice = "-";
						}
						// Printing data
						System.out.format(CommonConstant.HEADERFO, productName, totalPrice);
						counter++;
						if(count==5){
							break;
						}

					}

					System.out.println("------------------------------------------------------");

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
	 * this method is used to go next page
	 *
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<SalesByCatData> nextPage() throws SQLException {

		while (rs.next()) {
			list.add(new SalesByCatData(rs.getString(1), rs.getDouble(2)));
			if (rs.getRow() % 7 == 0) {
				break;
			}
			if (rs.getRow() >= numberOfColumns) {
				rs.beforeFirst();
				break;

			}
		}
		return list;

	}

	/**
	 * this method is used to go previous page
	 *
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<SalesByCatData> previouspage() throws SQLException {

		while (rs.next()) {

			list.add(new SalesByCatData(rs.getString(1), rs.getDouble(2)));
			if (rs.getRow() % 7 == 0) {
				break;
			}
			if (rs.getRow() >= numberOfColumns) {
				rs.beforeFirst();
				break;
			}
		}
		return list;
	}
}
