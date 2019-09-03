package com.uks.jvs.day4.ass1;

import java.util.Scanner;

/**
 * Date:21/06/2019
 * Assignment: Day 4
 * Task: Basics of Inheritance for Testing Employee class
 * @author Kailas
 */

public class TestEmployee {

	public static void main(String args[]){
		String firstName;
		String lastName;
		String empType;
		long empMobileNo;
		// get data from user input thats why used Scanner class
		Scanner objScanner = new Scanner(System.in);

		System.out.println("Enetr Employee first name lastname and employee type ");
		firstName = objScanner.next();
		lastName = objScanner.next();
		empType = objScanner.next();
		// create ProjectLeader object to pass employee value using parameterized constructor
		ProjectLeader objProjectLeader = new ProjectLeader(firstName,lastName,empType);

		System.out.println("Enetr Employee first name lastname and Mobile number for Project Leader ");
		firstName = objScanner.next();
		lastName = objScanner.next();
		empMobileNo = objScanner.nextLong();
		// this calling method will display project leader data
		objProjectLeader.showPLdata(firstName,lastName, empMobileNo);

		objScanner.close();
	}

}
