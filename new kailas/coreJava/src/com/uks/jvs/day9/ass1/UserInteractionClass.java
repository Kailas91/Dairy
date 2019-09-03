package com.uks.jvs.day9.ass1;

/**
 * Date:28/06/2019
 * Assignment: Day 9
 * Task: UserInteraction Class
 *
 * @author Kailas
 */

public class UserInteractionClass {

	/**
	 * Description : main class contain all class object and start all thread
	 *
	 * @param args
	 * @throws InterruptedException
	 */

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		try {
			/**
			 * Creates thread to load data from user info file
			 */

			// it will pass user mode to start the user thread
			LoaderProcess loadUserDetails = new LoaderProcess("user");

			loadUserDetails.setName("UserInfoLoader");
			loadUserDetails.start();

			/**
			 * Creates thread to load data from user login info file.
			 */
			LoaderProcess loadLoginDetails = new LoaderProcess("login");
			loadUserDetails.join();
			loadLoginDetails.setName("LoginInfoLoader");
			loadLoginDetails.start();
			loadLoginDetails.join();
			LoaderProcess.mergeInfo();

			/**
			 * Starts the user interface
			 */
			FinderProcess finderProcess = new FinderProcess();
			finderProcess.start();

		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + " : failed to load data");
		}

	}

}
