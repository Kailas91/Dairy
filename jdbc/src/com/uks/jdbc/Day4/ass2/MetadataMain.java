package com.uks.jdbc.Day4.ass2;

import java.sql.Connection;
import Common.CommonConstant;
import Common.PropertyUtil;

/**
 * this class is used to call the various methods of Metadata class to perform
 * given task
 *
 * @author Kailas
 * @date 29/7/2019
 */
public class MetadataMain {

	public static void main(String args[]) {
		// create and initialize the object
		Metadata objMetadata = null;
		Connection objconnection = null;
		PropertyUtil objPropertyUtil = null;

		try {

			objMetadata = new Metadata();
			objPropertyUtil = new PropertyUtil();
			// call connect method to establish connection

			objPropertyUtil.readProperty();
			objconnection = objPropertyUtil.connectToDatabse();
			// get and print the meta data

			objMetadata.infometadata(objconnection);
		} catch (Exception exception) {

			System.out.println(CommonConstant.Exception);
		} finally {
			if (objMetadata != null)
				objconnection = null;
			objPropertyUtil = null;
			objMetadata = null;
		}
	}
}
