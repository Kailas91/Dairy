package com.uks.jvs.day7.ass2;
import java.io.File;

/**
 * Date:26/06/2019
 * Assignment: Day 7
 * Task: Testing java Program performance
 *
 * @author Kailas
 */
import com.uks.jvs.day7.ass1.FindInFiles;

public class ExecutionInfo {

	public static void main(String args[]) {
		FindInFiles objFindInFiles = new FindInFiles();
		Runtime rs = Runtime.getRuntime();
		// I assume you will know how to create a object Person yourself...
		// Get the Java runtime
		// Calculate the used memory
		try {
			long memory = rs.totalMemory() - rs.freeMemory();
			System.out.println("Before program calling Used memory is bytes: " + memory);
			System.out.println(
					"Before program calling Free memory in JVM before Garbage Collection = " + rs.freeMemory());
			long startTime = System.currentTimeMillis();
			System.out.println("*****************************************************************************************\n");
			File currentDir = new File(args[1]);
			objFindInFiles.findFiles(args[0], currentDir);
			System.out.println("******************************************************************************************\n");
			long stopTime = System.currentTimeMillis();
			System.out.println("After time taken for  execution is : " + (stopTime - startTime) + "ms");
			long memoryafter = rs.totalMemory() - rs.freeMemory();
			System.out.println("After execution Used memory is bytes: " + memoryafter);
			// Run the garbage collector
			rs.gc();
			System.out.println("After execution Free memory in JVM after Garbage Collection = " + rs.freeMemory());
		} catch (Exception e) {
			System.err.println("Enter string name and directory path in commandline argument");
			// TODO Auto-generated catch bloc
		} finally {
			objFindInFiles = null;
		}
	}

}
