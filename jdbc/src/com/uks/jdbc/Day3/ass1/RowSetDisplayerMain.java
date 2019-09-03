package com.uks.jdbc.Day3.ass1;

import java.util.Scanner;

import Common.CommonConstant;
import Common.PropertyUtil;

/**
 * this class is used to call various methods to perform the given task
 *
 * @author Kailas
 * @date 25/7/2019
 */
public class RowSetDisplayerMain {
	/**
	 * this method is used to call various methods to perform the given task
	 *
	 * @param args
	 * @return null
	 */
	public static void main(String args[]) {
		Scanner objScanner = null;
		String typeOfRowSet = null;
		RowSetDisplayer objRowSetDisplayer = null;
		PropertyUtil objPropertyUtil =null;

		try {
			objPropertyUtil =new PropertyUtil();
			objScanner = new Scanner(System.in);
			// object of RowSetDisplayer is created
			objRowSetDisplayer = new RowSetDisplayer();
			// Input is taken from user
			System.out.println(CommonConstant.ROWSETTYPE);
			System.out.println(CommonConstant.CACHE);
			System.out.println(CommonConstant.WEBROW);
			System.out.println(CommonConstant.EXIT);
			System.out.println(CommonConstant.CLOSE);
			System.out.print(CommonConstant.CHOICE);
			typeOfRowSet = objScanner.next();
			// input is checked
			if (typeOfRowSet.equalsIgnoreCase("1")
					|| typeOfRowSet.equalsIgnoreCase("2")) {
				// DisplayEmpData method is called
				objRowSetDisplayer.DisplayEmpData(typeOfRowSet);

			} else if (typeOfRowSet.equalsIgnoreCase("X")) {
				System.exit(0);
			}
			else if (typeOfRowSet.equalsIgnoreCase("C")) {
				objPropertyUtil.disconnect();
			}else {
				System.out.println(CommonConstant.INVALIDCHOICE);
				main(args);
			}

		} catch (Exception e) {
			System.out.println(CommonConstant.Exception);

		} finally {
			objScanner = null;
			if (typeOfRowSet != null)
				typeOfRowSet = null;
		}

	}

}
