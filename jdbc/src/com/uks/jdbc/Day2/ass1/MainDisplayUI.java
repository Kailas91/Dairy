package com.uks.jdbc.Day2.ass1;

/**
 * this is main class
 *
 * @author Kailas
 * Date : 23/7/2019
 */
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import Common.CommonConstant;
import Common.PropertyUtil;
public class MainDisplayUI {

	/**
	 * this method is used to intialize and call all te various methods to
	 * --perform the given task
	 *
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws IOException
	 */
	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException {
		Connection objconnection = null;
		PropertyUtil objPropertyUtil = null;
		RowsFetcher objRowsFetcher = null;
		DisplayUI objDisplayUI = null;
		Scanner scanner = null;
		int pageno = 0;


		try {
			objPropertyUtil = new PropertyUtil();
			objRowsFetcher = new RowsFetcher();
			objDisplayUI = new DisplayUI();
			objPropertyUtil.readProperty();
			objconnection = objPropertyUtil.connectToDatabse();

			scanner = new Scanner(System.in);
			System.out.println(CommonConstant.PAGENO);
			int input = scanner.nextInt();
			switch (input) {
			case 1:
				do {
				System.out.println(CommonConstant.ENETRPAGE);
				pageno=scanner.nextInt();
				objDisplayUI.dispalysRecords(objconnection,pageno);
				}while(true);
			case 2:
				// It is used to get connection object
				// "execute query" method is called to execute query
				ResultSet rs = objRowsFetcher.executequery(objconnection, 7);
				// it is called to set the result set
				objDisplayUI.pass(objRowsFetcher, rs);
				// "displayRowsPerPage" this method is called to display result
				objDisplayUI.displayRowsPerPage("N");
				// "disconnect" method is called to disconnect connection
				objPropertyUtil.disconnect();

				break;
				default :System.out.println(CommonConstant.INVALIDCHOICE);
			}

		} catch (ClassNotFoundException e) {
			System.out.println(CommonConstant.ClassNotFoundException);
		} catch (SQLException e) {
			System.out.println(CommonConstant.SQLException);
		} catch (Exception e) {

			System.out.println(CommonConstant.Exception);

		} finally {
			objconnection.close();
			objconnection = null;

			objRowsFetcher = null;
			objPropertyUtil = null;
			objDisplayUI = null;

		}
	}

}
