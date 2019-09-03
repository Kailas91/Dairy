package com.uks.jvs.day2.ass5;

/**
 * Date:19/06/2019
 * Assignment: Day 2
 * Task: ArrayPopulation Program
 *
 * @author Kailas
 */
class ProcessBuilderDemo {
	// it contains main method
	public static void main(String arg[]) {
		try // this will exception in program when any error occurred on opening
			// note pad
		{
			// processBuilder class are used to start any service on computer
			ProcessBuilder proc = new ProcessBuilder("notepad.exe", "testfile");
			// start method used execute that ProcessBuilder Request to start
			// note pad
			proc.start();
			// this will catch that exception and display
		} catch (Exception exception) {
			System.out.println("Error Executing notepad." + exception);
		}
	}
}