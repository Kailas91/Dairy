package com.uks.kailas.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This Class is used to Connect and dissconnect with the database
 *
 * @author kailas
 *
 */
public class DatabaseLogic {

	/**
	 * It is used to load driver and connect to database and insert data in the
	 * database
	 *
	 * @throws ClassNotFoundException
	 *             - Thrown when an application tries to load in a class using
	 *             forName but no definition for the class with the specified
	 *             name could be found.
	 * @throws SQLException
	 *             - Thrown when there is database access error or other errors.
	 * @throws IOException
	 *             - Thrown when there is some error in inputted data
	 * @throws Exception
	 *             - Thrown to handle all general exception conditions
	 * @return Connection
	 */
	public Connection connect() throws ClassNotFoundException, SQLException,
			IOException, Exception {
		Connection connection = null;
		PropertyUtil objPropertyUtil = null;
		try {// intialize the PropertyUtil object with the filepath from where
				// the database details need to be fetched
			objPropertyUtil = new PropertyUtil(Constants.MYSQLPROPERTIESPATH);
			// load the driver
			Class.forName(objPropertyUtil.getProperty(Constants.DRIVER));
			// get connection by passing path,username and password
			connection = DriverManager.getConnection(
					objPropertyUtil.getProperty(Constants.PATH),

					objPropertyUtil.getProperty(Constants.MySQLUSERNAME),
					objPropertyUtil.getProperty(Constants.MYSQLPASSWORD));
		} finally {
			objPropertyUtil = null;
		}// return the connection object to the calling function
		return connection;
	}

	/**
	 * It is used to disconnect from database
	 *
	 * @param connection
	 *            - hold the connection object of the connection that needs to
	 *            be disconnected
	 * @throws SQLException
	 *             - Thrown when there is database access error or other errors.
	 * @throws Exception
	 *             - Thrown to handle all general exception conditions
	 * @return void
	 */
	public void disconnect(Connection connection) throws SQLException,
			Exception {
		try {// if connection is not null then close it
			if (connection != null) {
				connection.close();
			}
		} finally {
			connection = null;
		}
	}
}
