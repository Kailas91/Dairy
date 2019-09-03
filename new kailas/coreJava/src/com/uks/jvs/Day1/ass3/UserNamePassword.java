package com.uks.jvs.Day1.ass3;
/**
 * Date:18/06/2019
 * Assignment: Day 1
 * Task: to  validate username and password
 * @author Kailas
 *
 */
public class UserNamePassword {
	public void validate(String userName, String password) {// this method contain two string  values username and password getting from class TestCommandline.java
		String Usercode = "k";
		String Password = "1234";
		if (Usercode.equals(userName) && password.equals(Password)) {// check username and password are valid or not
			System.out.println("username and password is Valid");
		} else {
			System.out.println("User Name password Invalid");
		}
	}
}
