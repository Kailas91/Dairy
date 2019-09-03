package com.uks.jvs.day6.ass4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Date:25/06/2019
 * Assignment: Day 6
 * Task: Locale and ResourceBundle class
 *
 * @author Kailas
 */
public class TestCompanyInfo {

	public static void main(String[] args) {
		System.out.println("Enter 1 to English");
		System.out.println("Enter 2 to japanese");
		Scanner scanner = new Scanner(System.in);
		CompanyInfo objComanyInfo = new CompanyInfo();
		try{
			int option =scanner.nextInt();
		objComanyInfo.getOption(option);
		}
		catch(InputMismatchException e){
			System.out.println("please Enter number 1 or 2");
		}
		finally{
			scanner.close();
		}

	}

}
