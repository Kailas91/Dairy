package com.uks.jvs.Day1.ass4;
/**
 * Date:18/06/2019
 * Assignment: Day 1
 * Task: Test MultiCommand line Argument in java
 * @author Kailas
 *
 */
public class TestMultiCommandline {
	public static void main(String[] args) {// it contain main method
		MultiCommandline commandLine = new MultiCommandline();// create MultiCommandline object for calling doOperation Method to pass argument
		commandLine.doOperation(args);
	}
}
