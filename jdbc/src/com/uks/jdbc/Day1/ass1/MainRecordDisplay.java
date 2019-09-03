package com.uks.jdbc.Day1.ass1;

import java.sql.Connection;
import Common.CommonConstant;
import Common.CommonDBLogic;

/**
 * @description : main class to call the RecordDisplay class
 * @author Kailas Date : 2019/7/22
 *
 ***/
public class MainRecordDisplay {

	public static void main(String[] args) {

		Connection objconnection = null;
		CommonDBLogic objCommonDBLogic = null;
		RecordDisplay objRecordDisplay = null;

		try {

			objRecordDisplay = new RecordDisplay();

			objCommonDBLogic = new CommonDBLogic();
			// call connect() from CommonDBLogic class using objCommonDBLogic
			// object and store to connection variable

			objconnection = objCommonDBLogic.connect(CommonConstant.TYPE1_CLASSNAME, CommonConstant.DB_URL_TYPE1);
			// call dispalysRecords() method and pass connection object to that method
			objRecordDisplay.dispalysRecords(objconnection);

			// close connection
			objCommonDBLogic.disconnect();

		} catch (Exception e) {
			System.out.println("SQLException in connects");
		}
		finally{
			 objconnection = null;
			 objCommonDBLogic = null;
			 objRecordDisplay = null;
		}
	}
}
