package com.uks.jdbc.Day1.ass3;
import java.sql.Connection;
import Common.PropertyUtil;
/**
 * @description : main class to call the RecordDisplay class
 * @author Kailas
 * Date : 2019/7/22
 *
 ***/
public class MainRecordDisplay {


	public static void main(String[] args) {
		Connection objconnection = null;
		PropertyUtil objPropertyUtil = null;
		DisplayRecords objRecordDisplay = null;
		try {
			objRecordDisplay = new DisplayRecords();
			objPropertyUtil = new PropertyUtil();
			// call connect() from CommonDBLogic class using objCommonDBLogic
			// object and store to connection variable
			objPropertyUtil.readProperty();
			objconnection = objPropertyUtil.connectToDatabse();
			// create objRecordDisplay object to call
			// connects(),dispalysRecords(),disconnect() methods
			objRecordDisplay.dispalysRecords(objconnection);
			objPropertyUtil.disconnect();
		} catch (Exception e) {
			System.out.println("Please Check Database Path in  CommonConstant file ");
			 objconnection = null;
			 objPropertyUtil = null;
			 objRecordDisplay = null;
		}
	}
}
