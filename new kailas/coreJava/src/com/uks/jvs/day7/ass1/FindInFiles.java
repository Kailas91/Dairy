package com.uks.jvs.day7.ass1;

import java.io.File;
import java.util.Scanner;

/**
 * Date:26/06/2019 Assignment: Day 7 Task: Find String In Files program
 *
 * @author Kailas
 */
public class FindInFiles {
	boolean status = false;
	int count = 0;

	/**
	 * this method searches a directory recursively.
	 *
	 * @dir- search directory.
	 * @search-search keyword.
	 */

	public void findFiles(String search, File dir) {

		try {
			if (dir.exists() && dir.isDirectory()) {
				if (dir.list().length > 0) {

					File[] files = dir.listFiles();
					for (File file : files) {
						if (file.exists() && file.isDirectory() && !dir.getName().equals("$RECYCLE.BIN")) {
							System.out.println("directory" + file.getCanonicalPath() + "\t" + "not found");

							// this is a recursive call
							findFiles(search, file);
						} else {
							@SuppressWarnings("unused")
							File file1 = new File(file.getCanonicalPath());
							Scanner scanner = new Scanner(file);
							int lineNo = 0;
							while (scanner.hasNextLine()) {
								String line = scanner.nextLine();
								lineNo++;
								if (line.equals(search) || line.contains(search)) {
									status = true;
									System.out.println("file path :" + file.getCanonicalPath() + " " + "line no :\t"
											+ lineNo + " " + "your string : \t" + search);
								}

							}
							scanner.close();
						}

					}
				} else {
					System.out.println("Directory is empty");
				}
			}
			else {
				System.out.println("Directory not present");
			}
		} catch (Exception e) {

		}

		// used print message once if no match the string
		if (status == false) {
			if (count == 1) {
				System.out.println("no match found");
			}
			count++;
		}

	}

}
