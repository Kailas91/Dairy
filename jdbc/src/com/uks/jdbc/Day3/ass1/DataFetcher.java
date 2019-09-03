package com.uks.jdbc.Day3.ass1;

/**
 * this class is used get data fro databse
 *
 * @author Kailas
 * @date 25/7/2019
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.sun.rowset.CachedRowSetImpl;
import com.sun.rowset.WebRowSetImpl;
import Common.PropertyUtil;
import Common.CommonConstant;;


public class DataFetcher {
	public Connection connection = null;
	public Statement objStatement = null;
	public ResultSet objResultSet = null;


	/**
	 * This method is used to connect to database
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public void connect() throws ClassNotFoundException, SQLException,
			IOException {
		PropertyUtil objPropertyUtil = new PropertyUtil();
		objPropertyUtil.readProperty();
		connection = objPropertyUtil.connectToDatabse();

	}

	/**
	 * this method returns CachedRowSet object
	 *
	 * @return
	 * @throws SQLException
	 */
	public CachedRowSetImpl executeInCached() throws SQLException {
		 CachedRowSetImpl objCacheRowSet = null;

		try {

			// Object of CacheRowSet is created
			objCacheRowSet = new CachedRowSetImpl();
			objStatement = connection.createStatement();
			objResultSet = objStatement.executeQuery(CommonConstant.DaythreeQueryOne);

			// populate function is used
			objCacheRowSet.populate(objResultSet);

			// connection is closed
			//connection.close();
			// finally objCacheRowSet is returned because objCacheRowSet has its
			// local memory so no need to connect to database
			return objCacheRowSet;
		} finally {
			if (connection != null) {
				connection.close();
			}
		}
	}

	/**
	 * this method returns WebRowSet object
	 *
	 * @return
	 * @throws SQLException
	 */
	public WebRowSetImpl executeInXML() throws SQLException {
		 WebRowSetImpl objWebRowSet = null;
		try {
			// object of WebRowSetImpl is created
			objWebRowSet = new WebRowSetImpl();
			objStatement = connection.createStatement();
			objResultSet = objStatement.executeQuery(CommonConstant.DaythreeQueryOne);
			// populate function is used

			objWebRowSet.populate(objResultSet);

			// finally objWebRowSet is returned

			return objWebRowSet;
		} finally {
			if (connection != null) {
				connection.close();
			}

		}

	}
}
