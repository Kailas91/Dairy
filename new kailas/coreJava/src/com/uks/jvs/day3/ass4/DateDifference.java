package com.uks.jvs.day3.ass4;

/**
 * Date:20/06/2019
 * Assignment: Day 3
 * Task: Date Difference program for calculating difference
 *
 * @author Kailas
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateDifference {

	// it contain main method that will throws parse exception
	public static void main(String args[]) throws ParseException {

		String stringDate1 = args[0];
		String stringDate2 = args[1];
		getDate(stringDate1,stringDate2);


	}
	public static void getDate(String stringDate1,String stringDate2) throws ParseException{
		// SimpleDateFormat object will convert string date into given format
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = myFormat.parse(stringDate1); // parse string date into date
		Date date2 = myFormat.parse(stringDate2);
		long diff = date2.getTime() - date1.getTime(); // getTime function will
														// calculate date in
														// milliseconds

		// it will convert milliseconds into days using covert function
		System.out.println("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
	}

}
