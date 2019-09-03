package com.uks.jvs.day2.ass5;

/**
 * Date:19/06/2019
 * Assignment: Day 2
 * Task: RunTmeTest class
 * @author Kailas
 */
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class RuntimeTest {//

	public void openNotepadWithProcessBuilderClass() {//
		/**
		 * method checkChar with process builder class return type : void
		 */
		ProcessBuilder objProcessBuilder = new ProcessBuilder("Notepad.exe", "sample.txt");
		try {
			objProcessBuilder.start();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public void openNotepadWithRuntimeClass() {//
		/**
		 * method with runtime class return type : void
		 */
		// here we create object of RunTime class to start the note pad process
		Runtime objRuntime = Runtime.getRuntime();
		try { // any exception handle using try catch block i9n process builder
			objRuntime.exec("C:\\Windows\\notepad.exe C:\\test.txt");
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * method printing environment variables return type : void
	 */
	public void printEnvironmentVariables() {//

		ProcessBuilder pb = new ProcessBuilder();
		// here environment variables stored in key values format
		Map<String, String> envMap = pb.environment();
		Set<String> keys = envMap.keySet();
		for (String key : keys) {
			System.out.println(key + " ==> " + envMap.get(key));
		}
	}

	// it contains main method
	public static void main(String[] args) {
		// create object of RunTime class call the methods
		RuntimeTest objRuntimeTest = new RuntimeTest();
		// open note pad using ProcessBuilder class
		objRuntimeTest.openNotepadWithProcessBuilderClass();
		// open note pad using RunTime class
		objRuntimeTest.openNotepadWithRuntimeClass();
		objRuntimeTest.printEnvironmentVariables();
	}
}