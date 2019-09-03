package com.uks.jvs.day6.ass4;
/**
 * Date:25/06/2019
 * Assignment: Day 6
 * Task: Locale and ResourceBundle class
 *
 * @author Kailas
 */

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

public class CompanyInfo {
	/**
	 * This method is used to get input from user and perform ResourceBundle
	 *
	 * @param args
	 * @throws UnsupportedEncodingException
	 */
	public void getOption(int option) {
		ResourceBundle bundleOne = null;
		try{
		if (option == 1) {
			bundleOne = ResourceBundle.getBundle("com.uks.jvs.Message_en", Locale.ENGLISH);
			for (String key : bundleOne.keySet()) {
				System.out.println(bundleOne.getString(key));
			}
		} else if (option == 2) {
			bundleOne = ResourceBundle.getBundle("com.uks.jvs.Message_jp", Locale.JAPANESE);
			for (String key : bundleOne.keySet()) {
				System.out.println(bundleOne.getString(key));
			}
		}
		}catch(Exception e){
			System.out.println("file  not found");
			//e.printStackTrace();
		}
		finally{
			bundleOne = null;
		}

	}

}
