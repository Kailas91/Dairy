package com.uks.jvs.day7.ass1;

import java.io.File;
/**
 * Date:26/06/2019
 * Assignment: Day 7
 * Task: Testing FindInFiles Program
 *
 * @author Kailas
 */
public class TestFindInFiles {

	public static void main(String args[]) {

		FindInFiles objFindInFiles = new FindInFiles();
		try {
			 File currentDir = new File(args[1]);
			objFindInFiles.findFiles(args[0], currentDir);
		} catch (Exception e) {
			System.err.println("Enter string name and directory path in commandline argument");
			// TODO Auto-generated catch bloc
		} finally {
			objFindInFiles = null;
		}
	}
}
