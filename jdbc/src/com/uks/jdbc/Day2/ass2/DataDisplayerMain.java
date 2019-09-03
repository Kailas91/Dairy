package com.uks.jdbc.Day2.ass2;

/**
 * this class is a main class
 *
 * @author Kailas
 * @date 24/7/2019
 */
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import Common.CommonConstant;
import Common.PropertyUtil;

public class DataDisplayerMain {

	static ArrayList<SalesByCatData> list = new ArrayList<SalesByCatData>();

	@SuppressWarnings({ "static-access" })
	public static void main(String args[]) {
		DataDisplayer objDataDisplayer = null;
		Connection connection = null;
		SalesByCategoryRunner objSalesByCategoryRunner = null;
		String categoryName = null;
		PropertyUtil objPropertyUtil = null;
		Scanner scanner = null;
		int pageno = 0;

		try {
			objPropertyUtil = new PropertyUtil();
			objDataDisplayer = new DataDisplayer();
			// to take data from user it is used

			// to connect and take object of connection
			objPropertyUtil.readProperty();
			connection = objPropertyUtil.connectToDatabse();
			// object of SalesByCategoryRunner is created by passing connection
			objSalesByCategoryRunner = new SalesByCategoryRunner(connection);

			scanner = new Scanner(System.in);
			System.out.println(CommonConstant.PAGENO);
			int input = scanner.nextInt();
			switch (input) {
			case 1:
				do {
					System.out.println(CommonConstant.SELECTCATE);
					System.out.println(CommonConstant.SEAFOOD);
					System.out.println(CommonConstant.PRODUCE);
					System.out.print(CommonConstant.CHOICE);
					int choice = scanner.nextInt();
					if(choice==1){
						categoryName="Seafood";
					}else if(choice==2){
						categoryName="Produce";
					}
					System.out.println(CommonConstant.ENETRPAGE);
					pageno = scanner.nextInt();
					objSalesByCategoryRunner.dispalysRecords(connection,pageno,categoryName,"1996");

				} while (true);
			case 2:

				categoryName = objDataDisplayer.getDataFromUser();
				// categoryName is passed and data is returned using list
				list = objSalesByCategoryRunner.fetchRecords(categoryName, "1996");
				// print list method is called to print list
				objDataDisplayer.printlist(list);
				// displayRowsPerPage method is called to display result
				DataDisplayer.displayRowsPerPage(objSalesByCategoryRunner);
				objPropertyUtil.disconnect();
				break;
			default:
				System.out.println(CommonConstant.INVALIDCHOICE);
			}
		} catch (Exception e) {

		} finally {
			objDataDisplayer = null;
			objSalesByCategoryRunner = null;
			connection = null;
			categoryName = null;
			objPropertyUtil = null;
		}
	}
}
