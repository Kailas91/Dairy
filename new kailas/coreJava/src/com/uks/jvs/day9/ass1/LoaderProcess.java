package com.uks.jvs.day9.ass1;

/**
 * Date:28/06/2019
 * Assignment: Day 9
 * Task: LoderProcess  class
 *
 * @author Kailas
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

// load the data from files using properties files
@SuppressWarnings("unused")
public class LoaderProcess extends Thread {

	/**
	 * Shared variable for user info
	 */

	private volatile static StringBuffer UIsharedResource = new StringBuffer();

	/**
	 * Shared variable for user login info
	 */

	private volatile static StringBuffer ULIsharedResource = new StringBuffer();

	// check mode user login info or user info
	private String mode = "";

	private static String resourcePath = null;

	public static Map<String, HashMap<String, String>> mergedInfo = new TreeMap<>();
	public static Map<String, HashMap<String, String>> userLoginInfo = new HashMap<>();

	public LoaderProcess(String mode) {
		this.mode = mode;
	}

	// default constructor of this class
	public LoaderProcess() {

	}

	/**
	 * Method to run the thread. and check mode is user or login
	 */
	public void run() {
		String path = "";
		Properties pathPro = new Properties();
		InputStream input = null;
		try {
			// get the path of user files using config properties file
			input = new FileInputStream("src\\com\\uks\\jvs\\" + "day9\\ass1\\resources\\config.properties");
			pathPro.load(input);

			if (mode.equalsIgnoreCase("user")) {
				path = pathPro.getProperty("user");
				writeToResource(path);

			} else if (mode.equalsIgnoreCase("login")) {
				path = pathPro.getProperty("login");
				writeToResource(path);

			}
			// if path of file is incorrect
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("properties file not found");
			System.exit(0);
		}

	}

	/**
	 *
	 * @param path
	 *            Read from the file and write to shared resources.
	 */

	// Only one thread can write data to shared variables at a time. thats why
	// used synchronization

	synchronized public void writeToResource(String path) {
		File file = null;
		FileInputStream fileInputStream = null;
		BufferedReader bufferReader = null;

		try {

			file = new File(path);
			fileInputStream = new FileInputStream(file);
			bufferReader = new BufferedReader(new InputStreamReader(fileInputStream));

			String line = "";

			if (mode.equalsIgnoreCase("user")) {

				while ((line = bufferReader.readLine()) != null) {

					// add user details to shared variables
					UIsharedResource.append(line);
					UIsharedResource.append("\n");
				}

			} else if (mode.equalsIgnoreCase("login")) {

				while ((line = bufferReader.readLine()) != null) {
					// add user login details to shared variables
					ULIsharedResource.append(line);
					ULIsharedResource.append("\n");
				}

			}

		} catch (IOException e) {
			System.out.println("file path are not correct");
			System.exit(0);
		}

	}

	/**
	 * method to Merge all the info to the Collection objects
	 */

	public static void mergeInfo() {

		// to get user info
		String[] userInfo = UIsharedResource.toString().split("\n");
		// to get user login details
		String[] userLoginDetails = ULIsharedResource.toString().split("\n");

		for (int i = 0; i < userInfo.length; i++) {
			// Separate user info by ","
			String[] tempUI = userInfo[i].split(",");
			String[] tempULI = userLoginDetails[i].split(",");

			HashMap<String, String> temp = new HashMap<>();

			temp.put("Name", tempUI[1]);
			if (tempUI[2].length() <= 40) {
				temp.put("Address", tempUI[2]);
			} else {
				System.out.println("Address cannot be more than 40 chars");
				System.exit(0);
			}
			if (tempUI[3].length() <= 16) {
				temp.put("City", tempUI[3]);
			} else {
				System.out.println("city cannot be more than 16 chars");
				System.exit(0);
			}

			try {

				double basicSal = Double.parseDouble(tempUI[4]);
				BigDecimal salary = new BigDecimal(((basicSal * 12) / 100) + basicSal);
				temp.put("Salary", String.valueOf(salary));
			} catch (NumberFormatException e) {
				System.out.println("Basic salary should be in numeric only");
				System.exit(0);
			}
			try {
				long t = Long.parseLong(tempUI[5]);
				temp.put("TelNumber", String.valueOf(t));
			} catch (NumberFormatException e) {
				System.out.println("TelNumber should be in Numbres only");
				System.exit(0);
			}
			temp.put("UserRole", tempULI[3]);

			mergedInfo.put(String.valueOf(i + 1), temp);

		}

		/**
		 * for userLoginInfo Map
		 */

		for (int i = 0; i < userLoginDetails.length; i++) {
			String[] tempULI = userLoginDetails[i].split(",");

			HashMap<String, String> data = new HashMap<>();
			data.put("id", tempULI[0]);
			data.put("username", tempULI[1]);
			data.put("password", tempULI[2]);
			data.put("role", tempULI[3]);
			userLoginInfo.put(String.valueOf((i + 1)), data);

		}
	}
}
