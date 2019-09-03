package com.uks.jvs.common;

import java.util.Scanner;

public class CommonClass {
	static Scanner objScanner = null;

	public static String takeNameInput() {
		System.out.println(Constant.EMPLOYEE_DETAILS_ENTER_MSG
				+ Constant.EMP_NAME_MSG);
		objScanner = new Scanner(System.in);
		String name = objScanner.next();
		return name;
	}

	public static int takeSalaryInput() {
		System.out.println(Constant.EMP_SAL_MSG);
		objScanner = new Scanner(System.in);
		int salary = objScanner.nextInt();
		return salary;
	}
}
