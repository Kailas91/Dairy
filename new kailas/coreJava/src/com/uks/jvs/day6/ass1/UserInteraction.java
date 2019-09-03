package com.uks.jvs.day6.ass1;

/**
 * Date:25/06/2019
 * Assignment: Day 6
 * Task: UserInteraction program
 *
 * @author Kailas
 */
import java.io.IOException;
import java.text.ParseException;

import java.util.ArrayList;

import java.util.Scanner;

import com.uks.jvs.day3.ass3.DateAndTime;
import com.uks.jvs.day3.ass4.DateDifference;
import com.uks.jvs.Day1.ass4.MultiCommandline;
import com.uks.jvs.day2.ass3.StringOperation;
import com.uks.jvs.day2.ass4.StringOperationTwo;
import com.uks.jvs.day3.ass5.DateAdd;
import com.uks.jvs.day3.ass8.ClassDetail;
import com.uks.jvs.day4.ass5.FrequencyChecker;
import com.uks.jvs.day5.ass3.EmployeeSearch;
import com.uks.jvs.day5.ass4.EmployeeSortedList;
import com.uks.jvs.day5.ass4.GeneralEmployee;
import com.uks.jvs.day5.ass4.RowReader;

public class UserInteraction {
	/**
	 * This is main method
	 *
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws ParseException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ClassNotFoundException,
			NoSuchFieldException, SecurityException, ParseException,
			IOException {
		UserInteraction uservalue = new UserInteraction();
		uservalue.printmessage();

	}

	/**
	 * This is switch statement which accept user program
	 *
	 * @param inputvalue
	 * @throws ParseException
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IOException
	 */
	public void selectProgram(String inputvalue) throws ParseException,
			ClassNotFoundException, NoSuchFieldException, SecurityException,
			IOException {
		switch (inputvalue.charAt(0)) {

		case 'a':
		case 'A':
			Multicommand(inputvalue);
			break;
		case 'b':
		case 'B':
			StringManipulation(inputvalue);
			break;
		case 'c':
		case 'C':
			StringOperation(inputvalue);
			break;
		case 'd':
		case 'D':
			dateFormate(inputvalue);
			break;

		case 'e':
		case 'E':
			DateDiffernce(inputvalue);
			break;
		case 'f':
		case 'F':
			try {
				AddDate(inputvalue);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 'g':
		case 'G':
			frequency(inputvalue);
			break;
		case 'h':
		case 'H':
			EmployeeSearch(inputvalue);
			break;
		case 'i':
		case 'I':
			classInfo(inputvalue);
			break;
		case 'j':
		case 'J':
			EmployeeSorting(inputvalue);
			break;
		default:
			System.out.println("Invalid input");

		}
		Scanner s = new Scanner(System.in);
		System.out.println("Invalid input");
		System.out.println("do u want do more operations Y/N");
		String choice = s.next();
		if (choice.equalsIgnoreCase("y"))
			printmessage();
		else
			System.out.println("exit");
		s.close();
	}

	/**
	 * This method will call multiCommandline program
	 *
	 * @param inputvalue
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws ParseException
	 * @throws IOException
	 */

	private void Multicommand(String inputvalue) throws ClassNotFoundException,
			NoSuchFieldException, SecurityException, ParseException,
			IOException {

		System.out.println("Enter your choice: \n 1. Add Numbers \n 2. Change String to lower case");
		Scanner s = new Scanner(System.in);
		inputvalue = s.nextLine();
		MultiCommandline MC = new MultiCommandline();

		if (inputvalue.equals("1")) {
			System.out.println("Enter the number to you want to add:");
			System.out
					.println("Enter first argument must be 1 then enter numbers which you want to add");
			String sentence = s.nextLine();
			// split over space. Now we have array of words
			String[] words = sentence.split(" ");
			MC.doOperation(words);
			System.out.println("do u want do more operations Y/N");
			String choice = s.next();
			if (choice.equalsIgnoreCase("y"))
				printmessage();
			else
				System.out.println("exit");
			System.out.println("");

		} else if (inputvalue.equals("2")) {
			System.out.println("Enter first argument must be 2 then enter the sentence");
			// input the sentence from the user
			String sentence = s.nextLine();
			// split over space. Now we have array of words
			String[] words = sentence.split(" ");

			MC.doOperation(words);
			System.out.println("do u want do more operations Y/N");
			String choice = s.next();
			if (choice.equalsIgnoreCase("y"))
				printmessage();
			else
				System.out.println("exit");
			System.out.println("");
			s.close();
		} else
			System.out.println("Invalid input");
		System.out.println("do u want do more operations Y/N");
		String choice = s.next();
		if (choice.equalsIgnoreCase("y"))
			printmessage();
		else
			System.out.println("exit");
		System.out.println("");
	}

	/**
	 * This method accept input and perform string manipulation
	 *
	 * @param inputvalue
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws ParseException
	 * @throws IOException
	 */
	private void StringManipulation(String inputvalue)
			throws ClassNotFoundException, NoSuchFieldException,
			SecurityException, ParseException, IOException {

		Scanner s = new Scanner(System.in);
		System.out.println("enter your choice 1 or 2");
		System.out.println("1:Enter the string to reverse");
		System.out
				.println("2:enter the string to count the number of uppercase , lower case letter");
		inputvalue = s.nextLine();
		StringOperation SM = new StringOperation();

		if (inputvalue.equals("1")) {
			System.out
					.println("Enter the string to reverse and 1st argument must be 1: ");

			String[] numberval = new String[2];

			for (int i = 0; i < numberval.length; i++)
				numberval[i] = s.next();
			SM.doOperationWithRegEx(numberval);

		} else if (inputvalue.equals("2")) {
			System.out
					.println("Enter the string to count the number of uppercase , lower case letter and 1st argument must be 2: ");
			String[] numberval = new String[2];

			for (int i = 0; i < numberval.length; i++)
				numberval[i] = s.next();
			SM.doOperationWithRegEx(numberval);
			System.out.println("do u want do more operations Y/N");
			String choice = s.next();
			if (choice.equalsIgnoreCase("y"))
				printmessage();
			else
				System.out.println("exit");
			System.out.println("");
			s.close();
		}
		System.out.println("Invalid input");
		System.out.println("do u want do more operations Y/N");
		String choice = s.next();
		if (choice.equalsIgnoreCase("y"))
			printmessage();
		else
			System.out.println("exit");
	}

	/**
	 * This method accept input and perform string manipulation
	 *
	 * @param inputvalue
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws ParseException
	 * @throws IOException
	 */
	private void StringOperation(String inputvalue)
			throws ClassNotFoundException, NoSuchFieldException,
			SecurityException, ParseException, IOException {

		Scanner s = new Scanner(System.in);
		System.out.println("enter the choice 1 or 2");
		System.out.println("1:Enter the string to reverse");
		System.out
				.println("2:enter the string to count the number of uppercase , lower case letter");
		// System.out.println("enter the choice 1 or 2");
		inputvalue = s.nextLine();
		StringOperationTwo SO = new StringOperationTwo();

		if (inputvalue.equals("1")) {
			System.out
					.println("Enter the string to reverse and 1st argument must be 1:");
			String[] numberval = new String[2];

			for (int i = 0; i < numberval.length; i++)
				numberval[i] = s.next();
			SO.doOperationwithoutregex(numberval);

		} else if (inputvalue.equals("2")) {
			System.out
					.println("enter the string to count the number of uppercase , lower case letter and 1st argument must be 2::");
			String[] numberval = new String[2];

			for (int i = 0; i < numberval.length; i++)
				numberval[i] = s.next();
			SO.doOperationwithoutregex(numberval);
			System.out.println("do u want do more operations Y/N");
			String choice = s.next();
			if (choice.equalsIgnoreCase("y"))
				printmessage();
			else
				System.out.println("exit");
			System.out.println("");
			s.close();
		}
		System.out.println("Invalid input");
		System.out.println("do u want do more operations Y/N");
		String choice = s.next();
		if (choice.equalsIgnoreCase("y"))
			printmessage();
		else
			System.out.println("exit");
	}




	/**
	 * This method is used to get date format you like
	 *
	 * @param inputvalue
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws ParseException
	 * @throws IOException
	 */

	public void dateFormate(String inputvalue)throws ClassNotFoundException,
	NoSuchFieldException, SecurityException, ParseException,
	IOException{

		System.out.println("enter 1. to print Todays Date in your Faormat  : \n 2. for printing your date ");
		Scanner s = new Scanner(System.in);
		inputvalue = s.nextLine();
		if ("1".equals(inputvalue)) {
			System.out.println("Enter the date format you like:");

			String dateFormat = s.next();
			DateAndTime dateAndTime = new DateAndTime();
			dateAndTime.todaysDate(dateFormat);
		}
		else if("2".equals(inputvalue)){
			System.out.println("Enter the date format format of inputted date is yyyy/MM/dd :");
			String dateFormat = s.next();
			System.out.println("Enter your date");
			String date = s.next();
			DateAndTime dateAndTime = new DateAndTime();
			dateAndTime.dateFormater(dateFormat,date);
			System.out.println("do u want do more operations Y/N");
			String choice = s.next();
			if (choice.equalsIgnoreCase("y"))
				printmessage();
			else
				System.out.println("exit");
			System.out.println("");
			s.close();
		}
		System.out.println("Invalid input");
		System.out.println("do u want do more operations Y/N");
		String choice = s.next();
		if (choice.equalsIgnoreCase("y"))
			printmessage();
		else
			System.out.println("exit");
	}




	/**
	 * This method is used to get date difference
	 *
	 * @param inputvalue
	 * @throws ParseException
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IOException
	 */
	private void DateDiffernce(String inputvalue) throws ParseException,
			ClassNotFoundException, NoSuchFieldException, SecurityException,
			IOException {

		Scanner s = new Scanner(System.in);
		System.out.println("enter 1 to find difference btw two dates 1:");
		inputvalue = s.nextLine();

		if (inputvalue.equals("1")) {
			System.out.println("enter 1st Date Should be in these form dd/mm/yyyy");
			String inputdate = s.next();

			System.out.println("enter 2st Date Should be in these form dd/mm/yyyy");
			String inputdate2 = s.next();

			DateDifference.getDate(inputdate, inputdate2);
			System.out.println("do u want do more operations Y/N");
			String choice = s.next();
			if (choice.equalsIgnoreCase("y"))
				printmessage();
			else
				System.out.println("exit");
			System.out.println("");
			s.close();
		}
		System.out.println("Invalid input");
		System.out.println("do u want do more operations Y/N");
		String choice = s.next();
		if (choice.equalsIgnoreCase("y"))
			printmessage();
		else
			System.out.println("exit");
	}


	/**
	 * This method accept input dates and add month ,day or year to that date
	 *
	 * @param inputvalue
	 * @throws Exception
	 */
	private void AddDate(String inputvalue) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("Press 1 to add:" + inputvalue);

		String inputval = s.next();

		if ("1".equals(inputval)) {
			System.out.println("enter date in yyyy/mm/dd");
			String date = s.next();
			System.out.println("Enter Add Type like year , month , date");
			String addtype = s.next();
			System.out.println("no days to add");
			int number = s.nextInt();
			DateAdd objDateAdd = new DateAdd();
			objDateAdd.addDate(date, addtype, number);
			System.out.println();
			System.out.println("do u want do more operations Y/N");
			String choice = s.next();
			if (choice.equalsIgnoreCase("y"))
				printmessage();
			else
				System.out.println("exit");
			System.out.println("");
			s.close();

		}
		System.out.println("Invalid input");
		System.out.println("do u want do more operations Y/N");
		String choice = s.next();
		if (choice.equalsIgnoreCase("y"))
			printmessage();
		else
			System.out.println("exit");

	}

	/**
	 * this method is used to get class information
	 *
	 * @param inputscan
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws ParseException
	 * @throws IOException
	 */

	private void classInfo(String inputscan) throws
			NoSuchFieldException, SecurityException,
			IOException, ClassNotFoundException, ParseException {

		Scanner s = new Scanner(System.in);
		System.out.println("enter class name");
		String className = s.next();
		ClassDetail objClassDetails = new ClassDetail();
		//Class className = Class.forName(Name.toString());
		System.out.println("Enter 1. to display all details of class \n 2.display all Constructor \n 3.display all methods in class \n 4. display fields in class");
		String inputval= s.next();
		if("1".equals(inputval)){
			System.out.println("all class details");
			objClassDetails.showAllClassDetails(className);
		}
		else if("2".equals(inputval))
		{
			System.out.println("all constructor details in class");
			objClassDetails.showAllConstructors(className);
		}
		else if("3".equals(inputval))
		{
			System.out.println("all  methods in class");
			objClassDetails.showOnlyMethods(className);
		}
		else if("4".equals(inputval))
		{
			System.out.println("all fields in class");
			objClassDetails.showOnlyFields(className);
		}
		System.out.println("do u want do more operations Y/N");
		String choice = s.next();
		if (choice.equalsIgnoreCase("y"))
			printmessage();
		else
			System.out.println("exit");
		System.out.println("");
		s.close();
	}

	/**
	 * This method is used to find frequency of string
	 *
	 * @param inputvalue
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws ParseException
	 * @throws IOException
	 */
	private void frequency(String inputscan) throws ClassNotFoundException,
			NoSuchFieldException, SecurityException, ParseException,
			IOException {
		FrequencyChecker objFrequencyChecker = new FrequencyChecker();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the sentence");
		// input the sentence from the user
		String sentence = scanner.nextLine();
		// split over space. Now we have array of words
		String[] words = sentence.split(" ");
		System.out.println("counting words using hashamp ");
		objFrequencyChecker.occurenceCheck(words);

		System.out.println("counting words using treeamp ");
	     objFrequencyChecker = new FrequencyChecker();
		objFrequencyChecker.countFrequencies(words);

		System.out.println("do u want do more operations Y/N");
		String choice = scanner.nextLine();
		if (choice.equalsIgnoreCase("y"))
			printmessage();
		else
			System.out.println("exit");
		System.out.println("");
		scanner.close();
	}

	/**
	 * This method is used to get employee details on first name or last name
	 *
	 * @param inputvalue
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws ParseException
	 */
	private void EmployeeSearch(String inputvalue) throws IOException,
			ClassNotFoundException, NoSuchFieldException, SecurityException,
			ParseException {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter first name / lastname of employee  to print employees details");
		inputvalue = s.next();
		EmployeeSearch employeeSearch = new EmployeeSearch();
		employeeSearch.setFilePath("C:/Users/Kailas/Desktop/Employees.txt");
		// type first name as well as last name to display record
		employeeSearch.searchEmployee(inputvalue);
		// s.close();
		System.out.println("do u want do more operations Y/N");
		String choice = s.next();
		if (choice.equalsIgnoreCase("y"))
			printmessage();
		else
			System.out.println("exit");
		System.out.println("");
		s.close();
	}

	/**
	 * This method is used to get sorting field from employee table
	 *
	 * @param inputvalue
	 * @throws IOException
	 * @throws ParseException
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 * @throws ClassNotFoundException
	 */
	private void EmployeeSorting(String inputvalue) throws IOException,
			ClassNotFoundException, NoSuchFieldException, SecurityException,
			ParseException {
		Scanner s = new Scanner(System.in);
		EmployeeSortedList empSortedList = new EmployeeSortedList();
		// new EmployeeSortedList().sortByColumn("lastName");
		ArrayList<GeneralEmployee> emps = new RowReader().readFile("C:/Users/Kailas/Desktop/Employees.txt");
		System.out.println("Enetr Coloum name which you want to sort like firstName ,lastName ,empType , salary");
		String colName = s.next();
		switch (colName) {
		case "firstName":
			empSortedList.sortByFirstName(emps);
			break;
		case "lastName":
			empSortedList.sortByLastName(emps);
			break;
		case "empType":
			empSortedList.sortByEmpType(emps);
			break;
		case "salary":
			empSortedList.sortBySalary(emps);
			break;
		default:
			empSortedList.sortByEmpCode(emps);
			break;
		}
		System.out.println("do u want do more operations Y/N");
		String choice = s.next();
		if (choice.equalsIgnoreCase("y"))
			printmessage();
		else
			System.out.println("exit");
		System.out.println("");
		 s.close();
	}

	/**
	 * This is main method which shows user information
	 *
	 * @throws ClassNotFoundException
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws ParseException
	 * @throws IOException
	 */

	void printmessage() throws ClassNotFoundException, NoSuchFieldException,
			SecurityException, ParseException, IOException {

		System.out.println("Enter A for Multicommand :      ");
		System.out.println("Enter B for String manipulation:");
		System.out.println("Enter C for String opertion:");
		System.out.println("Enter d for Date Fornat :");
		System.out.println("Enter E for Datediffernce:");
		System.out.println("enter F for adddate:");
		System.out.println("Enter G for frequnecy:");
		System.out.println("Enter H for Employee Search");
		System.out.println("Enter I for classInfo:");
		System.out.println("Enter J for Employee sorting");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter input from [A-J] :");
		String inputvalue = sc.next();

		selectProgram(inputvalue);
		sc.close();

	}

}
