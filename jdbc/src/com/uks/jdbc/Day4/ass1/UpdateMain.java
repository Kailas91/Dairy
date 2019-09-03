package com.uks.jdbc.Day4.ass1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import Common.PropertyUtil;

/**
 * this class is a main class
 *
 *  @author Kailas
 * @date 29/7/2019
 **/
public class UpdateMain {
	/**
	 * this method is used to call various other methods to perform given task
	 **/

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {

		// initialize
		 ResultSetUpdateRow objresultSetUpdatetRow = null;
		Connection objconnection = null;
		PropertyUtil objPropertyUtil = null;
		try {


			 objPropertyUtil = new PropertyUtil();
			// call connect method to establish connection
			objPropertyUtil.readProperty();
			objconnection = objPropertyUtil.connectToDatabse();
			objresultSetUpdatetRow = new ResultSetUpdateRow();
			// call the insertRow() method from ResultSetInsertRow class
			objresultSetUpdatetRow.insertRow(objconnection);
			objPropertyUtil.disconnect();
		} catch (Exception e) {

		} finally {
			if (objresultSetUpdatetRow != null)
				 objconnection = null;
			objresultSetUpdatetRow = null;
			 objPropertyUtil = null;
		}
	}
}
