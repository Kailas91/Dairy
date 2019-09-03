package com.uks.jvs.day3.ass5;

/**
 * Date:20/06/2019 Assignment: Day 3 Task: Add the given number to the specified
 * date and show the result
 *
 * @author Kailas
 */
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateAdd {

	/**
	 * method addDate which is used to calculate and return new date from added
	 * year or months or days
	 *
	 * @String
	 * @String
	 * @Integer return type : void
	 */
	public void addDate(String inputDate, String addType, int number) throws Exception {
		//int addNumber =Integer.parseInt(number);
		DateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = simpleDateFormat.parse(inputDate);
		switch (addType) {
		case "year":
			addYear(date, number);
			break;
		case "month":
			addMonth(date, number);
			break;
		case "date":
			addDay(date, number);
			break;
		}
	}

	/**
	 * method addDay adds days to the given input date and prints output date
	 *
	 * @Date
	 * @int return type : void
	 */
	public static void addDay(Date date, int i) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, i);
		System.out.println("New Date " + cal.getTime());
	}

	/**
	 * method addMonth adds months to the given input date and prints output
	 * date
	 *
	 * @Date
	 * @int return type : void
	 */
	public static void addMonth(Date date, int i) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, i);
		System.out.println("New Date " + cal.getTime());
	}

	/**
	 * method addYear adds years to the given input date and prints output date
	 *
	 * @Date
	 * @int return type : void
	 */

	public static void addYear(Date date, int i) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, i);
		System.out.println("New Date " + cal.getTime());
	}
}
