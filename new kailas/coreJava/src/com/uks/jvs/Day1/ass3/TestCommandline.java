package com.uks.jvs.Day1.ass3;
/**
 * Date:18/06/2019
 * Assignment: Day 1
 * Task: Testing Command line Argument in java
 * @author Kailas
 *
 */
public class TestCommandline {
	public static void main(String args[]) {	// it contain main ,method
		UserNamePassword userNamePassword = new UserNamePassword();// create UserNamePassword class object to call validate method and compare argument value
		try {// to display exception when user enter wrong arguments
			userNamePassword.validate(args[0], args[1]);
		} catch (Exception exception) { // any exception occurred then print that exception
			System.out.println("Please enter arguments"+exception);
		} finally {
			userNamePassword = null;// Null memory occupied by the object
		}
	}
}
