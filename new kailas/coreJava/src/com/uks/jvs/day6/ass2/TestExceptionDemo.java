package com.uks.jvs.day6.ass2;

/**
 * Date:25/06/2019
 * Assignment: Day 6
 * Task: Class TestExceptionDemo tests the ExceptionDemo class
 *
 * @author Kailas
 */
public class TestExceptionDemo {
	public static void main(String[] args) {
		ExceptionDemo demo = new ExceptionDemo();
		demo.generateException();
		demo.generateIOException();
		demo.generateFileNotFoundException(args[0]);

	}

}
