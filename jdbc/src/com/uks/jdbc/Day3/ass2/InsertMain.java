package com.uks.jdbc.Day3.ass2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import Common.PropertyUtil;

/**
 * this class is a main class
 *
 *  @author Kailas
 * @date 26/7/2019
 **/
public class InsertMain {
	/**
	 * this method is used to call various other methods to perform given task
	 **/

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

		// initialize
		ResultSetInsertRow objresultSetInsertRow = null;
		Connection objconnection = null;
		PropertyUtil objPropertyUtil = null;
		try {


			 objPropertyUtil = new PropertyUtil();
			// call connect method to establish connection
			objPropertyUtil.readProperty();
			objconnection = objPropertyUtil.connectToDatabse();
			objresultSetInsertRow = new ResultSetInsertRow();
			// call the insertRow() method from ResultSetInsertRow class
			objresultSetInsertRow.insertRow(objconnection);
			objPropertyUtil.disconnect();
		} catch (Exception e) {

		} finally {
			if (objresultSetInsertRow != null)
				 objconnection = null;
				objresultSetInsertRow = null;
			 objPropertyUtil = null;
		}
	}
}
