package com.uks.jvs.day4.ass2;

/**
 * Date:21/06/2019
 * Assignment: Day 4
 * Task: Polymorphism through method
 * overloading
 *
 * @author Kailas
 */
public class Circle {
	// declare constant value of PI variable
	final static double PI = 3.14159;
	double areaOfCircle;

	// here areaOfCircle method will get double type argument
	public void areaOfCircle(double radius) {
		System.out.println("Area of Circle using double type is: " + PI * radius * radius);

	}

	// here areaOfCircle method is same but different type of parameter
	public void areaOfCircle(long radius) {
		// print area of circle
		System.out.println("Area of Circle using long type is: " + PI * radius * radius);

	}

	public static void main(String args[]) {

		// create circle class object to call areaOfCircle() method
		Circle objCircle = new Circle();
		objCircle.areaOfCircle(3);
		objCircle.areaOfCircle(5.6);

	}

}
