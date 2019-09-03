package com.uks.jvs.day8.ass3;


/**
 * Date:27/06/2019
 * Assignment: Day 8
 * Task:Test Thread  in Java
 *
 * @author Kailas
 */
import java.io.IOException;
import java.util.ResourceBundle;

public class EmpInfoMerger {
	/**
	 * This method is used to take input as files
	 *
	 * @param args
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws IOException, InterruptedException {
		EmpInfoProperties name, address, merge = null;
		try {
			ResourceBundle rb = ResourceBundle.getBundle("com.uks.jvs.filePath");

			name = new EmpInfoProperties("thread_1", "read", rb.getString("name"));
			address = new EmpInfoProperties("thread_2", "read", rb.getString("address"));
			merge = new EmpInfoProperties("thread_3", "write", rb.getString("merge"));

			address.start();
			name.start();
			// Thread.sleep(1000);
			merge.join();
			// thread2.sleep(1000);
			address.join();
			merge.start();
			Thread.sleep(2000);
			merge.join();
			merge.printAll();
		} catch (Exception exception) {
			System.out.println("properties file not found");

		} finally {
			name = null;
			address = null;
			merge = null;
		}

	}
}
