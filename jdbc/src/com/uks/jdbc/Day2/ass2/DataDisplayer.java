package com.uks.jdbc.Day2.ass2;


import java.sql.SQLException;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

import Common.CommonConstant;

/**
 * this class is used to to print the result
 *
 * @author Kailas
 * @date 24/7/2019
 */
public class DataDisplayer {

	static ArrayList<SalesByCatData> list = new ArrayList<SalesByCatData>();
	/**
	 * This method is used to take data from user
	 *
	 * @param null
	 * @return
	 */
	@SuppressWarnings("resource")
	public String getDataFromUser() {
		Scanner objscanner = null;
		String catagaryName = null;
		try {

			objscanner = new Scanner(System.in);

			System.out.println(CommonConstant.SELECTCATE);
			System.out.println(CommonConstant.SEAFOOD);
			System.out.println(CommonConstant.PRODUCE);
			System.out.print(CommonConstant.CHOICE);
			catagaryName = objscanner.next();

			if ("1".equalsIgnoreCase(catagaryName)) {
				catagaryName = "Seafood";
				return catagaryName;
			}
			if ("2".equalsIgnoreCase(catagaryName)) {
				catagaryName = "Produce";
				return catagaryName;

			} else {
				System.out.println(CommonConstant.INVALIDCHOICE);
				getDataFromUser();
			}

		} finally {
			objscanner = null;
			catagaryName = null;

		}
		return catagaryName;
	}


	/**
	 * This method is used to print ArrayList
	 *
	 * @param list
	 */
	public static void printlist(ArrayList<SalesByCatData> list) {
		ListIterator<SalesByCatData> litr = null;
		SalesByCatData objEmpData = null;

		try {
			litr = list.listIterator();

			System.out.println("\n");
			System.out
					.printf(CommonConstant.HEADERF,"Product Name","TotalPrise");
			System.out.println("------------------------------------------------------");

			while (litr.hasNext()) {
				objEmpData = litr.next();
				System.out.format(CommonConstant.HEADERFO,objEmpData.ProductName,objEmpData.TotalPurchase);
				litr.remove();
			}
			System.out.println("------------------------------------------------------");

		} finally {
			litr = null;
			objEmpData = null;
		}
	}
	/**
	 * this method is used to display the results when entering page number
	 *
	 * @param list
	 * @return null
	 */


	/**
	 * this class used to print list contains rows This class fetch rows and
	 * print it
	 *
	 * @param objSalesByCategoryRunner
	 * @throws SQLException
	 */
	public static void displayRowsPerPage(
			SalesByCategoryRunner objSalesByCategoryRunner) throws SQLException {
		@SuppressWarnings("resource")
		Scanner objscanner = new Scanner(System.in);
		String choice = null;
		try {
			System.out.println("Enter your choise");
			System.out.println(" N :For Next");

			System.out.println(" X :For Exit");
			System.out.print("Enter your choice :");

			choice = objscanner.next();

			if ("N".equalsIgnoreCase(choice)) {
				list = objSalesByCategoryRunner.nextPage();
				printlist(list);
				displayRowsPerPageone(objSalesByCategoryRunner);
			}

			if ("X".equalsIgnoreCase(choice)) {
				System.exit(0);
			} else {
				System.out.println("wrong choise");
				displayRowsPerPage(objSalesByCategoryRunner);
			}
		} finally {
			objscanner = null;
			choice = null;
		}
	}

	/**
	 *
	 * @param objSalesByCategoryRunner
	 * @throws SQLException
	 */
	public static void displayRowsPerPageone(
			SalesByCategoryRunner objSalesByCategoryRunner) throws SQLException {
		@SuppressWarnings("resource")
		Scanner objscanner = new Scanner(System.in);
		System.out.println(" P :For Previous");
		System.out.println(" X :For Exit");
		System.out.print("Enter your choice :");
		String choice = null;
		choice = objscanner.next();

		if ("P".equalsIgnoreCase(choice)) {
			list = objSalesByCategoryRunner.previouspage();
			printlist(list);
			displayRowsPerPage(objSalesByCategoryRunner);

		}
		if ("X".equalsIgnoreCase(choice)) {
			System.exit(0);
		} else {
			System.out.println("wrong choise");
			displayRowsPerPage(objSalesByCategoryRunner);
		}
	}
}
