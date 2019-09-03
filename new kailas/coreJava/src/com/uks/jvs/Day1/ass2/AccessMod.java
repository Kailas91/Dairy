package com.uks.jvs.Day1.ass2;
/**
 * Date:18/06/2019
 * Assignment: Day 1
 * Task: Access Modifier in java
 * @author Kailas
 */
public class AccessMod {
	public int intVar = 18;
	public long longVar = 198l;
	protected float floatVar = 1.5f;
	protected double doubleVar = 10.0;
	char charVar = 'A';
	private String stringVar = "kailas";
	boolean boolVar = false;
	public void printProperties() {	// create method for printing data
		System.out.println("intvar =" + intVar + "\n longVar =" + longVar + "\n stringVar =" + stringVar + "\n floatVar ="+ floatVar + "\n doubleVar =" + doubleVar + "\n charVar=" + charVar + "\n boolVar =" + boolVar);
	}
}
