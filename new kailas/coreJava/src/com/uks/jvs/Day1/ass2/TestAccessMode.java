package com.uks.jvs.Day1.ass2;
/**
 * Date:18/06/2019
 * Assignment: Day 1
 * Task: Testing Access Modifier in java
 * @author Kailas
 */
public class TestAccessMode {
	public static void main(String args[]) {// it contain main method
		AccessMod objAccessmod = new AccessMod();		// create AccessMod class object to call printProperties method to access all variables
		objAccessmod.printProperties();
		System.out.println("int var" + objAccessmod.intVar);	// trying To access all variables without string variable
		System.out.println("long int" + objAccessmod.longVar);
		System.out.println("float var" + objAccessmod.floatVar);
		System.out.println("double var" + objAccessmod.doubleVar);
		System.out.println("character var" + objAccessmod.charVar);
		// System.out.println("string var"+objAccessmod.stringVar); here String // String variable is not accessible because it is private
		System.out.println("boolean var" + objAccessmod.boolVar);
	}
}
