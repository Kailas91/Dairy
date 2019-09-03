package com.uks.jvs.day9.ass1;

/**
 * Date:28/06/2019
 * Assignment: Day 9
 * Task: FinderProcess class
 *
 * @author Kailas
 */

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// this class uses two main process 1. login authentication 2. Display user details

public class FinderProcess extends Thread {

	LoaderProcess loaderProcess = new LoaderProcess();

	private static Map<String, HashMap<String, String>> info = new TreeMap<>();
	private static Map<String, HashMap<String, String>> loginInfo = new HashMap<>();

	// falseCount variable are used to authenticate user login only three times
	private static int falseCount = 1;

	private static Scanner scanner = null;

	// load the user details and login details to shared variable
	static {
		info = LoaderProcess.mergedInfo;
		loginInfo = LoaderProcess.userLoginInfo;
	}

	/**
	 * method to run the thread
	 */
	public void run() {
		try {
			displayInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

	/**
	 *
	 * @throws IOException
	 *             Displays all the information.
	 */

	public static void displayInfo() throws IOException {
		scanner = new Scanner(System.in);
		String uname = "";
		String pass = "";
		System.out.println("\nWel come User \n");
		System.out.println("\nfirstly login your account.\n");
		System.out.print("Enter your Username: ");
		uname = scanner.next();
		System.out.print("Enter your password for '" + uname + "' username  : ");
		pass = scanner.next();

		// call userAuthentication function to get user details into string
		// array
		String[] user = userAuthentication(uname, pass);

		if (user[0].equals("true")) {
			System.out.println("\nlogged in");
			System.out.println(
					"\n--------------------------------------------------------------------------------------------------------------------------------\n");
			System.out.printf("%20s %20s %20s %20s %20s %20s", "Name", "Address", "City", "Salary", "TelNumber",
					"UserRole");
			System.out.println();
			System.out.println(
					"\n--------------------------------------------------------------------------------------------------------------------------------\n");
			HashMap<String, String> data = info.get(user[1]);

			System.out.format("%20s %20s %20s %20s %20s %20s", data.get("Name"), data.get("Address"), data.get("City"),
					data.get("Salary"), data.get("TelNumber"), data.get("UserRole"));
			System.out.println();
			System.out.println(
					"\n--------------------------------------------------------------------------------------------------------------------------------\n");
			while (true) {

				// check user third element is which role
				if (user[2].equals("manager")) {
					showManagerlist("manager");

				} else if (user[2].equals("admin")) {
					showAdminMenu();

				} else if (user[2].equals("employee")) {

					System.out.println("To log out (Press O)");

					System.out.println("To Exit (Pres X)");

					String input = scanner.next();
					if (input.equalsIgnoreCase("O")) {

						System.out.println("\nLog Out\n");
						displayInfo();

					} else if (input.equalsIgnoreCase("X")) {
						System.out.println("\nExit..\n");
						System.exit(0);

					} else {
						System.out.println("Wrong input..");
					}
				}
			}

		} else {

			System.out.println("\nWrong user name or password!");

			if (falseCount == 3) {
				System.out.println(
						"The System gets closed because the data you have provided is not valid. Please re-confirm it .");
				System.exit(0);

			} else {
				falseCount++;
				displayInfo();

			}
		}
	}

	/**
	 *
	 * @param user
	 * @param pass
	 * @return
	 *
	 * 		Method to authenticate user with user name and password getting
	 *         from displayinfo method
	 */

	public static String[] userAuthentication(String user, String pass) {

		String[] result = new String[3];

		for (int i = 0; i < loginInfo.size(); i++) {
			HashMap<String, String> data = new HashMap<>();
			data = loginInfo.get(Integer.toString(i + 1));

			if (data.get("username").equals(user) && data.get("password").equals(pass)) {
				result[0] = "true";
				result[1] = data.get("id");
				result[2] = data.get("role");
				break;
			} else {
				result[0] = "false";
				result[1] = "none";
				result[2] = "none";
			}
		}
		return result;

	}

	// Method to search the user by his name and role

	public static void searchPerson(String name, String role) {
		// count variable used to check record is present or not
		int count = 0;
		System.out.println(
				"\n--------------------------------------------------------------------------------------------------------------------------------\n");
		System.out.printf("%20s %20s %20s %20s %20s %20s", "Name", "Address", "City", "Salary", "TelNumber",
				"UserRole");
		System.out.println();
		System.out.println(
				"\n--------------------------------------------------------------------------------------------------------------------------------\n");

		for (int i = 0; i < info.size(); i++) {
			HashMap<String, String> data = new HashMap<>();
			data = info.get(Integer.toString(i + 1));
			String[] temp = data.get("Name").split(" ");

			// check given name and role is match with user or not
			if ((temp[0].equalsIgnoreCase(name) && data.get("UserRole").equals(role))
					|| (data.get("Name").equalsIgnoreCase(name) && data.get("UserRole").equals(role))) {
				count++;

				System.out.format("%20s %20s %20s %20s %20s %20s", data.get("Name"), data.get("Address"),
						data.get("City"), data.get("Salary"), data.get("TelNumber"), data.get("UserRole"));
				System.out.println();
				System.out.println(
						"\n--------------------------------------------------------------------------------------------------------------------------------\n");

			} else {

			}
		}

		if (count == 0) {
			System.out.println("There is no record for :" + name + " , and role: " + role);
		}
	}

	/**
	 *
	 * @throws IOException
	 *             This method shows all the employees based on the provided
	 *             roles.
	 */

	public static void viewAlltabuler(String role) {
		if (role.equals("*")) {
			// show all
			System.out.println(
					"\n--------------------------------------------------------------------------------------------------------------------------------\n");
			System.out.printf("%20s %20s %20s %20s %20s %20s", "Name", "Address", "City", "Salary", "TelNumber",
					"UserRole");
			System.out.println();
			System.out.println(
					"\n--------------------------------------------------------------------------------------------------------------------------------\n");

			for (int i = 0; i < info.size(); i++) {
				HashMap<String, String> data = new HashMap<>();
				data = info.get(Integer.toString(i + 1));
				System.out.format("%20s %20s %20s %20s %20s %20s", data.get("Name"), data.get("Address"),
						data.get("City"), data.get("Salary"), data.get("TelNumber"), data.get("UserRole"));
				System.out.println();
				System.out.println(
						"\n--------------------------------------------------------------------------------------------------------------------------------\n");
			}
		} else {
			System.out.println(
					"\n--------------------------------------------------------------------------------------------------------------------------------\n");
			System.out.printf("%20s %20s %20s %20s %20s %20s", "Name", "Address", "City", "Salary", "TelNumber",
					"UserRole");
			System.out.println();
			System.out.println(
					"\n--------------------------------------------------------------------------------------------------------------------------------\n");

			for (int i = 0; i < info.size(); i++) {
				HashMap<String, String> data = new HashMap<>();
				data = info.get(Integer.toString(i + 1));
				if (data.get("UserRole").equals(role)) {
					System.out.format("%20s %20s %20s %20s %20s %20s", data.get("Name"), data.get("Address"),
							data.get("City"), data.get("Salary"), data.get("TelNumber"), data.get("UserRole"));
					System.out.println();
					System.out.println(
							"\n--------------------------------------------------------------------------------------------------------------------------------\n");

				}
			}
		}
	}

	/**
	 * All menus Methods below
	 *
	 * @throws IOException
	 */

	// this method only show for Manager role user
	public static void showManagerlist(String from) throws IOException {

		while (true) {
			if (from.equals("admin")) {
				System.out.println("Back (Press B)");
				System.out.println("Search Employee(Press S)");
				System.out.println("To log out (Press O)");
				System.out.println("To Exit (Pres X)");
				scanner = new Scanner(System.in);
				String temp = scanner.next();
				if (temp.equalsIgnoreCase("S")) {
					System.out.println("Enter name of the employee to search");
					String name = scanner.next();
					searchPerson(name, "employee");
					showManagerlist("admin");
				} else if (temp.equalsIgnoreCase("O")) {
					System.out.println("\nLog out...\n");
					displayInfo();
				} else if (temp.equalsIgnoreCase("X")) {
					System.out.println("\nExit\n");
					System.exit(0);
				} else if (temp.equalsIgnoreCase("B")) {
					if (from.equals("admin")) {
						showAdminMenu();

					}
				}
			} else if (from.equals("manager")) {
				System.out.println("Back (Press B)");
				System.out.println("Search Employee(Press S)");
				System.out.println("View All Employees(Press ALL)");
				System.out.println("To log out (Press O)");
				System.out.println("To Exit (Pres X)");
				scanner = new Scanner(System.in);
				String input = scanner.next();
				if (input.equalsIgnoreCase("S")) {
					System.out.println("Enter name of the employee to search");
					String name = scanner.next();
					searchPerson(name, "employee");
					showManagerlist("employee");
				} else if (input.equalsIgnoreCase("ALL")) {
					viewAlltabuler("employee");
					showManagerlist("employee");
				} else if (input.equalsIgnoreCase("O")) {
					System.out.println("\nLog out...\n");
					displayInfo();
				} else if (input.equalsIgnoreCase("X")) {
					System.out.println("\nExit\n");
					System.exit(0);
				} else if (input.equalsIgnoreCase("B")) {
					if (from.equals("admin")) {
						showManagerlist("manager");
					} else {
						showManagerlist(from);
					}
				} else {
					System.out.println("Wrong input");
					showManagerlist(from);
				}
			} else {
				System.out.println("Back (Press B)");
				System.out.println("Search Employee(Press S)");
				System.out.println("To log out (Press O)");
				System.out.println("To Exit (Pres X)");
				scanner = new Scanner(System.in);
				String input = scanner.next();
				if (input.equalsIgnoreCase("S")) {
					System.out.println("Enter name of the employee to search");
					String name = scanner.next();
					searchPerson(name, "employee");
					showManagerlist("employee");
				} else if (input.equalsIgnoreCase("O")) {
					System.out.println("\nLog out...\n");
					displayInfo();
				} else if (input.equalsIgnoreCase("X")) {
					System.out.println("\nExit\n");
					System.exit(0);
				} else if (input.equalsIgnoreCase("B")) {
					showManagerlist("manager");

				} else {
					System.out.println("Wrong input");
					showManagerlist("manager");
				}
			}

		}

	}

	public static void showManager(String from) throws IOException {

		while (true) {
			if (from.equals("admin")) {
				System.out.println("Back (Press B)");
			}
			System.out.println("Search Manager(Press S)");
			System.out.println("To log out (Press O)");
			System.out.println("To Exit (Pres X)");
			scanner = new Scanner(System.in);
			String input = scanner.next();
			if (input.equalsIgnoreCase("S")) {
				System.out.println("Enter name of the Manager to search");
				String name = scanner.next();
				searchPerson(name, "manager");
			} else if (input.equalsIgnoreCase("O")) {
				System.out.println("\nLog out...\n");
				displayInfo();
			} else if (input.equalsIgnoreCase("X")) {
				System.out.println("\nExit\n");
				System.exit(0);
			} else if (input.equalsIgnoreCase("B")) {
				if (from.equals("admin")) {
					showAdminMenu();
				} else {
					showManagerlist(from);
				}
			} else {
				System.out.println("Wrong input");
				showManagerlist(from);
			}

		}

	}

	public static void showAdmin(String from) throws IOException {

		while (true) {
			if (from.equals("admin")) {

			}
			System.out.println("Back (Press B)");
			System.out.println("Search admin (Press S)");
			System.out.println("To log out (Press O)");
			System.out.println("To Exit (Pres X)");
			scanner = new Scanner(System.in);
			String input = scanner.next();
			if (input.equalsIgnoreCase("S")) {
				System.out.println("Enter name of the admin to search");
				String name = scanner.next();
				searchPerson(name, "admin");
			} else if (input.equalsIgnoreCase("O")) {
				System.out.println("\nLog out...\n");
				displayInfo();
			} else if (input.equalsIgnoreCase("X")) {
				System.out.println("\nExit\n");
				System.exit(0);
			} else if (input.equalsIgnoreCase("B")) {
				if (from.equals("admin")) {
					showAdminMenu();
				} else {
					showManagerlist(from);
				}
			} else {
				System.out.println("Wrong input");
				showAdmin(from);
			}

		}

	}

	/**
	 *
	 * @throws IOException
	 *             This method shows the menu for the Admin
	 */

	// this only show for Admin role user

	public static void showAdminMenu() throws IOException {
		while (true) {

			System.out.println("Press E for Employees");
			System.out.println("Press M for Managers");
			System.out.println("Press A for Admin");
			System.out.println("Press ALL for All");
			System.out.println("To log out (Press O)");
			System.out.println("To Exit (Press X)");

			scanner = new Scanner(System.in);
			String input = scanner.next();
			if (input.equalsIgnoreCase("E")) {
				viewAlltabuler("employee");
				showManagerlist("admin");

			} else if (input.equalsIgnoreCase("M")) {
				viewAlltabuler("manager");
				showManager("admin");

			} else if (input.equalsIgnoreCase("A")) {
				viewAlltabuler("admin");
				showAdmin("admin");
			} else if (input.equalsIgnoreCase("ALL")) {
				viewAlltabuler("*");
				showAdminMenu();

			} else if (input.equalsIgnoreCase("O")) {
				System.out.println("\nLog out \n");
				displayInfo();
			} else if (input.equalsIgnoreCase("X")) {
				System.out.println("\nExit \n");
				System.exit(0);
			} else {

				System.out.println("Wrong input");
			}

		}

	}

}
