package com.uks.jvs.day3.ass1;

/**
 * Date:20/06/2019
 * Assignment: Day 3
 * Task: show system properties Program
 * @author Kailas
 */
public class ShowSystemProperties {


		// it contains main method
	    public static void main(String args[])
	    {

	        	// create SystemProperties object to print call methods
	        	SystemProperties objSystemProperties = new SystemProperties();
	        	objSystemProperties.allMethods(String.join(" ", args[0]));
	    }

}
