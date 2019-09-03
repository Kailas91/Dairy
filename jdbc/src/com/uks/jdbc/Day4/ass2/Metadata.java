package com.uks.jdbc.Day4.ass2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.sql.Statement;


import Common.CommonConstant;

/**
 * this class is used to get the meta data and print it
 *
 * @author Kailas
 * @date 29/7/2019
 */
public class Metadata {
	Connection connection = null;

	/**
	 * It is used to use meta data
	 *
	 * @throws SQLException
	 */
	public void infometadata(Connection connection) throws SQLException {

		Statement objstatement = null;
		try {
			objstatement = connection.createStatement();

			ResultSet objResultSet = objstatement.executeQuery(CommonConstant.DaythreeQueryfour);

			// object of ResultSetMetaData is created
			ResultSetMetaData objResultSetMetaData = objResultSet.getMetaData();

			// object of DatabaseMetaData is created for getting mysql database meta data
			DatabaseMetaData objMetaDataConnection =  connection.getMetaData();
			System.out.println("------------------------------------------------------------------------------------------");
			// DataBase MetaData
			System.out.println(CommonConstant.DRIVERNAME + objMetaDataConnection.getDriverName());
			System.out.println(CommonConstant.DRIVERVERSION + objMetaDataConnection.getDriverVersion());
			System.out.println(CommonConstant.USERNAME + objMetaDataConnection.getUserName());
			System.out.println(CommonConstant.DATABASENAME + objMetaDataConnection.getDatabaseProductName());
			System.out.println(CommonConstant.DATABASEVERSION + objMetaDataConnection.getDatabaseProductVersion());
			System.out.println("------------------------------------------------------------------------------------------");
			// counts no of columns in result
			int numberOfColumns = objResultSetMetaData.getColumnCount();

			for (int i = 1; i <= numberOfColumns; i++) {

				System.out.println("---------------------------------------");
				// getting column name
				System.out.println(CommonConstant.COL_NAME + objResultSetMetaData.getColumnName(i));
				// getting table name
				System.out.println(CommonConstant.TABLE_NAME + objResultSetMetaData.getTableName(i));
				// getting type of column
				System.out.println(CommonConstant.DATA_TYPE + objResultSetMetaData.getColumnTypeName(i));
				// checks column is Case sensitive or not
				System.out.println(CommonConstant.CASE + objResultSetMetaData.isCaseSensitive(i));
				// checks is writable or not
				System.out.println(CommonConstant.WRITABLE + objResultSetMetaData.isWritable(i));
				System.out.println("");
				System.out.println("---------------------------------------");
			}

		} finally {
			if (objstatement != null)
				objstatement.close();
			if (connection != null)
				connection.close();

		}

	}

}
